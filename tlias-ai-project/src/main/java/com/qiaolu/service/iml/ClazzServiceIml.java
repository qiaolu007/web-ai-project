package com.qiaolu.service.iml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiaolu.mapper.ClazzMapper;
import com.qiaolu.pojo.Clazz;
import com.qiaolu.pojo.ClazzQueryParam;
import com.qiaolu.pojo.PageResult;
import com.qiaolu.service.ClazzService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceIml implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 条件分页查询班级列表
     * @param clazzQueryParam
     * @return
     */
    @Override
    public PageResult<Clazz> pagingQuery(ClazzQueryParam clazzQueryParam) {
        Integer page = clazzQueryParam.getPage();
        Integer pageSize =clazzQueryParam.getPageSize();
        PageHelper.startPage(page, pageSize);

        // 查询总条数和数据都封装在Page<T>中了
        Page<Clazz> list = (Page<Clazz>) clazzMapper.pagingQuery(clazzQueryParam);
        for (Clazz clazz : list) {
            clazz.calculateState(LocalDate.now());
        }

        return new PageResult<>(list.getTotal(), list.getResult());
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        List<Clazz> list = clazzMapper.findAll();
        return list;
    }
}
