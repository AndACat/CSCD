package com.cscd.controller;

import com.cscd.bos.P6;
import com.cscd.bos.Po1;
import com.cscd.bos.Po2;
import com.cscd.bos.Po3;
import com.cscd.services.InfoService;
import com.cscd.utils.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("/queryPreviousPlaceDevice")
    public RespMsg queryPreviousPlaceDevice(){
        List<Po1> poList = infoService.queryPreviousPlaceDevice();
        return RespMsg.getOKInstance(poList);
    }

    @RequestMapping("/queryTodayWarnDevicesByCompany")
    public RespMsg queryTodayWarnDevicesByCompany(){
        List<Po2> po2List = infoService.queryCompanyWarn();
        return RespMsg.getOKInstance(po2List);
    }

    @RequestMapping("/queryPreviousPlaceBoom")
    public RespMsg queryPreviousPlaceBoom(@RequestParam(value = "limitDays", required = false)Integer limitDays){
        if(limitDays == null){
            limitDays = 7;
        }else if (limitDays == 0) {
            limitDays = 7;
        }else if(limitDays < 0){
            limitDays = 7;
        }
        List<Po3> po3List = infoService.queryPreviousPlaceBoom(limitDays);
        return RespMsg.getOKInstance(po3List);

    }

    @RequestMapping("/selectWarnDeviceByPlace")
    public RespMsg selectWarnDeviceByPlace(){
        List<P6> p6List = infoService.selectWarnDeviceByPlace();
        return RespMsg.getOKInstance(p6List);
    }
}
