package com.imranmadbar.domain.request.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "executeScript", namespace = "http://tempuri.org/message/")
    private ExecuteScript executeScript;

    public void setExecuteScript(ExecuteScript executeScript) {
        this.executeScript = executeScript;
    }

    public ExecuteScript getExecuteScript() {
        return executeScript;
    }
}
