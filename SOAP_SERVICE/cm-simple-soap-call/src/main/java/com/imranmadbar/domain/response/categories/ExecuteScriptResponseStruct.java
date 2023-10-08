package com.imranmadbar.domain.response.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteScriptResponseStruct {
    private int errorCode;
    private String output;

//    @XmlElement(name = "errorCode")
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

//    @XmlElement(name = "output")
    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
