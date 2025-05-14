package shop.mtcoding.blog.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String boardList() {
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
