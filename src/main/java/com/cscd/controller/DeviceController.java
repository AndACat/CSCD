package com.cscd.controller;

import com.cscd.bos.DeviceBo;
import com.cscd.bos.DeviceDataBo;
import com.cscd.services.DeviceService;
import com.cscd.utils.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/device/queryOnlineDeviceCount")
    public RespMsg queryOnlineDeviceCount(){
        Integer integer = deviceService.selectAllOnlineDeviceCount();
        return RespMsg.getOKInstance("查询成功", integer);
    }
    @RequestMapping("/device/queryOfflineDeviceCount")
    public RespMsg queryOfflineDeviceCount(){
        Integer integer = deviceService.selectAllOfflineDeviceCount();
        return RespMsg.getOKInstance("查询成功", integer);
    }
    @RequestMapping("/device/queryWarnDeviceCount")
    public RespMsg queryWarnDeviceCount(){
        Integer integer = deviceService.selectAllWarnDeviceCount();
        return RespMsg.getOKInstance("查询成功", integer);
    }

    @RequestMapping("/device/queryAllOnlineDevice")
    public RespMsg queryAllOnlineDevice(){
        List<DeviceBo> deviceBos = deviceService.selectAllOfflineDevice();
        return RespMsg.getOKInstance(deviceBos);
    }
    @RequestMapping("/device/queryAllOfflineDevice")
    public RespMsg queryAllOfflineDevice(){
        List<DeviceBo> deviceBos = deviceService.selectAllOfflineDevice();
        return RespMsg.getOKInstance(deviceBos);
    }
    @RequestMapping("/device/queryAllWarnDevice")
    public RespMsg queryAllWarnDevice(@RequestParam(value = "limit", required = false)Integer limit){
        if(limit == null){
            limit = 12;
        } else if (limit < 1) {
            limit = 12;
        }
        List<DeviceBo> deviceBos = deviceService.selectAllWarnDevice(limit);
        return RespMsg.getOKInstance(deviceBos);
    }

    @RequestMapping("/device/queryAllDevice")
    public RespMsg queryAllDevice(){
        List<DeviceBo> deviceBos = deviceService.selectAllDevice();
        return RespMsg.getOKInstance(deviceBos);
    }

    @RequestMapping("/device/queryAllDeviceCount")
    public RespMsg queryAllDeviceCount(){
        Integer integer = deviceService.selectAllDeviceCount();
        return RespMsg.getOKInstance(integer);
    }

    @RequestMapping("/device/queryWarnDevicesByDate")
    public RespMsg selectWarnDevicesByDate(@RequestParam("minDate")String min, @RequestParam("maxDate")String max){
        LocalDateTime minDate = LocalDateTime.parse(min, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime maxDate = LocalDateTime.parse(max, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        List<DeviceBo> deviceBos = deviceService.selectWarnDevicesByDate(minDate, maxDate);
        return RespMsg.getOKInstance(deviceBos);
    }



}
