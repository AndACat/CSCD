package com.cscd.controller;

import com.cscd.bos.DeviceBo;
import com.cscd.bos.DeviceDataBo;
import com.cscd.bos.P5;
import com.cscd.services.DeviceDataService;
import com.cscd.utils.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeviceDataController {
    @Autowired
    private DeviceDataService deviceDataService;
    @RequestMapping("/devicedata/query")
    public RespMsg queryDevice(@RequestParam("deviceUid") String deviceUid, @RequestParam(value = "limit", required = false) Integer limit){
        if(limit == null){
            limit = 10;
        }
        List<DeviceDataBo> deviceDataBoList = deviceDataService.selectDeviceDataByDeviceUid(deviceUid, limit);
        return RespMsg.getOKInstance(deviceDataBoList);
    }
}
