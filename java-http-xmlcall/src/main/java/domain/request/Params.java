package domain.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Params {
    private Param param;

    @XmlElement
    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Params{" +
                "param=" + param +
                '}';
    }
}
