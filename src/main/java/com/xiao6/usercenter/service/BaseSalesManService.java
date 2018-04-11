package com.xiao6.usercenter.service;

import com.github.pagehelper.Page;
import com.xiao6.usercenter.entity.BaseSalesMan;

import java.util.List;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-10 16:30
 **/
public interface BaseSalesManService {
    List<BaseSalesMan> getList();

    Page<BaseSalesMan> getListPage(Integer pageNum, Integer pageSize);

    List<BaseSalesMan> getList(Integer pageNum, Integer pageSize);
}
