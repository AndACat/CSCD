package com.cscd.services;

import com.cscd.bos.DeviceDataBo;
import com.cscd.dos.DeviceDataDo;
import com.cscd.dao.DeviceDataDao;
import com.cscd.utils.ConvertUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceDataService {
    @Autowired
    private DeviceDataDao deviceDataDao;
    @Autowired
    private ConvertUtil convertUtil;

    public List<DeviceDataBo> selectAllDeviceData(){
        List<DeviceDataDo> deviceDataDoList = deviceDataDao.selectAllDeviceData();
        List<DeviceDataBo> deviceDataBoList = new ArrayList<>();
        deviceDataDoList.stream().forEach(deviceDataDo -> deviceDataBoList.add(convertUtil.toDeviceDataBo(deviceDataDo)));
        return deviceDataBoList;
    }

    public List<DeviceDataBo> selectDeviceDataByCompanyUid(String companyUid){
        List<DeviceDataDo> deviceDataDoList = deviceDataDao.selectDeviceDataByCompanyUid(companyUid);
        List<DeviceDataBo> deviceDataBoList = new ArrayList<>();
        deviceDataDoList.stream().forEach(deviceDataDo -> deviceDataBoList.add(convertUtil.toDeviceDataBo(deviceDataDo)));
        return deviceDataBoList;
    }

    public List<DeviceDataBo> selectDeviceDataByDeviceUid(String deviceUid, Integer limit){
        List<DeviceDataDo> deviceDataDoList = deviceDataDao.selectDeviceDataByDeviceUid(deviceUid, limit);
        List<DeviceDataBo> deviceDataBoList = new ArrayList<>();
        deviceDataDoList.stream().forEach(deviceDataDo -> deviceDataBoList.add(convertUtil.toDeviceDataBo(deviceDataDo)));
        return deviceDataBoList;
    }

    public List<DeviceDataBo> selectDeviceDataByWarn(){
        List<DeviceDataDo> deviceDataDoList = deviceDataDao.selectDeviceDataByWarn();
        List<DeviceDataBo> deviceDataBoList = new ArrayList<>();
        deviceDataDoList.stream().forEach(deviceDataDo -> deviceDataBoList.add(convertUtil.toDeviceDataBo(deviceDataDo)));
        return deviceDataBoList;
    }


    public Boolean insertDeviceData(DeviceDataBo deviceDataBo){
        DeviceDataDo deviceDataDo = convertUtil.toDeviceDataDo(deviceDataBo);
        Boolean aBoolean = deviceDataDao.insertDeviceData(deviceDataDo);
        return aBoolean;
    }

    public Boolean deleteDeviceDataByUid(String uid){
        Boolean aBoolean = deviceDataDao.deleteDeviceDataByUid(uid);
        return aBoolean;
    }

    public Integer selectWarnDeviceDataByCompanyUid(LocalDateTime minDate, LocalDateTime maxDate, String companyUid) {
        Integer count = deviceDataDao.selectWarnDeviceDataByCompanyUid(minDate, maxDate, companyUid);
        return count;
    }


}
