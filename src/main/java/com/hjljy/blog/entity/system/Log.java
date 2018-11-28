package com.hjljy.blog.entity.system;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_log")
public class Log {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 操作人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    private Integer responseTime;

    /**
     * 操作方法
     */
    @Column(name = "operation_method")
    private String operationMethod;

    /**
     * 具体操作
     */
    @Column(name = "operation_type")
    private String operationType;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Date operationTime;

    /**
     * 错误信息
     */
    @Column(name = "errorMsg")
    private String errormsg;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作人
     *
     * @return user_name - 操作人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置操作人
     *
     * @param userName 操作人
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取操作人id
     *
     * @return user_id - 操作人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置操作人id
     *
     * @param userId 操作人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取响应时间
     *
     * @return response_time - 响应时间
     */
    public Integer getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间
     *
     * @param responseTime 响应时间
     */
    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取操作方法
     *
     * @return operation_method - 操作方法
     */
    public String getOperationMethod() {
        return operationMethod;
    }

    /**
     * 设置操作方法
     *
     * @param operationMethod 操作方法
     */
    public void setOperationMethod(String operationMethod) {
        this.operationMethod = operationMethod == null ? null : operationMethod.trim();
    }

    /**
     * 获取具体操作
     *
     * @return operation_type - 具体操作
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置具体操作
     *
     * @param operationType 具体操作
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
    }

    /**
     * 获取操作时间
     *
     * @return operation_time - 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 获取错误信息
     *
     * @return errorMsg - 错误信息
     */
    public String getErrormsg() {
        return errormsg;
    }

    /**
     * 设置错误信息
     *
     * @param errormsg 错误信息
     */
    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }
}