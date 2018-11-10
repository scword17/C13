package com.conhj.mapper;

import com.conhj.model.Course;
import com.conhj.model.CourseExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @SelectProvider(type=CourseSqlProvider.class, method="countByExample")
    long countByExample(CourseExample example);

    @DeleteProvider(type=CourseSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseExample example);

    @Delete({
        "delete from course",
        "where Cno = #{cno,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String cno);

    @Insert({
        "insert into course (Cno, Cname, Cpno, ",
        "Ccredit)",
        "values (#{cno,jdbcType=CHAR}, #{cname,jdbcType=CHAR}, #{cpno,jdbcType=CHAR}, ",
        "#{ccredit,jdbcType=SMALLINT})"
    })
    int insert(Course record);

    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    @SelectProvider(type=CourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="Cno", property="cno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Cname", property="cname", jdbcType=JdbcType.CHAR),
        @Result(column="Cpno", property="cpno", jdbcType=JdbcType.CHAR),
        @Result(column="Ccredit", property="ccredit", jdbcType=JdbcType.SMALLINT)
    })
    List<Course> selectByExample(CourseExample example);

    @Select({
        "select",
        "Cno, Cname, Cpno, Ccredit",
        "from course",
        "where Cno = #{cno,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="Cno", property="cno", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Cname", property="cname", jdbcType=JdbcType.CHAR),
        @Result(column="Cpno", property="cpno", jdbcType=JdbcType.CHAR),
        @Result(column="Ccredit", property="ccredit", jdbcType=JdbcType.SMALLINT),
            @Result(column="Cno", property="stus", many=@Many(select="com.conhj.mapper.StudentMapper.selectStus"))
    })
    Course selectByPrimaryKey(String cno);

    @Select({
            "select",
            "Cno, Cname, Cpno, Ccredit",
            "from course",
            "where Cno in (select Cno from sc where Sno = #{Sno,jdbcType=CHAR})"
    })
    @Results({
            @Result(column="Cno", property="cno", jdbcType=JdbcType.CHAR, id=true),
            @Result(column="Cname", property="cname", jdbcType=JdbcType.CHAR),
            @Result(column="Cpno", property="cpno", jdbcType=JdbcType.CHAR),
            @Result(column="Ccredit", property="ccredit", jdbcType=JdbcType.SMALLINT)
    })
    Course selectCourse(String sno);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set Cname = #{cname,jdbcType=CHAR},",
          "Cpno = #{cpno,jdbcType=CHAR},",
          "Ccredit = #{ccredit,jdbcType=SMALLINT}",
        "where Cno = #{cno,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Course record);
}