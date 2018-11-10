package com.conhj.mapper;

import com.conhj.model.Father;
import com.conhj.model.FatherExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface FatherMapper {
    @SelectProvider(type=FatherSqlProvider.class, method="countByExample")
    long countByExample(FatherExample example);

    @DeleteProvider(type=FatherSqlProvider.class, method="deleteByExample")
    int deleteByExample(FatherExample example);

    @Delete({
        "delete from father",
        "where fid = #{fid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String fid);

    @Insert({
        "insert into father (fid, fname)",
        "values (#{fid,jdbcType=VARCHAR}, #{fname,jdbcType=VARCHAR})"
    })
    int insert(Father record);

    @InsertProvider(type=FatherSqlProvider.class, method="insertSelective")
    int insertSelective(Father record);

    @SelectProvider(type=FatherSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="fname", property="fname", jdbcType=JdbcType.VARCHAR)
    })
    List<Father> selectByExample(FatherExample example);

    @Select({
        "select",
        "fid, fname",
        "from father",
        "where fid = #{fid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="fname", property="fname", jdbcType=JdbcType.VARCHAR),
        @Result(column="fid", property="sons", many=@Many(select="com.conhj.mapper.SonMapper.selectByFid"))
    })
    Father selectByPrimaryKey(String fid);

    @Select({
            "select",
            "fid, fname",
            "from father",
            "where fid = #{fid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="fname", property="fname", jdbcType=JdbcType.VARCHAR)
    })
    Father selectByFid(String fid);

    @UpdateProvider(type=FatherSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Father record, @Param("example") FatherExample example);

    @UpdateProvider(type=FatherSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Father record, @Param("example") FatherExample example);

    @UpdateProvider(type=FatherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Father record);

    @Update({
        "update father",
        "set fname = #{fname,jdbcType=VARCHAR}",
        "where fid = #{fid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Father record);
}