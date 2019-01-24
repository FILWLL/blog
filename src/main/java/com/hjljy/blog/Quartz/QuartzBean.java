package com.hjljy.blog.Quartz;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/22 0022 17:42
 * @Description:
 */
public class QuartzBean {
    /** 任务id */
    private String  id;

    /** 任务名称 */
    private String jobName;

    /** 指定执行类 */
    private String jobClass;

    /** 任务状态  暂停or启用 */
    private Integer status;

    /** 任务运行时间表达式 */
    private String cronExpression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

}
