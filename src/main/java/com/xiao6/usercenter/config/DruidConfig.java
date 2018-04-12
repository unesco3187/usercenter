package com.xiao6.usercenter.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-12 16:02
 **/
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("resetEnable", "false"); //禁用HTML页面上的“Rest All”功能
//        initParameters.put("allow", "10.8.9.115");  //ip白名单（没有配置或者为空，则允许所有访问）
        initParameters.put("loginUsername", "fuzhong");  //++监控页面登录用户名
        initParameters.put("loginPassword", "meiwenjun");  //++监控页面登录用户密码
        initParameters.put("deny", ""); //ip黑名单
        //如果某个ip同时存在，deny优先于allow
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

}
