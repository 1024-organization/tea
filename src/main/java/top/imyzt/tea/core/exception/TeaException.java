package top.imyzt.tea.core.exception;

import lombok.Getter;

/**
 * Created by imyzt on 2018/11/21 17:00
 */
@Getter
public class TeaException extends RuntimeException{

    private int code = 2;

    private String message;

    public TeaException() {
        this.message = "操作失败";
    }

    public TeaException(String message) {
        super(message);
        this.message = message;
    }
}
