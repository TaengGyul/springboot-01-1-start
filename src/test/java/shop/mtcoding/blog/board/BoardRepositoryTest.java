package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

// 내가 만든 해당 객체를 테스트 전용 IoC에 로드
@Import(BoardRepository.class)
@DataJpaTest // DB 관련 모든 객체를 IoC에 로드
public class BoardRepositoryTest {

    @Autowired // DI
    private BoardRepository boardRepository;

    @Test
    public void save_test() {
        // given (데이터 준비)
        String title = "제목 6";
        String content = "내용 6";

        // when (insert 메서드 테스트)
        boardRepository.save(title, content);

        //eye
        System.out.println("새로운 글 제목 : " + title + " 새로운 글 내용 : " + content);
    } // 메서드 종료시 자동 rollback이 된다.

//    @Test
//    public void findAll_test() {
//        // given
//
//        // when
//        List<Board> boardList = boardRepository.findAll();
//
//        // then
//        if (boardList.isEmpty()) {
//            System.out.println("boardList is empty");
//        } else {
//            for (Board board : boardList) {
//                System.out.println("Id : " + board.getId() + ", title : " + board.getTitle() + ", content : " + board.getContent());
//            }
//        }
//    }

    // 책에 나온 테스트 코드
    @Test
    public void findAll_test() {
        List<Board> boards = boardRepository.findAll();
        Assertions.assertThat(boards.get(0).getId()).isEqualTo(5);
        Assertions.assertThat(boards.get(0).getTitle()).isEqualTo("제목5");
        Assertions.assertThat(boards.get(0).getContent()).isEqualTo("내용5");
        System.out.println("테스트 성공!!");
    }

    @Test
    public void findById_test() {
        int id = 1;
        Board board = boardRepository.findById(id);
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.getContent()).isEqualTo("내용1");
    }

    @Test
    public void deleteById_test() {
        int id = 1;
        boardRepository.deleteById(id);
        System.out.println("삭제 성공!!!");
    }

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String title = "변경된 글제목!!!";
        String content = "변경된 글 내용!!!";

        // when
        boardRepository.updateById(id, title, content);

        //eye
        System.out.println("게시글 ID : " + id + " 게시글 제목 : " + title + " 게시글 내용 : " + content);
    }
}
