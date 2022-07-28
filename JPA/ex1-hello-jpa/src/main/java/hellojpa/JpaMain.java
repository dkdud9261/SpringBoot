package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 디비 당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 고객의 요청이 올 때마다 생성하고 다 쓰면 삭제
        // 쓰레드 간에 공유하면 안된다.
        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랜잭션 안에서 수행해야 한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 1L);

            // JPA를 통해서 가져온 Entity는 JPA가 관리
            // commit 하기 전에 JPA가 변경사항이 없는지 확인
            // 변경이 있으면 update 쿼리를 만들어서 날린 후 transaction을 commit함
//            findMember.setName("HelloJPA");

            // JPA는 테이블이 아닌 엔티티 객체를 대상으로 쿼리를 짠다. (객체지향 쿼리언어 JPQL)
            // 아래 코드는 Member 테이블의 모든 컬럼을 가져오는 것이 아니라
            // Member 객체를 모두 가져오라는 것을 의미.
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList();

            // [ 검색 쿼리 ]
            // 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색한다.
            // 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능
            // 결국 필요한 데이터만 DB에서 불러오기 위해 검색 조건이 필요한 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공
            // SQL은 데이터베이스 테이블을 대상으로 쿼리 vs JPQL은 엔티티 객체를 대상으로 쿼리 -> 방언을 변경해도 쿼리 변경 필요 x 즉 특정 데이터베이스 SQL에 의존하지 않는다.

           tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
