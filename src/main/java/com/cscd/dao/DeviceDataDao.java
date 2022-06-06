package com.cscd.dao;

import com.cscd.dos.DeviceDataDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
@SuppressWarnings("all")
public interface DeviceDataDao {
    @Select("select * from devicedata order by updatedate desc")
    List<DeviceDataDo> selectAllDeviceData();

    @Select("select * from devicedata where companyuid = #{companyUid} order by updatedate desc")
    List<DeviceDataDo> selectDeviceDataByCompanyUid(@Param("companyUid")String companyUid);

    @Select("select * from devicedata where deviceuid = #{deviceUid} order by updatedate desc limit ${limit}")
    List<DeviceDataDo> selectDeviceDataByDeviceUid(@Param("deviceUid")String deviceUid, Integer limit);

    @Select("select * from devicedata where temperaturewarn = '1' or humiditywarn = '1' or naturalgaswarn = '1' or alcoholwarn = '1' or illuminationwarn = '1' order by updatedate desc")
    List<DeviceDataDo> selectDeviceDataByWarn();

    @Insert("<script>" +
            "insert into devicedata" +
            "        <trim suffixOverrides=','>" +
            "        (uid,companyuid,deviceuid," +
            "            <if test='devicedata.temperature != null'>temperature,</if>" +
            "            <if test='devicedata.humidity != null'>humidity,</if>" +
            "            <if test='devicedata.naturalgas != null'>naturalgas ,</if>" +
            "            <if test='devicedata.alcohol != null'>alcohol ,</if>" +
            "            <if test='devicedata.illumination != null'>illumination ,</if>" +

            "            <if test='devicedata.temperatureWarn != null'>temperaturewarn ,</if>" +
            "            <if test='devicedata.humidityWarn != null'>humiditywarn ,</if>" +
            "            <if test='devicedata.naturalgasWarn != null'>naturalgaswarn ,</if>" +
            "            <if test='devicedata.alcoholWarn != null'>alcoholwarn ,</if>" +
            "            <if test='devicedata.illuminationWarn != null'>illuminationwarn ,</if>" +
            "            <if test='devicedata.updateDate != null'>updatedate ,</if>" +
            "        </trim>" +
            "        )values(" +
            "        <trim suffixOverrides=','>" +
            "        #{devicedata.uid},#{devicedata.companyUid},#{devicedata.deviceUid}," +
            "            <if test='devicedata.temperature != null'>#{devicedata.temperature},</if>" +
            "            <if test='devicedata.humidity != null'>#{devicedata.humidity},</if>" +
            "            <if test='devicedata.naturalgas != null'>#{devicedata.naturalgas} ,</if>" +
            "            <if test='devicedata.alcohol != null'>#{devicedata.alcohol} ,</if>" +
            "            <if test='devicedata.illumination != null'>#{devicedata.illumination} ,</if>" +

            "            <if test='devicedata.temperatureWarn != null'>#{devicedata.temperatureWarn} ,</if>" +
            "            <if test='devicedata.humidityWarn != null'>#{devicedata.humidityWarn} ,</if>" +
            "            <if test='devicedata.naturalgasWarn != null'>#{devicedata.naturalgasWarn} ,</if>" +
            "            <if test='devicedata.alcoholWarn != null'>#{devicedata.alcoholWarn} ,</if>" +
            "            <if test='devicedata.illuminationWarn != null'>#{devicedata.illuminationWarn} ,</if>" +
            "            <if test='devicedata.updateDate != null'>#{devicedata.updateDate} ,</if>" +
            "        </trim>" +
            "        )" +
            "</script>")
    Boolean insertDeviceData(@Param("devicedata")DeviceDataDo deviceDataDo);

    @Delete("delete from devicedata where uid = #{uid}")
    Boolean deleteDeviceDataByUid(@Param("uid") String uid);

    @Select("select count(1) from devicedata where (temperaturewarn = '1' or humiditywarn = '1' or naturalgaswarn = 'naturalgaswarn' or alcoholwarn = '1' or illuminationwarn = '1') and " +
            "deviceuid in (select uid from device where companyuid = #{deviceuid}) and updatedate < #{maxDate} and updatedate > #{minDate}")
    Integer selectWarnDeviceDataByCompanyUid(@Param("minDate") LocalDateTime minDate, @Param("maxDate") LocalDateTime maxDate,@Param("deviceuid")  String deviceuid);



}
