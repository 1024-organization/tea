package top.imyzt.tea.bo;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by imyzt on 2018/11/21 16:40
 */
@Getter
public class RestVO<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public RestVO<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public RestVO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RestVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public RestVO() {
    }

    public RestVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
