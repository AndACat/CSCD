package com.cscd.services;

import com.cscd.bos.CompanyDailyBo;
import com.cscd.dos.CompanyDailyDo;
import com.cscd.dao.CompanyDailyDao;
import com.cscd.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyDailyService {
    @Autowired
    private CompanyDailyDao companyDailyDao;

    @Autowired
    private ConvertUtil convertUtil;

    public List<CompanyDailyBo> selectAllCompanyDaily(){
        List<CompanyDailyDo> companyDailyDoList = companyDailyDao.selectAllCompanyDaily();
        List<CompanyDailyBo> companyDailyBoList = new ArrayList<>();
        companyDailyDoList.stream().forEach(companyDailyDo -> companyDailyBoList.add(convertUtil.toCompanyDailyBo(companyDailyDo)));
        return companyDailyBoList;
    }

    public CompanyDailyBo selectCompanyDailyByUid(String uid){
        CompanyDailyDo companyDailyDo = companyDailyDao.selectCompanyDailyByUid(uid);
        CompanyDailyBo companyDailyBo = convertUtil.toCompanyDailyBo(companyDailyDo);
        return companyDailyBo;
    }

    public List<CompanyDailyBo> selectCompanyDailyByCompanyUid(String companyUid){
        List<CompanyDailyDo> companyDailyDoList = companyDailyDao.selectCompanyDailyByCompanyUid(companyUid);
        List<CompanyDailyBo> companyDailyBoList = new ArrayList<>();
        companyDailyDoList.stream().forEach(companyDailyDo -> companyDailyBoList.add(convertUtil.toCompanyDailyBo(companyDailyDo)));
        return companyDailyBoList;
    }

    public Boolean deleteCompanyDailyByUid(String uid){
        Boolean aBoolean = companyDailyDao.deleteCompanyDailyByUid(uid);
        return aBoolean;
    }

    public Boolean deleteCompanyDailyByCompanyUid(String companyUid){
        Boolean aBoolean = companyDailyDao.deleteCompanyDailyByCompanyUid(companyUid);
        return aBoolean;
    }

    public Boolean insertCompanyDaily(CompanyDailyBo companyDailyBo){
        Boolean aBoolean = companyDailyDao.insertCompanyDaily(convertUtil.toCompanyDailyDo(companyDailyBo));
        return aBoolean;
    }
    public Boolean insertCompanyDailyWithUpdateDate(CompanyDailyBo companyDailyBo){
        Boolean aBoolean = companyDailyDao.insertCompanyDailyWithUpdateDate(convertUtil.toCompanyDailyDo(companyDailyBo));
        return aBoolean;
    }
}
