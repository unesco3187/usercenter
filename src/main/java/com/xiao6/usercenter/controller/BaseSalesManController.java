package com.xiao6.usercenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiao6.usercenter.entity.BaseSalesMan;
import com.xiao6.usercenter.exception.CodeValidaExcepiton;
import com.xiao6.usercenter.param.request.ReqBaseSalesMan;
import com.xiao6.usercenter.service.BaseSalesManService;
import com.xiao6.usercenter.util.AjaxResult;
import com.xiao6.usercenter.util.RedisOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags="业务员")
@Slf4j
public class BaseSalesManController {

    @Autowired
    private BaseSalesManService baseSalesManService;

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation(value = "获取业务员列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="salesType",value="业务员类型（1：招商人员 2运营人员 3两者皆是）",required=true,paramType="query",dataType="int")
//    })
    @GetMapping(value = "/getList")
    public AjaxResult getList(ReqBaseSalesMan reqBaseSalesMan){
//        List<BaseSalesMan> list = baseSalesManService.getList();
//        if(true){
//            throw new CodeValidaExcepiton("越界了");
//        }
        log.info("info result:{}", JSONObject.toJSONString(null));
        log.error("error result:{}",JSONObject.toJSONString(null));
        return AjaxResult.success();
    }

    @GetMapping(value = "/getListPage/{pageNum}/{pageSize}")
    public AjaxResult getListPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        Page<BaseSalesMan> lists;
        lists = baseSalesManService.getListPage(pageNum,pageSize);
        return AjaxResult.success(new PageInfo<>(lists));
    }

    @ApiOperation(value = "获取业务员",notes = "分页获取业务员列表")
    @ApiImplicitParam(name = "pageNum",value = "页码",required = true,dataType = "int")
    @GetMapping(value = "/getList/{pageNum}")
    public AjaxResult getList(@PathVariable("pageNum") Integer pageNum){
        Integer pageSize = 10;
        List<BaseSalesMan> list = baseSalesManService.getList(pageNum,pageSize);
        return AjaxResult.success(new PageInfo<>(list));
    }


    @GetMapping(value = "/testRedis")
    public AjaxResult testRedis(){
        redisOperator.set("hehe","112");
        redisOperator.set("hehe","112");
        System.out.println(redisOperator.get("hehe"));
        return AjaxResult.success();
    }

}
