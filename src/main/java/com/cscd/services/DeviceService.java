package com.cscd.services;

import com.cscd.bos.DeviceBo;
import com.cscd.bos.DeviceDataBo;
import com.cscd.dos.DeviceDataDo;
import com.cscd.dos.DeviceDo;
import com.cscd.dao.DeviceDao;
import com.cscd.utils.ConvertUtil;
import com.cscd.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private Util util;
    @Autowired
    private CompanyService companyService;

    public List<DeviceBo> selectAllDevice(boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectAllDevice();
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public DeviceBo selectDeviceByUid(String uid, boolean deepQuery){
        DeviceDo deviceDo = deviceDao.selectDeviceByUid(uid);
        DeviceBo deviceBo = convertUtil.toDeviceBo(deviceDo, deepQuery);
        return deviceBo;
    }

    public List<DeviceBo> selectDeviceByCompanyUid(String companyUid, boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectDeviceByCompanyUid(companyUid);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public Boolean deleteDeviceByDeviceUid(String deviceUid){
        Boolean aBoolean = deviceDao.deleteDeviceByDeviceUid(deviceUid);
        return aBoolean;
    }

    public Boolean insertDevice(DeviceBo deviceBo){
        deviceBo.setUid(util.getRandomUid());
        DeviceDo deviceDo = convertUtil.toDeviceDo(deviceBo);
        Boolean aBoolean = deviceDao.insertDevice(deviceDo);
        companyService.addCompanyEquipmentNumByUid(deviceDo.getCompanyUid());
        return aBoolean;
    }

    public Boolean updateDeviceInfo(String uid, Boolean handle, String states){
        Boolean aBoolean = deviceDao.updateDeviceInfo(uid, handle, states);
        return aBoolean;
    }

    public List<DeviceBo> selectAllOnlineDevice(boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectAllOnlineDevice();
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public List<DeviceBo> selectAllOfflineDevice(boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectAllOfflineDevice();
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public List<DeviceBo> selectAllWarnDevice(int limit, boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectAllWarnDevice(limit);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public List<DeviceBo> selectOnlineDeviceByCompanyUid(String companyUid, boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectOnlineDeviceByCompanyUid(companyUid);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public List<DeviceBo> selectOfflineDeviceByCompanyUid(String companyUid, boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectOfflineDeviceByCompanyUid(companyUid);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public List<DeviceBo> selectWarnDeviceByCompanyUid(String companyUid, boolean deepQuery){
        List<DeviceDo> deviceDoList = deviceDao.selectWarnDeviceByCompanyUid(companyUid);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, deepQuery)));
        return deviceBoList;
    }

    public Integer selectAllOnlineDeviceCount() {
        Integer count = deviceDao.selectAllOnlineDeviceCount();
        return count;
    }
    public Integer selectAllOfflineDeviceCount() {
        Integer count = deviceDao.selectAllOfflineDeviceCount();
        return count;
    }
    public Integer selectAllWarnDeviceCount() {
        Integer count = deviceDao.selectAllWarnDeviceCount();
        return count;
    }

    public Integer selectAllDeviceCount() {
        Integer integer = deviceDao.selectAllDeviceCount();
        return integer;
    }

    /**
     * 查询指定时期之间的告警设备信息
     * @param minDate
     * @param maxDate
     * @return
     */
    public List<DeviceBo> selectWarnDevicesByDate(LocalDateTime minDate, LocalDateTime maxDate){
        List<DeviceDo> deviceDataDoList = deviceDao.selectWarnDevicesByDate(minDate, maxDate);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDataDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, true)));
        return deviceBoList;
    }

    /**
     * 查询一个地区的告警设备数量
     * @param regionId
     * @return
     */
    public List<DeviceBo> selectWarnDevicesByPlace(String regionId) {
        List<DeviceDo> deviceDoList = deviceDao.selectWarnDevicesByPlace(regionId);
        List<DeviceBo> deviceBoList = new ArrayList<>();
        deviceDoList.stream().forEach(deviceDo -> deviceBoList.add(convertUtil.toDeviceBo(deviceDo, true)));
        return deviceBoList;
    }
}
