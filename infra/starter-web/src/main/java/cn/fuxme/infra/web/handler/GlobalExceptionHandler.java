package cn.fuxme.infra.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 全局异常处理器
 * @author: wuhao
 * @date: 2022/3/26
 **/
@ControllerAdvice()
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 MissingServletRequestParameterException 异常
     *
     * SpringMVC 参数不正确
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
        log.error("参数错误:", e);
        return new ResponseEntity<>("参数错误", HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理其它 Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("服务异常:", e);
        return new ResponseEntity<>("服务异常，请稍后重试", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
