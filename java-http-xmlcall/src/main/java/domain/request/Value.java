package domain.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Value {
    private Struct struct;

    @XmlElement
    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    @Override
    public String toString() {
        return "Value{" +
                "struct=" + struct +
                '}';
    }
}
