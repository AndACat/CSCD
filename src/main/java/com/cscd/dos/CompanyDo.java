package com.cscd.dos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

/**
 * 公司Do类
 */
public class CompanyDo {
    /**
     * 主键
     */
    private String uid;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 所属地区id
     */
    private String regionId;
    /**
     * 公司设备数量
     */
    private Integer equipmentNum;
    /**
     * 公司描述
     */
    private String describes;
    /**
     * 更新时间
     */
    private LocalDateTime updateDate;
}
