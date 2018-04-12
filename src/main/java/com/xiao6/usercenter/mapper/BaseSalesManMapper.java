package com.xiao6.usercenter.mapper;

import com.github.pagehelper.Page;
import com.xiao6.usercenter.entity.BaseSalesMan;
import com.xiao6.usercenter.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

public interface BaseSalesManMapper extends MyMapper<BaseSalesMan> {
    Page<BaseSalesMan> selectAllPage();
}