package com.qiaolu.controller;

import com.qiaolu.pojo.Clazz;
import com.qiaolu.pojo.Result;
import com.qiaolu.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    // 复杂参数接收方式一--@RequestParam

    /**
     * 该接口用于班级列表数据的条件分页查询
     * @param name
     * @param begin
     * @param end
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/clazzs")
    public Result pagingQuery(
            @RequestParam String name,
            @RequestParam LocalDate begin,
            @RequestParam LocalDate end,
            @RequestParam Integer page,
            @RequestParam Integer pageSize) {
        log.info("name = " + name + " begin=" + begin + " end=" + end + " page=" + page + " pageSize=" + pageSize);
        List<Clazz> list = clazzService.pagingQuery(name, begin, end, page, pageSize);
        return Result.success(list);
    }

    // 请注意,形参一定需要@RequestBody修饰,才能找到对应的参数

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
    @GetMapping("/clazzs/list")
    public Result findAll() {
        List<Clazz> list = clazzService.findAll();
        log.info("所有班级://n" + list.toString());
        return Result.success(list);
    }
}
