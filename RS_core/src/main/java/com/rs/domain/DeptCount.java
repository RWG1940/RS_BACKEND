package com.rs.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @FileName: DeptCount
 * @Date: 2024/8/5:22:05
 * @Description:
 * @Author: RWG
 */
@Data
@ApiModel(value = "部门计数实体")
public class DeptCount {
    private Integer eDeptId;
    private Integer dTotal;

}
