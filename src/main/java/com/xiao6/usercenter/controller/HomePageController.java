package com.xiao6.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-12 12:05
 **/
@Controller
@ApiIgnore
@Slf4j
public class HomePageController {
    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}
