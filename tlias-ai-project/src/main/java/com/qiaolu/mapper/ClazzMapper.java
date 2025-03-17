package com.qiaolu.mapper;

import com.qiaolu.pojo.Clazz;
import com.qiaolu.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 该接口用于班级列表数据的条件分页查询
     */
    List<Clazz> pagingQuery(ClazzQueryParam clazzQueryParam);

    /**
     * 该接口用于添加班级信息
     */
    void addClazz(Clazz clazz);

    /**
     * 根据id删除班级
     * @param id
     */
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from  clazz where id = #{id}")
    Clazz getById(Integer id);

    /**
     * 修改班级
     * @param clazz
     */
    void update(Clazz clazz);
}




