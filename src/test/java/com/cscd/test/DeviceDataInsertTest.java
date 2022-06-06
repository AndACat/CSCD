//package com.cscd.test;
//
//import com.cscd.bos.DeviceBo;
//import com.cscd.bos.DeviceDataBo;
//import com.cscd.services.CompanyDailyService;
//import com.cscd.services.CompanyService;
//import com.cscd.services.DeviceDataService;
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
//public class DeviceDataInsertTest {
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
//    @Autowired
//    DeviceDataService deviceDataService;
//
//    @Test
//    public void insert(){
//        List<DeviceBo> deviceBoList = deviceService.selectAllDevice();
//        LocalDateTime now = LocalDateTime.now();
//
//        for (DeviceBo deviceBo : deviceBoList) {
//            for (int i = 15; i < 24; i++) {
//                DeviceDataBo deviceDataBo = new DeviceDataBo(
//                        util.getRandomUid(),
//                        deviceBo.getCompany(),
//                        deviceBo,
//                        (new Random().nextFloat()-0.2f) * 20f,
//                        (new Random().nextFloat()-0.2f) * 20f,
//                        (new Random().nextFloat()-0.2f) * 20f,
//                        (new Random().nextFloat()-0.2f) * 20f,
//                        (new Random().nextFloat()-0.2f) * 20f,
//                        LocalDateTime.of(2022, now.getMonth(), now.getDayOfMonth(), i, 0, 00)
//                );
//                deviceDataService.insertDeviceData(deviceDataBo);
//            }
//
//        }
//    }
//}
