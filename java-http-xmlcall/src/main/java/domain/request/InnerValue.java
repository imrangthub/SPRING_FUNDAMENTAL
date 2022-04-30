package domain.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "value")
public class InnerValue {
    private String string;
    private String dateTime;

    @XmlElement(name = "dateTime.iso8601")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @XmlElement
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "InnerValue{" +
                "string='" + string + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
