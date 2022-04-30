package domain.request;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
    private String name;
    private InnerValue value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerValue getValue() {
        return value;
    }

    public void setValue(InnerValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
