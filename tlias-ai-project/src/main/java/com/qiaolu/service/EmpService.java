package com.qiaolu.service;

import com.qiaolu.pojo.Emp;
import com.qiaolu.pojo.EmpQueryParam;
import com.qiaolu.pojo.PageResult;

import java.util.List;


public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void saveeEmp(Emp emp) throws Exception;

    List<Emp> findAll();
}
