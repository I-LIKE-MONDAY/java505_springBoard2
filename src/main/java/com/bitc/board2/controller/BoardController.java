package com.bitc.board2.controller;

import com.bitc.board2.dto.BoardDto;
import com.bitc.board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.List;
//  Rest란?
// Representation State Transfer의 약자
// 기존 웹은 웹 프로토콜인 http의 모든 기능을 다 활용하지 못하고 있어 그것을 해결하기 위한 방법으로 제시된 방식
// 자원을 이름으로 구분하고 해당 자원의 상태를 주고 받는 모든 것을 의미
// 자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것
// http 프로토콜을 그대로 활용(Get, Update, Delete)하여 해당 자원의 CRUD 명령을 적용하는 것을 의미함.
// 웹의 모든 자원에 고유한 id인 http url를 부여함
// 원래는 get과 post 두 개로 데이터를 보냈는데, 두 가지를 더 추가하였다.
// get-> select / post -> insert / update->update / delete->delete
// ex. board/view/10 -> 10번 보드를 보겠다.

// 자원(Resource) URL
// 모든 자원에 고유한 id가 존재하고, 이 자원은 서버에 존재
// 자원을 구분하는 id는 /orders/order_id/1 형태 같은 http url임.

// 행위(Verb) Http Method
// http 프로토콜의 method임
// http 프로토콜은 get,post, update, delete와 같은 메서드를 제공

// 표현 (Repersentation of Resource)
//client가 자원의 상태에 대한 조작을 요청 시 서버는 이에 적절한 응답을 보냄
// rest에서 하나의 자원은 json, xml, text, rss 등 여러 형태의 representation으로 나타낼 수 있음
// 현재는 json으로 주고 받는 것이 대부분임

// GET : 해당 URI의 리소스를 조회
// POST : 리소스를 생성
// PUT : 해당 URI의 리소스를 수정
// DELETE : 해당 URI의 리소스를 삭제




@Controller
public class BoardController {
    @Autowired
    private BoardService boardService; //이걸 넣으니 문제 해결됨
    @RequestMapping("/")
    public String index() throws Exception{
        return "index";
    }

    //    board1에서 유사하지만 여기서는 /board로 끝낸다.
    @RequestMapping(value = "/board", method = RequestMethod.GET) //받아주는 방식
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/restBoardList");

        List<BoardDto> boardList = boardService.selectBoardList(); // 서비스로 간다
        mv.addObject("boardList",boardList);
//        사용자가 있고 사용자가 요청을 하게 되면 컨트롤러가 받아 서비스로 넘기고 서비스에서 처리할 것 처리하고 메퍼로 넘긴다.
//        ORM(우리는 mybtis사용중)은 db로 연결된다. db-> orm -> service(처리) -> 컨트롤러 -> view(html) -> 사용자

        return mv;
    }
//    아래의 writeBoard()와 insertBoard() 메서드는 서로 매칭된 주소가 동일하지만 method의 타입이 다르기 때문에
//    다르게 동작이 된다.
//    get을 사용한 writeBoard() 메서드는 view를 표현하고, post를 사용한 insertBoard() 메서드는 데이터를 추가함

    //     두 개의 주소가 동일하다 그러나 get, post이기 때문에 // 글쓰기 -> post로 되어있으면 post로 된거 가져온다.
//    메서드 형식에 따라 동작하는 위치가 달라진다.
    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String writeBoard() throws Exception {
        return "board/restWriteBoard";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String insertBoard(BoardDto board) throws Exception{
        boardService.insertBoard(board);
        return "redirect:/board";
    }

    //    @PathVariable : URI의 리소스가 매서드의 파라미터로 사용하는 어노테이션
//여기 {idx}와(두 번째 줄) //여기("idx") 이름 같아야한다.(세 번째 줄)
    @RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("idx")int idx) throws Exception {
        ModelAndView mv = new ModelAndView("/board/restBoardDetail");

        BoardDto board = boardService.selectBoardDetail(idx);
        mv.addObject("board",board);

        return mv;
    }

    @RequestMapping(value = "board/update/{idx}", method = RequestMethod.PUT) // 업데이트는 PUT
    public String updateBoard(BoardDto board) throws Exception {
//        System.out.println("--------------------------------------");
//        System.out.println("updateBoard : " + board.getIdx());
        boardService.updateBoard(board);

        return "redirect:/board";
    }

    @RequestMapping(value = "board/delete/{idx}", method = RequestMethod.DELETE) // 삭제는 DELETE
    public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
//        System.out.println("--------------------------------------");
//        System.out.println("deleteBoard : " + idx);
        boardService.deleteBoard(idx);

        return "redirect:/board";
    }
}













