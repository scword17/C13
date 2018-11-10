package com.conhj.mapper;

import com.conhj.model.Wife;
import com.conhj.model.WifeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface WifeMapper {
    @SelectProvider(type=WifeSqlProvider.class, method="countByExample")
    long countByExample(WifeExample example);

    @DeleteProvider(type=WifeSqlProvider.class, method="deleteByExample")
    int deleteByExample(WifeExample example);

    @Delete({
        "delete from wife",
        "where wid = #{wid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String wid);

    @Insert({
        "insert into wife (wid, name)",
        "values (#{wid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Wife record);

    @InsertProvider(type=WifeSqlProvider.class, method="insertSelective")
    int insertSelective(Wife record);

    @SelectProvider(type=WifeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="wid", property="wid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Wife> selectByExample(WifeExample example);

    @Select({
        "select",
        "wid, name",
        "from wife",
        "where wid = #{wid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="wid", property="wid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Wife selectByPrimaryKey(String wid);

    @UpdateProvider(type=WifeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Wife record, @Param("example") WifeExample example);

    @UpdateProvider(type=WifeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Wife record, @Param("example") WifeExample example);

    @UpdateProvider(type=WifeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Wife record);

    @Update({
        "update wife",
        "set name = #{name,jdbcType=VARCHAR}",
        "where wid = #{wid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Wife record);
}