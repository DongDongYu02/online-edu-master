package cn.yd.service.servicebase.handler;

import cn.yd.commonVo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<?> error(Exception e){
        log.error(e.getMessage());
        return Result.error("出现错误："+e.getMessage());
    }
}
