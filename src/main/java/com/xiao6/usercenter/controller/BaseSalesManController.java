package com.xiao6.usercenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiao6.usercenter.entity.BaseSalesMan;
import com.xiao6.usercenter.exception.CodeValidaExcepiton;
import com.xiao6.usercenter.form.AddUserForm;
import com.xiao6.usercenter.param.request.ReqBaseSalesMan;
import com.xiao6.usercenter.service.BaseSalesManService;
import com.xiao6.usercenter.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/signTest")
    public AjaxResult signTest(@RequestBody AddUserForm addUserForm){
//        Map<String, String> map = SignUtil.toVerifyMap(request.getParameterMap(),false);
        Map<String,String> map = new HashMap<>(BeanMap.create(addUserForm));
        System.out.println(JSONObject.toJSONString(map));
        String content = SignUtils.getSignCheckContentV1(SignUtils.paraFilter(map));
        String mysign = DigestUtils.md5Hex((content + SignUtils.appSecret).getBytes());
        System.out.println("验签的sign: "+ mysign);
        System.out.println("接口传入的sign: " + addUserForm.getSign());
        System.out.println(mysign.equals(addUserForm.getSign()));
        return AjaxResult.success();
    }

    public static void main(String[] args) throws Exception {
//        Map map = new HashMap();
//        map.put("name","meiwenjun");
//        map.put("age",30);
//        System.out.println(JSONObject.toJSONString(map, SerializerFeature.UseSingleQuotes));
        String jsonStr = "{\n" +
                " \"data\":{\n" +
                "  \"bcTktRefundSynVO\":{\n" +
                "   \"airitemNo\":8294955,\n" +
                "   \"dealBServiceFee\":0.0,\n" +
                "   \"dealTime\":\"2019-06-28 15:54:41\",\n" +
                "   \"ticketNo\":\"9995060672420\",\n" +
                "   \"di\":\"d\",\n" +
                "   \"manipulateId\":\"330702197509051214\",\n" +
                "   \"journeyNo\":105463603,\n" +
                "   \"pnrNo\":\"HN1VHM\",\n" +
                "   \"dealBOperFee\":0.0,\n" +
                "   \"corpCode\":\"QHFYCAFA\",\n" +
                "   \"psgId\":10070480\n" +
                "  },\n" +
                "  \"accountName\":\"NGB207\",\n" +
                "  \"type\":1\n" +
                " },\n" +
                " \"appId\":\"qiHang\",\n" +
                " \"sign\":\"567503d0884a135ff3ecbec3c86dcab7\"\n" +
                "}";
        JSONObject jsonObject = HttpClient.postJson("http://xyb.wisedu.com/interface/validate/validateSign", jsonStr);
        System.out.println(jsonObject.toJSONString());
    }

}
