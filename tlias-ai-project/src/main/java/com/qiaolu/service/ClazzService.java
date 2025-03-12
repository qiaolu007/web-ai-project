package com.qiaolu.service;

import com.qiaolu.pojo.Clazz;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    /**
     * 该接口用于班级列表数据的条件分页查询
     * @param name
     * @param begin
     * @param end
     * @param page
     * @param pageSize
     * @return
     */
    List<Clazz> pagingQuery(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    /**
     * 该接口用于添加班级信息
     * @param clazz
     */
    void addClazz(Clazz clazz);

    /**
     * 该接口用于查询所有班级信息
     * @return
     */
    List<Clazz> findAll();
}
