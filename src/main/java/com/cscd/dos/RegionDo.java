package com.cscd.dos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 地区Do类
 */
public class RegionDo {
    /**
     * 地区Id
     */
    private String regionId;
    /**
     * 地区名称
     */
    private String regionName;
    /**
     * 地区缩写
     */
    private String regionShortName;
    /**
     * 地区编码
     */
    private String regionCode;
    /**
     * 地区所属父级编码
     */
    private String regionParentId;
    /**
     * 地区层级
     */
    private Integer regionLevel;
}
