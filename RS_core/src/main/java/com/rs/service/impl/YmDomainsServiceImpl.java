package com.rs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rs.domain.YmDomains;
import com.rs.service.YmDomainsService;
import com.rs.mapper.YmDomainsMapper;
import org.apache.commons.net.whois.WhoisClient;
import org.springframework.stereotype.Service;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class YmDomainsServiceImpl extends ServiceImpl<YmDomainsMapper, YmDomains>
        implements YmDomainsService {
    @Override
    public void updateAllDomainExpiries() {
        List<YmDomains> domainList = this.list(); // 从数据库读取所有记录

        for (YmDomains domainInfo : domainList) {
            String domain = domainInfo.getDomain();
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            domainInfo.setUpdatetime(date);
            try {
                String whoisData = fetchWhoisData(domain);
                parseWhoisInfo(domainInfo, whoisData);

                List<String> mxRecords = fetchMXRecords(domain);
                domainInfo.setDnsRecords(String.join(",", mxRecords));
            } catch (Exception e) {
                // 捕获异常避免中断
            }
        }

        this.updateBatchById(domainList);
    }

    private String fetchWhoisData(String domain) throws IOException {
        String whoisServer = getWhoisServer(domain);

        WhoisClient whois = new WhoisClient();
        whois.connect(whoisServer);
        String result = whois.query(domain);
        whois.disconnect();
        return result;
    }

    private String getWhoisServer(String domain) {
        if (domain.endsWith(".com") || domain.endsWith(".net")) {
            return "whois.verisign-grs.com";
        } else if (domain.endsWith(".cn")) {
            return "whois.cnnic.cn";
        } else if (domain.endsWith(".org")) {
            return "whois.pir.org";
        } else if (domain.endsWith(".info")) {
            return "whois.afilias.info";
        }
        return "whois.iana.org";
    }

    private void parseWhoisInfo(YmDomains domainInfo, String whoisData) {
        String expDate = extractDate(whoisData);

        if (expDate != null) {
            try {
                LocalDate localDate = LocalDate.parse(expDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                domainInfo.setExpirationDate(java.sql.Date.valueOf(localDate));

                long days = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
                domainInfo.setRemainingDays(String.valueOf(days));
            } catch (Exception e) {
                domainInfo.setRemainingDays("到期日期解析错误: " + e.getMessage());
            }
        } else {
            domainInfo.setRemainingDays("未找到到期时间");
        }

        if (whoisData.contains("Registrar:"))
            domainInfo.setRegistrar(getLineValue(whoisData, "Registrar:"));

        if (whoisData.contains("Domain Status:"))
            domainInfo.setStatus(extractMultiLineValues(whoisData, "Domain Status:"));
    }

    private List<String> fetchMXRecords(String domain) {
        List<String> result = new ArrayList<>();
        try {
            Lookup lookup = new Lookup(domain, Type.MX);
            Record[] records = lookup.run();
            if (records != null) {
                for (Record record : records) {
                    MXRecord mx = (MXRecord) record;
                    result.add(mx.getTarget().toString());
                }
            }
        } catch (Exception e) {
            result.add("DNS查询失败: " + e.getMessage());
        }
        return result;
    }

    private String getLineValue(String text, String key) {
        for (String line : text.split("\n")) {
            if (line.startsWith(key)) {
                return line.replace(key, "").trim();
            }
        }
        return null;
    }

    private String extractMultiLineValues(String text, String key) {
        StringBuilder sb = new StringBuilder();
        for (String line : text.split("\n")) {
            if (line.trim().startsWith(key)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(line.trim().substring(key.length()).trim());
            }
        }
        return sb.toString();
    }

    private String extractDate(String whoisData) {
        for (String line : whoisData.split("\n")) {
            line = line.trim();

            if (line.startsWith("Registry Expiry Date:")) {
                String dateStr = line.substring("Registry Expiry Date:".length()).trim();
                if (dateStr.contains("T")) {
                    return dateStr.split("T")[0];
                } else {
                    return dateStr;
                }
            }

            if (line.startsWith("Expiration Time:")) {
                String dateStr = line.substring("Expiration Time:".length()).trim();
                if (dateStr.contains(" ")) {
                    return dateStr.split(" ")[0];
                } else {
                    return dateStr;
                }
            }
        }

        return null;
    }
}