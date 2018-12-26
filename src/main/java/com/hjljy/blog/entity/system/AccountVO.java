package com.hjljy.blog.entity.system;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/19 0019 09:23
 * @Description: account界面展示数据对应类
 */
public class AccountVO extends Account {
    private String roleName;

    private String orgName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "AccountVO{" + "roleName='" + roleName + '\'' + ", orgName='" + orgName + '\'' + '}';
    }
}
