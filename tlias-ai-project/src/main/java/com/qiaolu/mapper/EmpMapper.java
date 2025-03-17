package com.qiaolu.mapper;

import com.qiaolu.pojo.Emp;
import com.qiaolu.pojo.EmpExpr;
import com.qiaolu.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    // -------- 原始方法-----------------------
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    Long total();
//
//    @Select("select emp.*, dept.name as deptName from emp left join dept on emp.dept_id = dept.id ORDER BY emp.update_time limit #{beginNum}, #{pageSize} ")
//    List<Emp> page(Integer beginNum, Integer pageSize);

    // --------  pageHelper 插件   -------------------
    List<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工-基本信息
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void saveEmp(Emp emp);
}

