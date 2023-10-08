package com.imranmadbar.domain.request.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteScript {
    @XmlElement(name = "p-sessionKey")
    private String pSessionKey;
    @XmlElement(name = "p-includeName")
    private String pIncludeName;
    @XmlElement(name = "p-parameters")
    private Parameters pParameters;

    public void setPSessionKey(String pSessionKey) {
        this.pSessionKey = pSessionKey;
    }

    public String getPSessionKey() {
        return pSessionKey;
    }


    public void setPIncludeName(String pIncludeName) {
        this.pIncludeName = pIncludeName;
    }

    public String getPIncludeName() {
        return pIncludeName;
    }

    public void setPParameters(Parameters pParameters) {
        this.pParameters = pParameters;
    }

    public Parameters getPParameters() {
        return pParameters;
    }

}
