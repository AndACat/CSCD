package com.cscd.services;

import com.cscd.bos.CompanyBo;
import com.cscd.dos.CompanyDo;
import com.cscd.dao.CompanyDao;
import com.cscd.utils.ConvertUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private ConvertUtil convertUtil;

    public List<CompanyBo> selectAllCompany(){
        List<CompanyDo> companyDoList = companyDao.selectAllCompany();
        List<CompanyBo> companyBoList = new ArrayList<>();
        companyDoList.stream().forEach(companyDo -> companyBoList.add(convertUtil.toCompanyBo(companyDo)));
        return companyBoList;
    }

    public CompanyBo selectCompanyByUid(String uid){
        CompanyDo companyDo = companyDao.selectCompanyByUid(uid);
        CompanyBo companyBo = convertUtil.toCompanyBo(companyDo);
        return companyBo;
    }

    public CompanyBo selectCompanyByCompanyName(String companyName){
        CompanyDo companyDo = companyDao.selectCompanyByCompanyName(companyName);
        CompanyBo companyBo = convertUtil.toCompanyBo(companyDo);
        return companyBo;
    }

    public Integer selectCompanyByRegionId(String regionId){
        Integer integer = companyDao.selectEquipmentNumByRegionId(regionId);
        return integer;
    }

    public Boolean insertCompany(CompanyBo companyBo){
        CompanyDo companyDo = convertUtil.toCompanyDo(companyBo);
        Boolean aBoolean = companyDao.insertCompany(companyDo);
        return aBoolean;
    }

    public Boolean deleteCompanyByUid(String uid){
        Boolean aBoolean = companyDao.deleteCompanyByUid(uid);
        return aBoolean;
    }

    public Boolean addCompanyEquipmentNumByUid( String uid){
        return companyDao.addCompanyEquipmentNumByUid(uid);        
    }

    public Integer selectBoomCount(String regionId, LocalDateTime minDate, LocalDateTime maxDate) {
        Integer count = companyDao.selectBoomCountByRegionId(regionId, minDate, maxDate);
        return count;
    }
}
