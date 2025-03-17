package com.qiaolu.mapper;

import com.qiaolu.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void savaEmpExpr(List<EmpExpr> list);
}
