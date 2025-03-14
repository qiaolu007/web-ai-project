package com.qiaolu.mapper;

import com.qiaolu.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 该接口用于班级列表数据的条件分页查询
     */
    @Select("select * from clazz where name like concat('%', #{name}, '%') and begin_date >= #{begin} and end_date <= #{end} limit #{beginNum}, #{pageSize}")
    List<Clazz> pagingQuery(@Param("name") String name, @Param("begin") LocalDate begin, @Param("end") LocalDate end, @Param("beginNum") Integer beginNum, @Param("pageSize") Integer pageSize);

    /**
     * 该接口用于添加班级信息
     */
    void addClazz(Clazz clazz);

    /**
     * 该接口用于查询所有班级信息
     */
    List<Clazz> findAll();
}




