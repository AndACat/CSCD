package com.cscd.services;

import com.cscd.bos.*;
import com.cscd.dos.RegionDo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class InfoService {
    @Autowired
    RegionService regionService;
    @Autowired
    CompanyService companyService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    DeviceDataService deviceDataService;
    @Autowired
    CompanyDailyService companyDailyService;

    /**
     * 查找前n个地区的设备数量，并降序排序
     * @return
     */
    public List<Po1> queryPreviousPlaceDevice(){
        List<Po1> poList = new ArrayList<>();
        List<RegionBo> regionBoList = regionService.selectRegionByRegionLevel("1");
        for (RegionBo regionBo : regionBoList) {
            Integer deviceCount = companyService.selectEquipmentNumByRegionId(regionBo.getRegionId());
            poList.add(new Po1(regionBo, deviceCount == null ? 0 : deviceCount));
        }
        poList.sort((o1, o2) -> o2.getDeviceCount() - o1.getDeviceCount());
        return poList;
    }
    /**
     * 查找前n个地区的公司爆炸数量，并降序排序
     *
     */
    public List<Po3> queryPreviousPlaceBoom(int limitDays){
        List<Po3> po3List = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        List<RegionBo> regionBoList = regionService.selectRegionByRegionLevel("1");
        for (RegionBo regionBo : regionBoList) {
            Po3 po3 = new Po3(regionBo);
            for (int i = 0; i < limitDays; i++) {
                LocalDateTime minDate = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 00, 00, 00);
                LocalDateTime maxDate = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59);
                minDate = minDate.plusDays(-i);
                maxDate = maxDate.plusDays(-i);
                Integer boomCount = companyDailyService.selectBoomCount(regionBo.getRegionId(), minDate, maxDate);
                po3.add(minDate.toLocalDate(), boomCount);
            }
            po3List.add(po3);
        }
        po3List.sort((o1, o2) -> o2.getAllBoomCount() - o1.getAllBoomCount());
        return po3List;
    }

    /**
     * 查找n个公司今天的告警设备数量，并按告警数量降序排序
     * 只查找今天的告警数
     * @return
     */
    public List<Po2> queryCompanyWarn(){
        List<Po2> po2List = new ArrayList<>();
        List<CompanyBo> companyBoList = companyService.selectAllCompany(true);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime minDate = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 00, 00, 00);
        LocalDateTime maxDate = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59);
        for (CompanyBo companyBo : companyBoList) {
            Integer integer = deviceDataService.selectWarnDeviceDataByCompanyUid(minDate, maxDate, companyBo.getUid());
            Po2 po2 = new Po2(companyBo, integer);
            po2List.add(po2);
        }
        po2List.sort((o1, o2) -> o2.getWarnCount() - o1.getWarnCount());
        return po2List;
    }

    /**
     * 按不同地区划分，查询地区的告警设备，并降序排序
     */
    public List<P6> selectWarnDeviceByPlace(){
        List<RegionBo> regionBoList = regionService.selectRegionByRegionLevel("1");
        List<P6> p6List = new ArrayList<>();
        for (RegionBo regionBo : regionBoList) {
            List<DeviceBo> deviceBoList = deviceService.selectWarnDevicesByPlace(regionBo.getRegionId());
            P6 p6 = new P6(regionBo, deviceBoList);
            p6List.add(p6);
        }
        p6List.sort(((o1, o2) -> o2.getDeviceBoList().size() - o1.getDeviceBoList().size()));

        return p6List;
    }



}


