package com.goodjunseon.Board.controller;

import com.goodjunseon.Board.dto.BoardDTO;
import com.goodjunseon.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor // 생성자 주입 방식으로 boardService 자동 생성자 생성
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/") // 데이터를 가져와야할 때 Model 객체 사용
    public String findAll(Model model) {
        // DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}") // /board/id
    public String findById(@PathVariable("id") Long id, Model model) {
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html에 출력
         */
        System.out.println("넘어온 id = " + id);
        boardService.updateHits(id); // 조회수 처리
        // 파라미터로 받은 id값에 맞는 board dto 값을 넘겨주고 model로 detail.html에 넘겨준다.
        BoardDTO boardDTO = boardService.findById(id); // 해당 데이터 넘겨주기
        model.addAttribute("board", boardDTO);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) { //무조건 명시적 처리 해줘야함!!
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board",board);
        return "detail";
//        return "redirect:/board/" + boardDTO.getId();
    }

}
