package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// 테이블 이름이 클래스 이름과 다른 경우 @Table(name="") 으로 매핑
public class Member {
    @Id
    private long id;
    private String name;

    // 기본 생성자가 존재해야 함
    public Member() {}

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
