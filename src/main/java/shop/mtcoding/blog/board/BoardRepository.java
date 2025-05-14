package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// 이 클래스가 스프링에 의해 관리 (IoC) 되도록 하는 어노테이션
@Repository
public class BoardRepository {

    @Autowired // EntityManager를 IoC에서 가져오는 (DI) 어노테이션
    private EntityManager em;

    @Transactional // 메서드 종료시에 자동 commit 해주는 어노테이션
    public void save(String title, String content) {
        // 1. 쿼리 작성
        Query query = em.createNativeQuery("insert into board_tb (title, content, created_at) values (?, ?, now())");
        
        // 2. 쿼리의 ?(물음표) 부분 변수 바인딩
        query.setParameter(1, title);
        query.setParameter(2, content);

        // 3. 쿼리를 데이터베이스에 전송
        query.executeUpdate();
    }
}
