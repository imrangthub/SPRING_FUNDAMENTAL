package com.imranmadbar.domain.response.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "executeScriptResponseStruct", namespace = "http://tempuri.org/message/")
    private ExecuteScriptResponseStruct executeScriptResponseStruct;

    public void setExecuteScriptResponseStruct(ExecuteScriptResponseStruct executeScriptResponseStruct) {
        this.executeScriptResponseStruct = executeScriptResponseStruct;
    }

    public ExecuteScriptResponseStruct getExecuteScriptResponseStruct() {
        return executeScriptResponseStruct;
    }
}
