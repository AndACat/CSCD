//package com.cscd.test;
//
//import com.cscd.bos.CompanyBo;
//import com.cscd.bos.DeviceBo;
//import com.cscd.services.CompanyService;
//import com.cscd.services.DeviceService;
//import com.cscd.services.RegionService;
//import com.cscd.utils.ConvertUtil;
//import com.cscd.utils.Util;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Random;
//
//@SpringBootTest
//public class DeviceInsertTest {
//
//    @Autowired
//    RegionService regionService;
//    @Autowired
//    CompanyService companyService;
//    @Autowired
//    Util util;
//    @Autowired
//    ConvertUtil convertUtil;
//    @Autowired
//    DeviceService deviceService;
//
//
//    List<CompanyBo> companyBoList = null;
//    List<Float> minList = List.of(-5f, 0f, 5f, 10f, 15f, 18f);
//    List<Float> maxList = List.of(22f, 25f, 30f, 35f, 37f);
//
//
//    @Test
//    public void insertDevice(){
//        if(companyBoList == null){
//            companyBoList = companyService.selectAllCompany();
//        }
//        for (CompanyBo company: companyBoList) {
//            CompanyBo companyBo = company;
//            for (int i=0; i<new Random().nextInt(10);i++){
//                DeviceBo deviceBo = new DeviceBo(
//                        util.getRandomUid(),
//                        "守卫者储存柜" + util.getRandomString() + "号",
//                        companyBo,
//                        minList.get(new Random().nextInt(minList.size())),
//                        maxList.get(new Random().nextInt(maxList.size())),
//                        minList.get(new Random().nextInt(minList.size())),
//                        maxList.get(new Random().nextInt(maxList.size())),
//                        minList.get(new Random().nextInt(minList.size())),
//                        maxList.get(new Random().nextInt(maxList.size())),
//                        minList.get(new Random().nextInt(minList.size())),
//                        maxList.get(new Random().nextInt(maxList.size())),
//                        minList.get(new Random().nextInt(minList.size())),
//                        maxList.get(new Random().nextInt(maxList.size())),
//                        false,
//                        "1",
//                        null
//                );
//                deviceService.insertDevice(deviceBo);
//            }
//        }
//    }
//}
