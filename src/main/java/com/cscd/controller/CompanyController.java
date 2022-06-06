package com.cscd.controller;

import com.cscd.bos.CompanyBo;
import com.cscd.dos.CompanyDo;
import com.cscd.services.CompanyDailyService;
import com.cscd.services.CompanyService;
import com.cscd.utils.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CompanyController {
    @Autowired
    CompanyDailyService companyDailyService;
    @Autowired
    CompanyService companyService;

    @RequestMapping("/company/selectAllCompany")
    public RespMsg selectAllCompany(){
        List<CompanyBo> companyBoList = companyService.selectAllCompany(true);
        return RespMsg.getOKInstance(companyBoList);
    }

    @RequestMapping("/company/selectCompanyByUid")
    public RespMsg selectCompanyByUid(@RequestParam("uid") String uid){
        CompanyBo companyBo = companyService.selectCompanyByUid(uid, true);
        return RespMsg.getOKInstance(companyBo);
    }

    @RequestMapping("/company/selectCompanyByCompanyName")
    public RespMsg selectCompanyByCompanyName(@RequestParam("companyName") String companyName){
        CompanyBo companyBo = companyService.selectCompanyByCompanyName(companyName, true);
        return RespMsg.getOKInstance(companyBo);
    }

    @RequestMapping("/company/selectCompanyByRegionId")
    public RespMsg selectCompanyByRegionId(@RequestParam("regionId") String regionId){
        List<CompanyBo> companyBoList = companyService.selectCompanyByRegionId(regionId);
        return RespMsg.getOKInstance(companyBoList);
    }


//    @RequestMapping("/company/deleteCompany")
//    public RespMsg deleteCompanyByUid(@RequestParam("uid") String uid){
//        Boolean aBoolean = companyService.deleteCompanyByUid(uid);
//        return RespMsg.getOKInstance(aBoolean);
//    }

}
