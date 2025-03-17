package com.qiaolu.controller;

import com.qiaolu.pojo.Clazz;
import com.qiaolu.pojo.ClazzQueryParam;
import com.qiaolu.pojo.PageResult;
import com.qiaolu.pojo.Result;
import com.qiaolu.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    // 复杂参数接收方式一--@RequestParam

    /**
     * 该接口用于班级列表数据的条件分页查询
     */
    @GetMapping
    public Result pagingQuery(ClazzQueryParam clazzQueryParam) {
        log.info("name = {}", clazzQueryParam);
        PageResult<Clazz> pageResult= clazzService.pagingQuery(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    @PostMapping("/clazzs")
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("班级信息:" + clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    /**
     * 该接口用于查询所有班级信息
     * @return
     */
    @GetMapping("/list")
    public Result findAll() {
        List<Clazz> list = clazzService.findAll();
        log.info("所有班级://n" + list.toString());
        return Result.success(list);
    }
}
