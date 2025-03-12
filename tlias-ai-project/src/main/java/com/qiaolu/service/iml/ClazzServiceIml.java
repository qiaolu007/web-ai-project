package com.qiaolu.service.iml;

import com.qiaolu.mapper.ClazzMapper;
import com.qiaolu.pojo.Clazz;
import com.qiaolu.service.ClazzService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceIml implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public List<Clazz> pagingQuery(String name, LocalDate begin,  LocalDate end, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize =10;
        }
        int beginNum = (page - 1) * pageSize;
        List<Clazz> list = clazzMapper.pagingQuery(name, begin, end, beginNum, pageSize);
        return list;
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
