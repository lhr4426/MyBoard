package com.stopError.MyBoard.controller;

import com.stopError.MyBoard.domain.Board;
import com.stopError.MyBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("cnt", boardService.boardCount());
        model.addAttribute("test", boardService.boardList());
        model.addAttribute("list", boardService.boardList());
        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long id) {
        boardService.viewCount(id);
        model.addAttribute("halo", boardService.getBoard(id));

        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board){
        boardService.uploadBoard(board);
        return "redirect:/board/main"; // 여기는 리다이렉트라 html 경로 아니고 주소임
    }

    @GetMapping("/update")
    public String updateBoardForm(Model model, Long id) {
        model.addAttribute("update", boardService.getBoard(id));
        return "/boards/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/main";
    }
}