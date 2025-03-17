package com.qiaolu.controller;

import com.qiaolu.pojo.Emp;
import com.qiaolu.pojo.EmpQueryParam;
import com.qiaolu.pojo.PageResult;
import com.qiaolu.pojo.Result;
import com.qiaolu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    // -----------------  分页查询--------------------------
//    /**
//     * 员工分页查询
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
//       log.info("page=" + page + " pageSize=" + pageSize);
//        PageResult<Emp> pageResult = empService.page(page, pageSize);
//       return Result.success(pageResult);
//    }

    // ------------------ 条件分页查询-----------------------------

    /**
     * 员工条件分页查询
     * @param empQueryParam
     * @return
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询参数为: " + empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增员工(基本信息与工作经历)
     * @param emp
     * @return
     * @throws Exception
     */
    @PostMapping
    public Result saveEmp(@RequestBody Emp emp) throws Exception {
        log.info("请求参数: {}", emp);
        empService.saveeEmp(emp);
        return Result.success();
    }

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/list")
    public Result findAll() {
        log.info("查询所有员工");
        List<Emp> list = empService.findAll();
        return Result.success(list);
    }

}
