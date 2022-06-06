package com.cscd.bos;

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
public class DeviceDataBo {
    /**
     * 主键
     */
    private String uid;
    /**
     * 所属公司
     */
    private CompanyBo company;
    /**
     * 所属设备u
     */
    private DeviceBo device;
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

    public DeviceDataBo(String uid, CompanyBo company, DeviceBo device, Float temperature, Float humidity, Float naturalgas, Float alcohol, Float illumination, LocalDateTime updateDate) {
        this.uid = uid;
        this.company = company;
        this.device = device;
        this.temperature = temperature;
        this.humidity = humidity;
        this.naturalgas = naturalgas;
        this.alcohol = alcohol;
        this.illumination = illumination;
        this.updateDate = updateDate;
        this.temperatureWarn = !(device.getTemperatureMin() < temperature && temperature < device.getTemperatureMax());
        this.humidityWarn = !(device.getHumidityMin() < humidity && humidity < device.getHumidityMax());
        this.naturalgasWarn = !(device.getNaturalgasMin() < naturalgas && naturalgas < device.getNaturalgasMax());
        this.alcoholWarn = !(device.getAlcoholMin() < alcohol && alcohol < device.getAlcoholMax());
        this.illuminationWarn = !(device.getIlluminationMin() < illumination && illumination < device.getIlluminationMax());
    }
}
