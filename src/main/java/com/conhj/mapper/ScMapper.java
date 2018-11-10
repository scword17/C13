package com.conhj.mapper;

import com.conhj.model.Sc;
import com.conhj.model.ScExample;
import com.conhj.model.ScKey;
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

public interface ScMapper {
    @SelectProvider(type=ScSqlProvider.class, method="countByExample")
    long countByExample(ScExample example);

    @DeleteProvider(type=ScSqlProvider.class, method="deleteByExample")
    int deleteByExample(ScExample example);

    @Delete({
        "delete from sc",
        "where Sno = #{sno,jdbcType=CHAR}",
          "and Cno = #{cno,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(ScKey key);

    @Insert({
        "insert into sc (Sno, Cno, Grade)",
        "values (#{sno,jdbcType=CHAR}, #{cno,jdbcType=CHAR}, #{grade,jdbcType=SMALLINT})"
    })
    int insert(Sc record);

    @InsertProvider(type=ScSqlProvider.class, method="insertSelective")
    int insertSelective(Sc record);

    @SelectProvider(type=ScSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="Sno", property="sno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Cno", property="cno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Grade", property="grade", jdbcType=JdbcType.SMALLINT)
    })
    List<Sc> selectByExample(ScExample example);

    @Select({
        "select",
        "Sno, Cno, Grade",
        "from sc",
        "where Sno = #{sno,jdbcType=CHAR}",
          "and Cno = #{cno,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="Sno", property="sno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Cno", property="cno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Grade", property="grade", jdbcType=JdbcType.SMALLINT)
    })
    Sc selectByPrimaryKey(ScKey key);

    @UpdateProvider(type=ScSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    @UpdateProvider(type=ScSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);

    @UpdateProvider(type=ScSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sc record);

    @Update({
        "update sc",
        "set Grade = #{grade,jdbcType=SMALLINT}",
        "where Sno = #{sno,jdbcType=CHAR}",
          "and Cno = #{cno,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Sc record);
}