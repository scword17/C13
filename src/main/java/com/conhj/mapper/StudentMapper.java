package com.conhj.mapper;

import com.conhj.model.Student;
import com.conhj.model.StudentExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface StudentMapper {
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    long countByExample(StudentExample example);

    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
        "delete from student",
        "where Sno = #{sno,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String sno);

    @Insert({
        "insert into student (Sno, Sname, Sex, ",
        "Sage, Sdept)",
        "values (#{sno,jdbcType=CHAR}, #{sname,jdbcType=CHAR}, #{sex,jdbcType=CHAR}, ",
        "#{sage,jdbcType=SMALLINT}, #{sdept,jdbcType=CHAR})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="Sno", property="sno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Sname", property="sname", jdbcType=JdbcType.CHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="Sage", property="sage", jdbcType=JdbcType.SMALLINT),
        @Result(column="Sdept", property="sdept", jdbcType=JdbcType.CHAR)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "Sno, Sname, Sex, Sage, Sdept",
        "from student",
        "where Sno = #{sno,jdbcType=CHAR}"
    })
    @Results(value = {
        @Result(column="Sno", property="sno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Sname", property="sname", jdbcType=JdbcType.CHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="Sage", property="sage", jdbcType=JdbcType.SMALLINT),
        @Result(column="Sdept", property="sdept", jdbcType=JdbcType.CHAR),
            @Result(column="sno", property="courses", many=@Many(select="com.conhj.mapper.CourseMapper.selectCourse"))
    })
    Student selectByPrimaryKey(String sno);

    @Select({
            "select",
            "Sno, Sname, Sex, Sage, Sdept",
            "from student",
            "where Sno in (select Sno from sc where Cno = #{Cno,jdbcType=CHAR})"
    })
    @Results(value = {
            @Result(column="Sno", property="sno", jdbcType=JdbcType.CHAR, id=true),
            @Result(column="Sname", property="sname", jdbcType=JdbcType.CHAR),
            @Result(column="Sex", property="sex", jdbcType=JdbcType.CHAR),
            @Result(column="Sage", property="sage", jdbcType=JdbcType.SMALLINT),
            @Result(column="Sdept", property="sdept", jdbcType=JdbcType.CHAR)
    })
    Student selectStus(String Cno);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set Sname = #{sname,jdbcType=CHAR},",
          "Sex = #{sex,jdbcType=CHAR},",
          "Sage = #{sage,jdbcType=SMALLINT},",
          "Sdept = #{sdept,jdbcType=CHAR}",
        "where Sno = #{sno,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Student record);
}