package com.imranmadbar.domain.response.login;

import javax.xml.bind.annotation.XmlElement;


public class Body {
    private LoginResponseStruct loginResponseStruct;

    @XmlElement(name = "loginResponseStruct", namespace = "http://tempuri.org/message/")
    public void setLoginResponseStruct(LoginResponseStruct loginResponseStruct) {
        this.loginResponseStruct = loginResponseStruct;
    }

    public LoginResponseStruct getLoginResponseStruct() {
        return loginResponseStruct;
    }
}
