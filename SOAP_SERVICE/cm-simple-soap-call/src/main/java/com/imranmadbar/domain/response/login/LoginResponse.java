package com.imranmadbar.domain.response.login;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class LoginResponse {

    private Body body;
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public void setBody(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }


}
