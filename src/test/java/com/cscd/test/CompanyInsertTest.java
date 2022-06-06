//package com.cscd.test;
//
//import com.cscd.bos.RegionBo;
//import com.cscd.dos.CompanyDo;
//import com.cscd.services.CompanyService;
//import com.cscd.services.RegionService;
//import com.cscd.utils.ConvertUtil;
//import com.cscd.utils.Util;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.util.List;
//import java.util.Random;
//
//@SpringBootTest
///**
// * 用于随机生成company
// */
//public class CompanyInsertTest {
//    @Autowired
//    CompanyService companyService;
//    @Autowired
//    RegionService regionService;
//    @Autowired
//    Util util;
//    @Autowired
//    ConvertUtil convertUtil;
//
//    private List<RegionBo> regionBoList = null;
//
//    public CompanyDo createCompanyDo(){
//        if(regionBoList == null){
//            regionBoList = regionService.selectAllRegion();
//        }
//        RegionBo regionBo = regionBoList.get(new Random().nextInt(regionBoList.size()));
//
//        return new CompanyDo(
//                util.getRandomUid(),
//                "中国" + regionBo.getRegionName() + util.getRandomString() + "有限责任公司",
//                regionBo.getRegionId(),
//                0,
//                "",
//                null
//        );
//    }
//
//    @Test
//    public void insertCompany(){
//        for (int i =0;i<500; i++){
//            CompanyDo companyDo = createCompanyDo();
//            Boolean aBoolean = companyService.insertCompany(convertUtil.toCompanyBo(companyDo));
//            System.out.println(aBoolean);
//        }
//    }
//}
