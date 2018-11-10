package com.conhj.mapper;

import com.conhj.model.Son;
import com.conhj.model.SonExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SonMapper {
    @SelectProvider(type=SonSqlProvider.class, method="countByExample")
    long countByExample(SonExample example);

    @DeleteProvider(type=SonSqlProvider.class, method="deleteByExample")
    int deleteByExample(SonExample example);

    @Delete({
        "delete from son",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into son (id, sname, ",
        "fid)",
        "values (#{id,jdbcType=VARCHAR}, #{sname,jdbcType=VARCHAR}, ",
        "#{fid,jdbcType=VARCHAR})"
    })
    int insert(Son record);

    @InsertProvider(type=SonSqlProvider.class, method="insertSelective")
    int insertSelective(Son record);

    @SelectProvider(type=SonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sname", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR)
    })
    List<Son> selectByExample(SonExample example);

    @Select({
            "select",
            "id, sname, fid",
            "from son",
            "where fid = #{fid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="sname", property="sname", jdbcType=JdbcType.VARCHAR),
            @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR)
    })
    Son selectByFid(String fid);

    @Select({
            "select",
            "id, sname, fid",
            "from son",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="sname", property="sname", jdbcType=JdbcType.VARCHAR),
            @Result(column="fid", property="fid", jdbcType=JdbcType.VARCHAR),
            @Result(column="fid",property="father",one=@One(select="com.conhj.mapper.FatherMapper.selectByFid"))
    })
    Son selectByPrimaryKey(String id);



    @UpdateProvider(type=SonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Son record, @Param("example") SonExample example);

    @UpdateProvider(type=SonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Son record, @Param("example") SonExample example);

    @UpdateProvider(type=SonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Son record);

    @Update({
        "update son",
        "set sname = #{sname,jdbcType=VARCHAR},",
          "fid = #{fid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Son record);
}