package com.qiaolu.service;

import com.qiaolu.pojo.Clazz;
import com.qiaolu.pojo.ClazzQueryParam;
import com.qiaolu.pojo.PageResult;

public interface ClazzService {
    /**
     * 该接口用于班级列表数据的条件分页查询
     */
    PageResult<Clazz> pagingQuery(ClazzQueryParam clazzQueryParam);

    /**
     * 该接口用于添加班级信息
     * @param clazz
     */
    void addClazz(Clazz clazz);

    void deleteById(Integer id);

    Clazz getById(Integer id);

    void update(Clazz clazz);
}
