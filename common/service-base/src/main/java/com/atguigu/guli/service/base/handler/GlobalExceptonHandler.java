package com.atguigu.guli.service.base.handler;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice//用来监控controller的方法是否有异常，如果有异常会被当前类去处理
public class GlobalExceptonHandler {
    //异常处理方法
    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
       log.error("异常："+ ExceptionUtils.getStackTrace(e));
        e.printStackTrace();
        return R.error();
    }
    //捕获指定类型的异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R exception(HttpMessageNotReadableException e){
        //e.printStackTrace();
        log.error("异常："+ ExceptionUtils.getStackTrace(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }
}
