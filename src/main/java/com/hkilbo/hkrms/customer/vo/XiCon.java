package com.hkilbo.hkrms.customer.vo;

import org.springframework.stereotype.Repository;

@Repository
public class XiCon {
    private String ip = "";
    private String port = "";

    private String userName = "";
    private String password = "";
    private String fi37Channel="";
    private String fi38Channel="";
    private String fi39Channel="";
    private String fi48Channel="";

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFi37Channel() {
        return fi37Channel;
    }
    public void setFi37Channel(String fi37Channel) {
        this.fi37Channel = fi37Channel;
    }
    public String getFi38Channel() {
        return fi38Channel;
    }
    public void setFi38Channel(String fi38Channel) {
        this.fi38Channel = fi38Channel;
    }
    public String getFi39Channel() {
        return fi39Channel;
    }
    public void setFi39Channel(String fi39Channel) {
        this.fi39Channel = fi39Channel;
    }

    public String getFi48Channel() {
        return fi48Channel;
    }
    public void setFi48Channel(String fi48Channel) {
        this.fi48Channel = fi48Channel;
    }

}

