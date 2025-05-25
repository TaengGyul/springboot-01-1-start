package shop.mtcoding.blog.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    // 1. @Repository로 IoC에 등록된 객체를 DI한다.
    @Autowired
    private BoardRepository boardRepository;

    // 2. Post 메서드로 사용자에게 데이터를 전달받을 수 있다.
    // 3. input 태그의 name 값과 동일한 이름으로 매개변수에 변수명을 적으면 값을 전달 받을 수 있다.
    @PostMapping("/board/save")
    public String boardSave(String title, String content) {
        // 4. 레파지토리에게 DB를 저장해 달라고 요청한다.
        boardRepository.save(title, content);
        // 5. DB에 저장되면, /board 요청으로 리다이렉션(302) 한다.
        return "redirect:/board";
    }

    // 게시글 목록 보기
    @GetMapping("/board")
    public String boardList(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("models", boards);
        return "board/list";
    }

    @GetMapping("/board/save-form")
    public String boardSaveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/1")
    public String boardDetail() {
        return "board/detail";
    }

    @GetMapping("/board/1/update-form")
    public String boardUpdateForm() {
        return "board/update-form";
    }
}
