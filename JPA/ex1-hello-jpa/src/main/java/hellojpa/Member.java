package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// 테이블 이름이 클래스 이름과 다른 경우 @Table(name="") 으로 매핑
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // 기본 생성자가 존재해야 함
    public Member() {}

}
