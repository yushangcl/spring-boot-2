package com.whh.spring.boot.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Map;

/**
 * 信息返回
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
public class AbsResponse<T> implements Serializable {
    /**
     * 错误代码：如果为0则表示成功，其他均为失败，值自定义
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 结果信息
     */
    @JsonIgnore
    private String body;

    /**
     * 返回结果
     */
    private T data;

    /**
     * 参数列表
     */
    @JsonIgnore
    private Map<String, String> params;

    public AbsResponse() {
        this(0, (String) null);
    }

    public AbsResponse(int code, String msg) {
        this(code, msg, (String) null);
    }

    public AbsResponse(int code, String msg, String body) {
        this(code, msg, body, null);
    }

    public AbsResponse(int code, String msg, String body, T data) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.data = data;
    }

    public AbsResponse<T> setResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public AbsResponse<T> setResult(int code, String msg, String body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        return this;
    }

    public AbsResponse<T> setResult(int code, String msg, String body, T data) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.data = data;
        return this;
    }

    public AbsResponse<T> setResult(AbsResponse<?> ano) {
        return this.setResult(ano.getCode(), ano.getMsg(), ano.getBody());
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public T getData() {
        return this.data;
    }

    public AbsResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "AbsResponse{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + ", params=" + this.params + '}';
    }
}
