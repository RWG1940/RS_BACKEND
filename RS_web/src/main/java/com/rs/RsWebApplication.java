package com.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsWebApplication.class, args);

        String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String cyan = "\u001B[36m";
        String purple = "\u001B[35m";
        String blue = "\u001B[34m";
        String red = "\u001B[31m";
        String rsLogo =
                purple + bold + "*********************************************\n" +
                        blue + "************    " + cyan + "RRRR   SSSSS   " + blue + "     *********\n" +
                        blue + "************    " + cyan + "R   R  S        " + blue + "    *********\n" +
                        blue + "************    " + cyan + "RRRR   SSSSS    " + blue + "    *********\n" +
                        blue + "************    " + cyan + "R  R       S    " + blue + "    *********\n" +
                        blue + "************    " + cyan + "R   R  SSSSS    " + blue + "    *********\n" +
                        purple + "*********************************************" + reset;
        System.out.println(rsLogo);
        String welcome =
                cyan + "\n\n" + bold + "*********************************************\n" +
                        green + "*             🍁 RS服务后台启动成功！🍁        *\n" +
                        yellow + "*             欢迎使用 RS 后台管理系统！        *\n" +
                        red + "*             作者:RWG ，QQ:1940449715       *\n" +
                        cyan + "*********************************************" + reset;
        System.out.println(welcome);
    }

}
