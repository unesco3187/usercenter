package com.xiao6.usercenter.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiao6.usercenter.entity.BaseSalesMan;
import com.xiao6.usercenter.mapper.BaseSalesManMapper;
import com.xiao6.usercenter.service.BaseSalesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-10 16:30
 **/
@Service
public class BaseSalesManServiceImpl implements BaseSalesManService {


    @Autowired
    private BaseSalesManMapper baseSalesManMapper;


    @Override
    public List<BaseSalesMan> getList() {
        return baseSalesManMapper.selectAll();
    }

    @Override
    public Page<BaseSalesMan> getListPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<BaseSalesMan> baseSalesManPage = baseSalesManMapper.selectAllPage();
        return baseSalesManPage;
    }

    @Override
    public List<BaseSalesMan> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BaseSalesMan> salesManList = baseSalesManMapper.selectAll();
        return salesManList;
    }
}
