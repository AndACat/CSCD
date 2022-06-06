package com.cscd.utils;

import com.cscd.bos.*;
import com.cscd.dao.*;
import com.cscd.dos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * 类型转换类
 * 将do类转为bo类
 * 将bo类转为do类
 */
public class ConvertUtil {

    @Autowired
    private CompanyDailyDao companyDailyDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceDataDao deviceDataDao;
    @Autowired
    private RegionDao regionDao;

    public CompanyDailyBo toCompanyDailyBo(CompanyDailyDo companyDailyDo, boolean deepQuery){
        return companyDailyDo == null ? null : new CompanyDailyBo(
                companyDailyDo.getUid(),
                toCompanyBo(companyDao.selectCompanyByUid(companyDailyDo.getCompanyUid()), deepQuery),
                companyDailyDo.getBoom(),
                companyDailyDo.getFire(),
                companyDailyDo.getUpdateDate()
        );
    }
    public CompanyDailyDo toCompanyDailyDo(CompanyDailyBo companyDailyBo){
        return companyDailyBo == null ? null : new CompanyDailyDo(
                companyDailyBo.getUid(),
                companyDailyBo.getCompany() == null ? null : companyDailyBo.getCompany().getUid(),
                companyDailyBo.getBoom(),
                companyDailyBo.getFire(),
                companyDailyBo.getUpdateDate()
        );
    }

    public CompanyBo toCompanyBo(CompanyDo companyDo, boolean deepQuery){
        return companyDo == null ? null : new CompanyBo(
                companyDo.getUid(),
                companyDo.getCompanyName(),
                !deepQuery ? null : toRegionBo(regionDao.selectRegionByRegionId(companyDo.getRegionId())),
                companyDo.getEquipmentNum(),
                companyDo.getDescribes(),
                companyDo.getUpdateDate()
        );
    }
    public CompanyDo toCompanyDo(CompanyBo companyBo){
        return companyBo == null ? null : new CompanyDo(
                companyBo.getUid(),
                companyBo.getCompanyName(),
                companyBo.getRegion() == null ? null : companyBo.getRegion().getRegionId(),
                companyBo.getEquipmentNum(),
                companyBo.getDescribes(),
                companyBo.getUpdateDate()
        );
    }

    public RegionBo toRegionBo(RegionDo regionDo){
        return regionDo == null ? null : new RegionBo(
                regionDo.getRegionId(),
                regionDo.getRegionName(),
                regionDo.getRegionShortName(),
                regionDo.getRegionCode(),
                regionDo.getRegionParentId(),
                regionDo.getRegionLevel()
        );

    }
    public RegionDo toRegionDo(RegionBo regionBo){
        return regionBo == null ? null : new RegionDo(
                regionBo.getRegionId(),
                regionBo.getRegionName(),
                regionBo.getRegionShortName(),
                regionBo.getRegionCode(),
                regionBo.getRegionParentId(),
                regionBo.getRegionLevel()
        );

    }

    public DeviceBo toDeviceBo(DeviceDo deviceDo, boolean deepQuery){
        return deviceDo == null ? null : new DeviceBo(
                deviceDo.getUid(),
                deviceDo.getDeviceName(),
                !deepQuery ? null : toCompanyBo(companyDao.selectCompanyByUid(deviceDo.getCompanyUid()), true),
                deviceDo.getTemperatureMin(),
                deviceDo.getTemperatureMax(),
                deviceDo.getHumidityMin(),
                deviceDo.getHumidityMax(),
                deviceDo.getNaturalgasMin(),
                deviceDo.getNaturalgasMax(),
                deviceDo.getAlcoholMin(),
                deviceDo.getAlcoholMax(),
                deviceDo.getIlluminationMin(),
                deviceDo.getIlluminationMax(),
                deviceDo.getHandle(),
                deviceDo.getStates(),
                deviceDo.getUpdateDate()
        );
    }

    public DeviceDo toDeviceDo(DeviceBo deviceBo){
        return deviceBo == null ? null : new DeviceDo(
                deviceBo.getUid(),
                deviceBo.getDeviceName(),
                deviceBo.getCompany() == null ? null : deviceBo.getCompany().getUid(),
                deviceBo.getTemperatureMin(),
                deviceBo.getTemperatureMax(),
                deviceBo.getHumidityMin(),
                deviceBo.getHumidityMax(),
                deviceBo.getNaturalgasMin(),
                deviceBo.getNaturalgasMax(),
                deviceBo.getAlcoholMin(),
                deviceBo.getAlcoholMax(),
                deviceBo.getIlluminationMin(),
                deviceBo.getIlluminationMax(),
                deviceBo.getHandle(),
                deviceBo.getDeviceName(),
                deviceBo.getUpdateDate()
        );
    }

    public DeviceDataBo toDeviceDataBo(DeviceDataDo deviceDataDo, boolean deepQuery){
        return deviceDataDo == null ? null : new DeviceDataBo(
                deviceDataDo.getUid(),
                toCompanyBo(companyDao.selectCompanyByUid(deviceDataDo.getCompanyUid()), deepQuery),
                !deepQuery ? null : toDeviceBo(deviceDao.selectDeviceByUid(deviceDataDo.getDeviceUid()), true),
                deviceDataDo.getTemperature(),
                deviceDataDo.getHumidity(),
                deviceDataDo.getNaturalgas(),
                deviceDataDo.getAlcohol(),
                deviceDataDo.getIllumination(),
                deviceDataDo.getTemperatureWarn(),
                deviceDataDo.getHumidityWarn(),
                deviceDataDo.getNaturalgasWarn(),
                deviceDataDo.getAlcoholWarn(),
                deviceDataDo.getIlluminationWarn(),
                deviceDataDo.getUpdateDate()
        );
    }

    public DeviceDataDo toDeviceDataDo(DeviceDataBo deviceDataBo){
        return deviceDataBo == null ? null : new DeviceDataDo(
                deviceDataBo.getUid(),
                deviceDataBo.getCompany() == null ? null : deviceDataBo.getCompany().getUid(),
                deviceDataBo.getDevice() == null ? null : deviceDataBo.getDevice().getUid(),
                deviceDataBo.getTemperature(),
                deviceDataBo.getHumidity(),
                deviceDataBo.getNaturalgas(),
                deviceDataBo.getAlcohol(),
                deviceDataBo.getIllumination(),
                deviceDataBo.getTemperatureWarn(),
                deviceDataBo.getHumidityWarn(),
                deviceDataBo.getNaturalgasWarn(),
                deviceDataBo.getAlcoholWarn(),
                deviceDataBo.getIlluminationWarn(),
                deviceDataBo.getUpdateDate()
        );
    }

}
