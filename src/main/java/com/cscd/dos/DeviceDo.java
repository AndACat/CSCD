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
 * 设备Do类
 */
public class DeviceDo {
    /**
     * 主键
     */
    private String uid;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 所属公司uid
     */
    private String companyUid;
    /**
     *设备温度要求的最低值
     */
    private Float temperatureMin;
    /**
     *设备温度要求的最高值
     */
    private Float temperatureMax;
    /**
     *设备湿度要求的最低值
     */
    private Float humidityMin;
    /**
     *设备湿度要求的最高值
     */
    private Float humidityMax;
    /**
     *设备天然气要求的最低值
     */
    private Float naturalgasMin;
    /**
     *设备天然气要求的最高值
     */
    private Float naturalgasMax;
    /**
     *设备酒精要求的最低值
     */
    private Float alcoholMin;
    /**
     *设备酒精要求的最高值
     */
    private Float alcoholMax;
    /**
     *设备光照要求的最低值
     */
    private Float illuminationMin;
    /**
     *设备光照要求的最高值
     */
    private Float illuminationMax;
    /**
     *  是否处置
     *  True: 已处置
     *  False: 没处置或无需处置
     */
    private Boolean handle;
    /**
     *  行为
     *  1. 在线
     *  2. 离线
     *  3. 设备告警
     */
    private String states;
    /**
     *更新时间
     */
    private LocalDateTime updateDate;
}
