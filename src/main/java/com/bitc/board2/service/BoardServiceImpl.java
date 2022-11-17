package com.bitc.board2.service;

import com.bitc.board2.dto.BoardDto;
import com.bitc.board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardMapper boardMapper;
  @Override
//    데이터베이스를 연결해야 함 -> mapper사용
  public List<BoardDto> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }
  @Override
  public void insertBoard(BoardDto board) throws Exception{
    boardMapper.insertBoard(board); //boardmapper에 만들어준다.
  }

  @Override
//    파일 한 개씩만 받으면 되니까
  public BoardDto selectBoardDetail(int idx) throws Exception {
    BoardDto board = boardMapper.selectBoardDetail(idx);
    return board;
  }

  @Override
  public void updateBoard(BoardDto board) throws Exception {
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int idx) throws Exception {
    boardMapper.deleteBoard(idx);
  }
}















