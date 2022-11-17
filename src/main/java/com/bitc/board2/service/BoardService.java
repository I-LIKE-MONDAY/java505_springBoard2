package com.bitc.board2.service;

import com.bitc.board2.dto.BoardDto;

import java.util.List;

public interface BoardService {
  //interface는 기본적으로 추상메서드, 정적멤버, (1.8이후) default 메서드를 가질 수 있다.
//    그냥 추상메서드를 떠올리면 된다.
  public List<BoardDto> selectBoardList() throws Exception; //하나가 아니니까 list 형식으로 가져옴

  public void insertBoard(BoardDto board) throws Exception; //구현체 있어야 하니까 impl로 간다.

  public BoardDto selectBoardDetail(int idx) throws Exception; // html에서 왔다. impl로간다.

  public void updateBoard(BoardDto board) throws Exception; // 인터페이스에서는 public 써줘야함, 반환값이 없으니 void

  public void deleteBoard(int idx) throws Exception;
}
