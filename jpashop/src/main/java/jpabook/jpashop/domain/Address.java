package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable     // 어딘가에 내장될 수 있다 => 값 타입
@Getter
public class Address {

    private String city;
    private String string;
    private String zipcode;

    protected Address() {}  // JPA 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을 사용할 수 있도록 지원하기 위해 최소 protected로 기본 생성자를 두어야 한다.

    public Address(String city, String string, String zipcode) {
        this.city = city;
        this.string = string;
        this.zipcode = zipcode;
    }
}
