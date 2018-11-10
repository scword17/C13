package com.conhj.mapper;

import com.conhj.model.Husband;
import com.conhj.model.HusbandExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface HusbandMapper {
    @SelectProvider(type=HusbandSqlProvider.class, method="countByExample")
    long countByExample(HusbandExample example);

    @DeleteProvider(type=HusbandSqlProvider.class, method="deleteByExample")
    int deleteByExample(HusbandExample example);

    @Delete({
        "delete from husband",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into husband (id, name)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Husband record);

    @InsertProvider(type=HusbandSqlProvider.class, method="insertSelective")
    int insertSelective(Husband record);

    @SelectProvider(type=HusbandSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Husband> selectByExample(HusbandExample example);

    @Select({
        "select",
        "id, name",
        "from husband",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id",property="wife",one=@One(select="com.conhj.mapper.WifeMapper.selectByPrimaryKey"))
    })
    Husband selectByPrimaryKey(String id);

    @UpdateProvider(type=HusbandSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Husband record, @Param("example") HusbandExample example);

    @UpdateProvider(type=HusbandSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Husband record, @Param("example") HusbandExample example);

    @UpdateProvider(type=HusbandSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Husband record);

    @Update({
        "update husband",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Husband record);
}