package com.yzy.rcs.vo;

import com.yzy.rcs.domain.Users;

public class UsersVo extends Users {
    private Integer[] rid;
    private String[] rolename;
    private String loginip;

    public String[] getRolename() {
        return rolename;
    }

    public void setRolename(String[] rolename) {
        this.rolename = rolename;
    }

    public Integer[] getRid() {
        return rid;
    }

    public void setRid(Integer[] rid) {
        this.rid = rid;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }
}
