package com.hjljy.blog.common;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/27 0027 11:29
 * @Description:
 */
public class AjaxJson {
    private String msg;
    private boolean success;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
