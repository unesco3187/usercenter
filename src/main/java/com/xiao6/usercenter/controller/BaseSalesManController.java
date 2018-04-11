package com.xiao6.usercenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xiao6.usercenter.entity.BaseSalesMan;
import com.xiao6.usercenter.service.BaseSalesManService;
import com.xiao6.usercenter.util.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-10 16:37
 **/
@RestController
@RequestMapping("/salesman")
public class BaseSalesManController {

    public static final Logger logger = LoggerFactory.getLogger(BaseSalesManController.class);

    @Autowired
    private BaseSalesManService baseSalesManService;

    @ApiOperation(value = "获取业务员列表")
    @GetMapping(value = "/getList")
    public AjaxResult getList(){
        List<BaseSalesMan> list = baseSalesManService.getList();
        logger.info("info result:{}", JSONObject.toJSONString(list));
        logger.error("error result:{}",JSONObject.toJSONString(list));
        return AjaxResult.success(list);
    }

//    @GetMapping(value = "/getListPage/{pageNum}/{pageSize}")
//    public AjaxResult getListPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
//        Page<BaseSalesMan> lists;
//        lists = baseSalesManService.getListPage(pageNum,pageSize);
//        return AjaxResult.success(new PageInfo<>(lists));
//    }

    @GetMapping(value = "/getList/{pageNum}")
    public AjaxResult getList(@PathVariable("pageNum") Integer pageNum){
        Integer pageSize = 10;
        List<BaseSalesMan> list = baseSalesManService.getList(pageNum,pageSize);
        return AjaxResult.success(new PageInfo<>(list));
    }
}
