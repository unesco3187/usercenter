package com.xiao6.usercenter.mapper;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.xiao6.usercenter.entity.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlMapperTest {

    @Autowired
    private GirlMapper girlMapper;

    @Test
    public void saveTest(){
        Girl girl = new Girl();
        girl.setAge(1);
        girl.setCreateTime(new Date());
        girl.setCupSize("36D");
//        girlMapper.insert(girl);
        int count = girlMapper.insertUseGeneratedKeys(girl);
        System.out.println(count);
        System.out.println(girl.getId());
    }

    @Test
    public void getOne(){
        Girl girl =  new Girl();
        girl.setId(18);
        Girl girl1 = girlMapper.selectOne(girl);
        System.out.println(JSONObject.toJSONString(girl1));
//        System.out.println(JSONUtils.toJSONString(girl1));
    }
}