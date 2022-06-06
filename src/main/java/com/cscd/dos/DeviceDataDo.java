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
 * 设备运行状况Do类
 */
public class DeviceDataDo {
    /**
     * 主键
     */
    private String uid;
    /**
     * 所属公司uid
     */
    private String companyUid;
    /**
     * 所属设备uid
     */
    private String deviceUid;
    /**
     * 温度值
     */
    private Float temperature;
    /**
     * 湿度值
     */
    private Float humidity;
    /**
     * 天然气值
     */
    private Float naturalgas;
    /**
     * 酒精值
     */
    private Float alcohol;
    /**
     * 光照值
     */
    private Float illumination;
    /**
     * 温度值告警
     * True:告警
     * False:正常
     */
    private Boolean temperatureWarn;
    /**
     * 湿度值告警
     * True:告警
     * False:正常
     */
    private Boolean humidityWarn;
    /**
     * 天然气值告警
     * True:告警
     * False:正常
     */
    private Boolean naturalgasWarn;
    /**
     * 酒精值告警
     * True:告警
     * False:正常
     */
    private Boolean alcoholWarn;
    /**
     * 光照值告警
     * True:告警
     * False:正常
     */
    private Boolean illuminationWarn;
    /**
     * 更新时间
     */
    private LocalDateTime updateDate;
}
