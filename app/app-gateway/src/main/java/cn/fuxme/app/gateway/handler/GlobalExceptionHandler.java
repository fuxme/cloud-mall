package cn.fuxme.app.gateway.handler;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/14
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 NotLoginException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = NotLoginException.class)
    public ResponseEntity<String> serviceExceptionHandler(NotLoginException ex) {
        log.debug("未登录", ex);
        return new ResponseEntity<>("请重新登录", HttpStatus.UNAUTHORIZED);
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        log.error("未知异常", e);
        return new ResponseEntity<>("服务异常，请稍后重试", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
