package com.bitc.board2.mapper;

import com.bitc.board2.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  public List<BoardDto> selectBoardList() throws Exception;

  public void insertBoard (BoardDto board) throws Exception; //xml로 간다.

  //    데이터베이스 연결
  public BoardDto selectBoardDetail(int idx) throws Exception;

  public void updateBoard(BoardDto board) throws Exception;

  public void deleteBoard(int idx) throws Exception;

}
