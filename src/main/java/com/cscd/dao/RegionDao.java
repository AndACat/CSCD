package com.cscd.dao;

import com.cscd.dos.RegionDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
@SuppressWarnings("all")
public interface RegionDao {
    @Select("select * from region")
    List<RegionDo> selectAllRegion();

    @Select("select * from region where regionparentid = #{regionParentId}")
    List<RegionDo> selectRegionByRegionParentId(@Param("regionParentId") String regionParentId);

    @Select("select * from region where regionid = #{regionId}")
    RegionDo selectRegionByRegionId(@Param("regionId") String regionId);

    @Select("select * from region where regionlevel = #{regionLevel}")
    List<RegionDo> selectRegionByRegionLevel(@Param("regionLevel")String regionLevel);


}
