package com.cscd.dao;

import com.cscd.dos.CompanyDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
@SuppressWarnings("all")
public interface CompanyDao {

    @Select("select * from company")
    List<CompanyDo> selectAllCompany();

    @Select("select * from company where uid = #{uid}")
    CompanyDo selectCompanyByUid(@Param("uid") String uid);

    @Select("select * from company where companyName = #{companyName}")
    CompanyDo selectCompanyByCompanyName(@Param("companyName")String companyName);

    @Select("select sum(equipmentnum) from company where regionid in (" +
            "select regionid from (" +
            "select regionid from region where regionid = #{regionId} union " +
            "select regionid from region where regionparentid = #{regionId} union " +
            "select regionid from region where regionparentid in (select regionid from region where regionparentid = #{regionId})) as temp)")
    Integer selectEquipmentNumByRegionId(@Param("regionId") String regionId);

    @Insert("insert into company(uid, companyname, regionid, describes) values (#{company.uid}, #{company.companyName}, " +
            "#{company.regionId}, #{company.describes})")
    Boolean insertCompany(@Param("company")CompanyDo companyDo);

    @Delete("delete company where uid = #{uid}")
    Boolean deleteCompanyByUid(@Param("uid") String uid);

    @Update("update company set equipmentnum = equipmentnum + 1 where uid = #{uid}")
    Boolean addCompanyEquipmentNumByUid(@Param("uid") String uid);

    @Select("select * from company where regionid in (" +
            "select regionid from (" +
            "select regionid from region where regionid = #{regionId} union " +
            "select regionid from region where regionparentid = #{regionId} union " +
            "select regionid from region where regionparentid in (select regionid from region where regionparentid = #{regionId})) as temp)")
    List<CompanyDo> selectCompanyByRegionId(String regionId);
}
