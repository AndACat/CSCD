package com.cscd.dao;

import com.cscd.dos.CompanyDailyDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
@SuppressWarnings("all")
public interface CompanyDailyDao {
    @Select("select * from companydaily")
    List<CompanyDailyDo> selectAllCompanyDaily();

    @Select("select * from companydaily where uid = #{uid}")
    CompanyDailyDo selectCompanyDailyByUid(@Param("uid")String uid);

    @Select("select * from companydaily where companyuid = #{companyUid}")
    List<CompanyDailyDo> selectCompanyDailyByCompanyUid(@Param("companyUid") String companyUid);

    @Delete("delete companydaily where uid = #{uid}")
    Boolean deleteCompanyDailyByUid(@Param("uid")String uid);

    @Delete("delete companydaily where companyuid = #{companyUid}")
    Boolean deleteCompanyDailyByCompanyUid(@Param("companyUid")String companyUid);

    @Insert("insert into companydaily (uid, companyuid, boom, fire) values (#{companyDaily.uid}, #{companyDaily.companyUid}, #{companyDaily.boom}, #{companyDaily.fire})")
    Boolean insertCompanyDaily(@Param("companyDaily") CompanyDailyDo companyDailyDo);

    @Insert("insert into companydaily (uid, companyuid, boom, fire, updatedate) values (#{companyDaily.uid}, #{companyDaily.companyUid}, #{companyDaily.boom}, #{companyDaily.fire}, #{companyDaily.updateDate})")
    Boolean insertCompanyDailyWithUpdateDate(@Param("companyDaily") CompanyDailyDo companyDailyDo);


    @Select("select count(1) from companydaily where boom = '1' and companyuid in ( " +
            "select uid from (select uid from company where regionid in ( " +
            "select regionid from region where regionid = #{regionId} union " +
            "select regionid from region where regionparentid = #{regionId} union " +
            "select regionid from region where regionparentid in (select regionid from region where regionparentid = #{regionId})) " +
            ") as temp ) and updatedate > #{minDate} and updatedate < #{maxDate}")
    Integer selectBoomCountByRegionId(@Param("regionId") String regionId, @Param("minDate") LocalDateTime minDate, @Param("maxDate")LocalDateTime maxDate);

}
