package com.xiao6.usercenter.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;
public class SignUtils {

    public static  final String appSecret = "111222333";


    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (StringUtil.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    public static String getSignCheckContentV1(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }
        System.out.println(content.toString());
        return content.toString();
    }

    /**
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    public static Map<String, String> sign(Map<String, String> sParaTemp) {
        //时间戳加入签名参数组中
//        sParaTemp.put("timestamp", String.valueOf(System.currentTimeMillis()));
        //除去数组中的空值和签名参数
        Map<String, String> sPara = paraFilter(sParaTemp);
        //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String content = getSignContent(sParaTemp);
        //生成签名结果(参数+appSecret进行MD5以32位16进制的小写字符串形式)
        String mysign = DigestUtils.md5Hex((content + appSecret).getBytes());
        //签名结果加入请求提交参数组中
        sPara.put("sign", mysign);
        return sPara;
    }


    public static void main(String[] args) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("appId","qiHang");
        map.put("name","梅文军");
        map.put("age","30");
        map.put("mobile","15951617393");
        //加签
        Map<String, String> signMap = sign(map);
        JSONObject jsonObject = HttpClient.postJson("http://127.0.0.1:8082/salesman/signTest", JSONObject.toJSONString(signMap));
        System.out.println(JSONObject.toJSONString(signMap));
        System.out.println(jsonObject.toJSONString());
    }
}
