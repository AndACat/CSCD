//package com.cscd.test;
//
//import com.cscd.bos.CompanyBo;
//import com.cscd.bos.CompanyDailyBo;
//import com.cscd.bos.DeviceBo;
//import com.cscd.services.CompanyDailyService;
//import com.cscd.services.CompanyService;
//import com.cscd.services.DeviceService;
//import com.cscd.utils.ConvertUtil;
//import com.cscd.utils.Util;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Random;
//
//@SpringBootTest
//public class CompanyDailyInsertTest {
//
//    @Autowired
//    CompanyService companyService;
//    @Autowired
//    DeviceService deviceService;
//    @Autowired
//    Util util;
//    @Autowired
//    ConvertUtil convertUtil;
//    @Autowired
//    CompanyDailyService companyDailyService;
//
//
//
//    @Test
//    public void insert(){
//        List<CompanyBo> companyBoList = companyService.selectAllCompany();
//        for (CompanyBo companyBo : companyBoList) {
//            //添加上个月整个月的随机记录
//            for (int i = 1; i <= 31; i++) {
//                CompanyDailyBo companyDailyBo = new CompanyDailyBo(
//                        util.getRandomUid(),
//                        companyBo,
//                        new Random().nextInt(100) > 95,
//                        new Random().nextInt(100) > 95,
//                        LocalDateTime.of(2022,5,i, 12, 00, 00)
//                );
//                companyDailyService.insertCompanyDailyWithUpdateDate(companyDailyBo);
//            }
//            //添加本月整个月的随机记录
//            for (int i = 1; i <= 6; i++) {
//                CompanyDailyBo companyDailyBo = new CompanyDailyBo(
//                        util.getRandomUid(),
//                        companyBo,
//                        new Random().nextInt(100) > 95,
//                        new Random().nextInt(100) > 95,
//                        LocalDateTime.of(2022,6, i, 12, 00, 00)
//                );
//                companyDailyService.insertCompanyDailyWithUpdateDate(companyDailyBo);
//            }
//
//
//        }
//
//    }
//}
