package com.xiao6.usercenter.controller;

import com.xiao6.usercenter.util.HttpClient;
import com.xiao6.usercenter.util.SignUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class signTestController {
    /**
     * 模拟客户端请求API接口
     * @param request
     * @return
     */
    @RequestMapping("send")
    public String send(HttpServletRequest request){
        Map<String,String> param = new HashMap<>();
        param.put("userId","9527");
        param.put("amount","9.99");
        param.put("productId","9885544154");
        param.put("secretKey","mysecret123456");
        try {
            String postResult = HttpClient.post("http://localhost:8099/test", SignUtil.sign(param));
            return postResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 模拟服务的API接口
     * @param request
     * @return
     */
    @RequestMapping("checkSign")
    public String checkSign(HttpServletRequest request){
        //从request中获取参数列表，转成map
        Map<String, String> map = SignUtil.toVerifyMap(request.getParameterMap(),false);
        String secretKey =  map.get("secretKey");
        if (StringUtils.isEmpty(secretKey) || !map.get("secretKey").equals(SignUtil.SECRET_KEY)){
            System.out.println("secretKey is err");
            return "fail";
        }
        if (SignUtil.verify(map)){
            return "success";
        }else {
            return "fail";
        }
    }
}
