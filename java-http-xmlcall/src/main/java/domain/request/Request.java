package domain.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "methodCall")
public class Request {
    private String methodName;
    private Params params;


    @XmlElement
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @XmlElement
    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Request{" +
                "methodName='" + methodName + '\'' +
                ", params=" + params +
                '}';
    }
}
