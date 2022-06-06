package com.cscd.services;

import com.cscd.bos.RegionBo;
import com.cscd.dos.RegionDo;
import com.cscd.dao.RegionDao;
import com.cscd.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionDao regionDao;
    @Autowired
    private ConvertUtil convertUtil;

    public List<RegionBo> selectAllRegion(){
        List<RegionDo> regionDoList = regionDao.selectAllRegion();
        List<RegionBo> regionBoList = new ArrayList<>();
        regionDoList.stream().forEach(regionDo -> regionBoList.add(convertUtil.toRegionBo(regionDo)));
        return regionBoList;
    }

    public List<RegionBo> selectRegionByRegionParentId(String regionParentId){
        List<RegionDo> regionDoList = regionDao.selectRegionByRegionParentId(regionParentId);
        List<RegionBo> regionBoList = new ArrayList<>();
        regionDoList.stream().forEach(regionDo -> regionBoList.add(convertUtil.toRegionBo(regionDo)));
        return regionBoList;
    }

    public RegionBo selectRegionByRegionId(String regionId){
        RegionDo regionDo = regionDao.selectRegionByRegionId(regionId);
        RegionBo regionBo = convertUtil.toRegionBo(regionDo);
        return regionBo;
    }

    public List<RegionBo> selectRegionByRegionLevel(String regionLevel){
        List<RegionDo> regionDoList = regionDao.selectRegionByRegionLevel(regionLevel);
        List<RegionBo> regionBoList = new ArrayList<>();
        regionDoList.stream().forEach(regionDo -> regionBoList.add(convertUtil.toRegionBo(regionDo)));
        return regionBoList;
    }
}
