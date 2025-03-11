package com.qiaolu.service.iml;

import com.qiaolu.mapper.DeptMapper;
import com.qiaolu.pojo.Dept;
import com.qiaolu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceIml implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getInfoById(Integer id) {
        return deptMapper.getInfoById(id);

    }

    @Override
    public void updateInfo(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateInfo(dept);
    }


}
