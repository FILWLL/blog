package com.hjljy.blog.common;

import java.io.Serializable;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/27 0027 11:29
 * @Description: 前端数据返回
 */
public class AjaxJson implements Serializable {

    private static final long serialVersionUID = 1L;
    private int code;
    private long count;
    private String msg;
    private boolean success;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    /**
     * 设置获取分页成功后的数据信息
     * @param data
     * @param count
     */
    public void setPageSuccessData(Object data,long count) {
        this.data = data;
        this.success =true;
        this.code=Const.SUCCEED;
        this.count=count;
        this.msg=Const.DATA_SUCCEED;
    }

    /**
     * 设置成功返回的数据
     * @param data
     */
    public void setSuccessData(Object data) {
        this.code=Const.SUCCEED;
        this.data = data;
        this.success =true;
        this.msg=Const.DATA_SUCCEED;
    }
    /**
     * 设置失败返回的数据
     * @param msg
     */
    public void setFailMsg(String msg){
        this.code=Const.FAIL;
        this.success =false;
        this.msg=msg;
    }

    /**
     * 设置成功返回的数据
     * @param msg
     */
    public void setSuccessMsg(String msg){
        this.code=Const.SUCCEED;
        this.success =true;
        this.msg=msg;
    }
}
