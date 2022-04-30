package domain.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Arrays;

@XmlRootElement
public class Struct {
    private Member[] member;

    @XmlElement
    public Member[] getMember() {
        return member;
    }

    public void setMember(Member[] member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "member=" + Arrays.toString(member) +
                '}';
    }
}
