package top.imyzt.tea.core.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.imyzt.tea.bo.RestVO;
import top.imyzt.tea.core.exception.TeaException;

/**
 * Created by imyzt on 2018/11/21 16:58
 */
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RestVO exceptionHandler(Exception e) {

        RestVO<Object> rest = new RestVO<>();

        // 设置默认错误
        rest.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMsg("系统故障");

        // 业务异常
        if (e instanceof TeaException) {
            TeaException teaException = (TeaException) e;
            rest.setCode(teaException.getCode()).setMsg(teaException.getMessage());
        }
        return rest;
    }
}
