package com.xiao6.usercenter.handle;

import com.xiao6.usercenter.exception.CodeValidaExcepiton;
import com.xiao6.usercenter.util.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-12 16:53
 **/
@ControllerAdvice
public class ExceptionHandle {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult errorHandler(HttpServletRequest reqest,
                                   HttpServletResponse response, Exception e) throws Exception {

        if (e instanceof CodeValidaExcepiton) {
            CodeValidaExcepiton girlException = (CodeValidaExcepiton) e;
            return AjaxResult.failed(girlException.getMessage());
        }else {
            logger.error("system_error:{}", e);
            return AjaxResult.failed("system error");
        }

    }




    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
