package com.bitc.board2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OutsideController {

//  단순 화면 생성
  @RequestMapping(value = "/outside/imgLoad", method = RequestMethod.GET)
  public String imgLoad() throws Exception {
    return "outside/imgLoad";
  }
}
