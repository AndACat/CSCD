package com.cscd.controller;

import com.cscd.bos.RegionBo;
import com.cscd.dos.RegionDo;
import com.cscd.services.RegionService;
import com.cscd.utils.RespMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class RegionController {
    @Autowired
    RegionService regionService;

    @RequestMapping("/region/selectAllRegion")
    public RespMsg selectAllRegion(){
        List<RegionBo> regionBoList = regionService.selectAllRegion();
        return RespMsg.getOKInstance(regionBoList);
    }

    @RequestMapping("/region/selectRegionByRegionParentId")
    public RespMsg selectRegionByRegionParentId(@RequestParam("regionParentId") String regionParentId){
        List<RegionBo> regionBoList = regionService.selectRegionByRegionParentId(regionParentId);
        return RespMsg.getOKInstance(regionBoList);
    }

    @RequestMapping("/region/selectRegionByRegionId")
    public RespMsg selectRegionByRegionId(@RequestParam("regionId")String regionId){
        RegionBo regionBo = regionService.selectRegionByRegionId(regionId);
        return RespMsg.getOKInstance(regionBo);
    }

    @RequestMapping("/region/selectRegionByRegionLevel")
    public RespMsg selectRegionByRegionLevel(@RequestParam("regionLevel")String regionLevel){
        List<RegionBo> regionBoList = regionService.selectRegionByRegionLevel(regionLevel);
        return RespMsg.getOKInstance(regionBoList);
    }
}
