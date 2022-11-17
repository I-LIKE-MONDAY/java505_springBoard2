package com.bitc.board2.dto;

import lombok.Data;

@Data
//데이터테이블에 있는 걸 그대로 넣어야 한다.
public class BoardDto {
  private int idx;
  private String title;
  private String contents;
  private String userId;
  private String pwd;
  private String createDt;
  private String updateDt;
  private int hitCnt;
}

















