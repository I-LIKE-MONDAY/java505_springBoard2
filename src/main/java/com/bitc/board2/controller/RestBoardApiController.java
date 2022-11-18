package com.bitc.board2.controller;

import com.bitc.board2.dto.BoardDto;
import com.bitc.board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController : @Controller 와 동일한 역할을 하는 어노테이션, @ResponseBody 어노테이션의 기능을 추가로 가지고 있음
/* @ResponseBody : 클라이언트의 요청에 대한 응답을 데이터 자체로 전달하는 어노테이션, 해당 어노테이션을 클래스 위에 입력할 경우
                   해당 클래스의 멤버 전체에 효과가 있고, 메서드 위에 입력할 경우 해당 메서드에만 적용됨 */
// JSON(JavaScript Object Notation) : 데이터 통신 시 사용하는 데이터 타입, 키(Key)와 값(Value)이 1:1로 매칭되어 있는 데이터 타입 HashMap과 유사함
// Rest Api 방식은 클라이언트의 종류에 상관없이 데이터 통신이 가능하게 해줌

@RestController
public class RestBoardApiController {
  @Autowired
  private BoardService boardService;

  @RequestMapping(value = "/api/board", method = RequestMethod.GET)
//  기존 방식과 @RestController 방식의 차이점 : 모델앤뷰가 아니라 List<BoardDto> 타입으로 보냄
  public List<BoardDto> openBoardList() throws Exception {
    return boardService.selectBoardList();
  }

  @RequestMapping(value = "/api/board/write", method = RequestMethod.POST)
  public void insertBoard(@RequestBody BoardDto board) throws Exception {
    boardService.insertBoard(board);
  }

  @RequestMapping(value = "/api/board/{idx}", method = RequestMethod.GET)
  public BoardDto openBoardDetail(@PathVariable("idx") int idx) throws Exception {
    return boardService.selectBoardDetail(idx);
  }

//  UPDATE
  @RequestMapping(value = "/api/board/update/{idx}", method = RequestMethod.PUT)
  public String updateBoard(@RequestBody BoardDto board) throws Exception {
    boardService.updateBoard(board);
    return "redirect:/board";
  }

//  DELETE
  @RequestMapping(value = "/api/board/delete/{idx}", method = RequestMethod.DELETE)
  public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
    boardService.deleteBoard(idx);
    return "redirect:/board";
  }
}
