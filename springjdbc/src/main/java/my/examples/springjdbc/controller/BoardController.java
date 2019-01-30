package my.examples.springjdbc.controller;


import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.CommandMap;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }
    @GetMapping("/board")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model) {
        List<Board> boards = boardService.getBoards(page);
        model.addAttribute("boards", boards);
        return "board"; // view name
    }

    @GetMapping("/view")
    public String view(long id, Model model){
        Board board = boardService.getBoard(id);
        boardService.getBoard(id);
        model.addAttribute("board", board);
        return "view";
    }

    @GetMapping("/delete"){
    }

    @GetMapping("/writeform")
    public String writeform(){ return "writeform"; }

    @PostMapping("/write")
    public String write(@RequestParam(name = "name") String name,
                        @RequestParam(name = "title") String title,
                        @RequestParam(name = "content") String content
                        ){

        Assert.hasLength(name, "이름을 입력하세요.");
        Assert.hasLength(title, "제목을 입력하세요");

        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);

        boardService.addBoard(board);
//        "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth from board order by group_no desc, group_seq limit :start, :limit";

        return "redirect:/board";
    }

}

