package com.qiaolu.service;

import com.qiaolu.pojo.Emp;
import com.qiaolu.pojo.EmpQueryParam;
import com.qiaolu.pojo.PageResult;


public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void saveeEmp(Emp emp) throws Exception;
}
