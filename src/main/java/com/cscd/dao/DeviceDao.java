package com.cscd.dao;

import com.cscd.dos.DeviceDataDo;
import com.cscd.dos.DeviceDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
@SuppressWarnings("all")
/**
 * 用于随机生成device
 */
public interface DeviceDao {
    @Select("select * from device")
    List<DeviceDo> selectAllDevice();

    @Select("select * from device where uid = #{uid}")
    DeviceDo selectDeviceByUid(@Param("uid")String uid);

    @Select("select * from device where companyuid = #{companyUid}")
    List<DeviceDo> selectDeviceByCompanyUid(@Param("companyUid") String companyUid);

    @Delete("delete * from device where uid = #{deviceUid}")
    Boolean deleteDeviceByDeviceUid(@Param("deviceUid")String deviceUid);

    @Insert("insert into device(uid, devicename, companyuid, temperaturemin, temperaturemax, humiditymin, humiditymax," +
            "naturalgasmin, naturalgasmax, alcoholmin, alcoholmax, illuminationmin, illuminationmax)values(#{device.uid}, " +
            "#{device.deviceName}, #{device.companyUid}, #{device.temperatureMin}, #{device.temperatureMax}, #{device.humidityMin}, " +
            "#{device.humidityMax}, #{device.naturalgasMin}, " +
            "#{device.naturalgasMax}, #{device.alcoholMin}, #{device.alcoholMax}, #{device.illuminationMin}, #{device.illuminationMax})")
    Boolean insertDevice(@Param("device") DeviceDo deviceDo);

    @Update("update device set handle = #{handle}, states = #{states} where uid = #{uid}")
    Boolean updateDeviceInfo(@Param("uid") String uid, @Param("handle") Boolean handle, @Param("states") String states);

    @Select("select * from device where states = '1'")
    List<DeviceDo> selectAllOnlineDevice();

    @Select("select * from device where states = '2'")
    List<DeviceDo> selectAllOfflineDevice();

    @Select("select * from device where states = '3' order by updatedate desc limit ${limit}")
    List<DeviceDo> selectAllWarnDevice(@Param("limit") int limit);

    @Select("select * from device where companyUid = #{companyUid} and states = '1'")
    List<DeviceDo> selectOnlineDeviceByCompanyUid(@Param("companyUid")String companyUid);

    @Select("select * from device where companyUid = #{companyUid} and states = '2'")
    List<DeviceDo> selectOfflineDeviceByCompanyUid(@Param("companyUid")String companyUid);

    @Select("select * from device where companyUid = #{companyUid} and states = '3'")
    List<DeviceDo> selectWarnDeviceByCompanyUid(@Param("companyUid")String companyUid);

    @Select("select count(1) from device where states = '1'")
    Integer selectAllOnlineDeviceCount();

    @Select("select count(1) from device where states = '2'")
    Integer selectAllOfflineDeviceCount();

    @Select("select count(1) from device where states = '3'")
    Integer selectAllWarnDeviceCount();

    @Select("select count(1) from device")
    Integer selectAllDeviceCount();

    @Select("select * from device d where d.uid in ( " +
            "select deviceuid from devicedata where updatedate < #{maxDate} and updatedate > #{minDate} " +
            "and( temperaturewarn = '1' or humiditywarn = '1' or naturalgaswarn = '1' or alcoholwarn = '1' or illuminationwarn = '1' ) " +
            ") order by d.updatedate desc ")
    List<DeviceDo> selectWarnDevicesByDate(@Param("minDate") LocalDateTime minDate, @Param("maxDate")LocalDateTime maxDate);

    @Select("select * from device where states = '3' and companyuid in (\n" +
            "select uid from (select uid from company where regionid in (\n" +
            "select regionid from region where regionid = #{regionId} union\n" +
            "select regionid from region where regionparentid = #{regionId} union\n" +
            "select regionid from region where regionparentid in (select regionid from region where regionparentid = #{regionId})))as temp\n" +
            ")")
    List<DeviceDo> selectWarnDevicesByPlace(@Param("regionId") String regionId);

}
