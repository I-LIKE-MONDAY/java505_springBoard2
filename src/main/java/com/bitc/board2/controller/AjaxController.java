package com.bitc.board2.controller;

import com.bitc.board2.dto.AreaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {

  @RequestMapping(value = "/ajax/nonAjaxCalView", method = RequestMethod.GET)
  public String nonAjaxCalView() throws Exception {
    return "ajax/nonAjaxCalView";
  }

  @RequestMapping(value = "/ajax/nonAjaxCalResult", method = RequestMethod.GET)
  public ModelAndView nonAjaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
    ModelAndView mv = new ModelAndView("ajax/nonAjaxCalResult");

    int result = num1 + num2;
    mv.addObject("result", result);

    return mv;
  }

  //  Ajax 이용
  @RequestMapping(value = "ajax/ajaxCalView", method = RequestMethod.GET)
  public String ajaxCalView() throws Exception {
    return "ajax/ajaxCalView";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/ajaxCalResult", method = RequestMethod.POST)
  public Object ajaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
//    int result = num1 + num2;

    Map<String, String> result = new HashMap<>();
    result.put("result", "success");
    result.put("value", String.valueOf(num1 + num2));

    return result;
  }

  //  단순 화면 구현
  @RequestMapping(value = "ajax/selectBox", method = RequestMethod.GET)
  public String selectBox() throws Exception {
    return "ajax/selectBox";
  }

  //  Ajax 로 접속해서 데이터 받아오는 부분
  @ResponseBody
  @RequestMapping(value = "ajax/selectBox1", method = RequestMethod.POST)
  public Object boxSelected(AreaDto area) throws Exception {
    List<AreaDto> areaList = new ArrayList<>();
// 해당 내용은 서비스 영역에서 만들어주는게 좋지만 이번에만 컨트롤러에 작성함....
    if (area.getAreaName().equals("서울")) {
      AreaDto se1 = new AreaDto();
      AreaDto se2 = new AreaDto();
      AreaDto se3 = new AreaDto();
      AreaDto se4 = new AreaDto();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    } else if (area.getAreaName().equals("대전")) {
      AreaDto dj1 = new AreaDto();
      AreaDto dj2 = new AreaDto();
      AreaDto dj3 = new AreaDto();
      AreaDto dj4 = new AreaDto();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    } else if (area.getAreaName().equals("대구")) {
      AreaDto dg1 = new AreaDto();
      AreaDto dg2 = new AreaDto();
      AreaDto dg3 = new AreaDto();
      AreaDto dg4 = new AreaDto();

      dg1.setAreaName("달서구");
      dg2.setAreaName("달서군");
      dg3.setAreaName("수성구");
      dg4.setAreaName("중구(대구)");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    } else if (area.getAreaName().equals("부산")) {
      AreaDto ps1 = new AreaDto();
      AreaDto ps2 = new AreaDto();
      AreaDto ps3 = new AreaDto();
      AreaDto ps4 = new AreaDto();

      ps1.setAreaName("부산진구");
      ps2.setAreaName("해운대구");
      ps3.setAreaName("동래구");
      ps4.setAreaName("연도구");

      areaList.add(ps1);
      areaList.add(ps2);
      areaList.add(ps3);
      areaList.add(ps4);
    }

    return areaList;
  }


  //  Ajax 로 접속해서 데이터 받아오는 부분
  @ResponseBody
  @RequestMapping(value = "ajax/selectBox2", method = RequestMethod.POST)
  public Object boxSelected2(AreaDto area2) throws Exception {
    List<AreaDto> areaList2 = new ArrayList<>();
// 해당 내용은 서비스 영역에서 만들어주는게 좋지만 이번에만 컨트롤러에 작성함....
    if (area2.getAreaName().equals("강북구")) {
      AreaDto gb1 = new AreaDto();
      AreaDto gb2 = new AreaDto();

      gb1.setAreaName("강북구 동1");
      gb2.setAreaName("강북구 동2");

      areaList2.add(gb1);
      areaList2.add(gb2);
    } else if (area2.getAreaName().equals("강남구")) {
      AreaDto gn1 = new AreaDto();
      AreaDto gn2 = new AreaDto();

      gn1.setAreaName("강남구 동1");
      gn2.setAreaName("강남구 동2");


      areaList2.add(gn1);
      areaList2.add(gn2);
    } else if (area2.getAreaName().equals("강서구")) {
      AreaDto gs1 = new AreaDto();
      AreaDto gs2 = new AreaDto();

      gs1.setAreaName("강서구 동1");
      gs2.setAreaName("강서구 동2");


      areaList2.add(gs1);
      areaList2.add(gs2);
    } else if (area2.getAreaName().equals("강동구")) {
      AreaDto gd1 = new AreaDto();
      AreaDto gd2 = new AreaDto();

      gd1.setAreaName("강동구 동1");
      gd2.setAreaName("강동구 동2");

      areaList2.add(gd1);
      areaList2.add(gd2);
    } else if (area2.getAreaName().equals("동구")) {
      AreaDto d1 = new AreaDto();
      AreaDto d2 = new AreaDto();

      d1.setAreaName("동구 동1");
      d2.setAreaName("동구 동2");

      areaList2.add(d1);
      areaList2.add(d2);
    } else if (area2.getAreaName().equals("중구")) {
      AreaDto j1 = new AreaDto();
      AreaDto j2 = new AreaDto();

      j1.setAreaName("중구 동1");
      j2.setAreaName("중구 동2");

      areaList2.add(j1);
      areaList2.add(j2);
    } else if (area2.getAreaName().equals("서구")) {
      AreaDto s1 = new AreaDto();
      AreaDto s2 = new AreaDto();

      s1.setAreaName("서구 동1");
      s2.setAreaName("서구 동2");

      areaList2.add(s1);
      areaList2.add(s2);
    } else if (area2.getAreaName().equals("유성구")) {
      AreaDto us1 = new AreaDto();
      AreaDto us2 = new AreaDto();

      us1.setAreaName("유성구 동1");
      us2.setAreaName("유성구 동2");

      areaList2.add(us1);
      areaList2.add(us2);
    } else if (area2.getAreaName().equals("달서구")) {
      AreaDto ds1 = new AreaDto();
      AreaDto ds2 = new AreaDto();

      ds1.setAreaName("달서구 동1");
      ds2.setAreaName("달서구 동2");

      areaList2.add(ds1);
      areaList2.add(ds2);
    } else if (area2.getAreaName().equals("달서군")) {
      AreaDto dsgn1 = new AreaDto();
      AreaDto dsgn2 = new AreaDto();

      dsgn1.setAreaName("달서군 동1");
      dsgn2.setAreaName("달서군 동2");

      areaList2.add(dsgn1);
      areaList2.add(dsgn2);
    } else if (area2.getAreaName().equals("수성구")) {
      AreaDto ss1 = new AreaDto();
      AreaDto ss2 = new AreaDto();

      ss1.setAreaName("수성구 동1");
      ss2.setAreaName("수성구 동2");

      areaList2.add(ss1);
      areaList2.add(ss2);
    } else if (area2.getAreaName().equals("중구(대구)")) {
      AreaDto jd1 = new AreaDto();
      AreaDto jd2 = new AreaDto();

      jd1.setAreaName("중구(대구) 동1");
      jd2.setAreaName("중구(대구) 동2");

      areaList2.add(jd1);
      areaList2.add(jd2);
    } else if (area2.getAreaName().equals("부산진구")) {
      AreaDto pj1 = new AreaDto();
      AreaDto pj2 = new AreaDto();

      pj1.setAreaName("부산진구 동1");
      pj2.setAreaName("부산진구 동2");

      areaList2.add(pj1);
      areaList2.add(pj2);
    } else if (area2.getAreaName().equals("해운대구")) {
      AreaDto h1 = new AreaDto();
      AreaDto h2 = new AreaDto();

      h1.setAreaName("해운대구 동1");
      h2.setAreaName("해운대구 동2");

      areaList2.add(h1);
      areaList2.add(h2);
    } else if (area2.getAreaName().equals("동래구")) {
      AreaDto dnr1 = new AreaDto();
      AreaDto dnr2 = new AreaDto();

      dnr1.setAreaName("동래구 동1");
      dnr2.setAreaName("동래구 동2");

      areaList2.add(dnr1);
      areaList2.add(dnr2);
    } else if (area2.getAreaName().equals("연도구")) {
      AreaDto ynd1 = new AreaDto();
      AreaDto ynd2 = new AreaDto();

      ynd1.setAreaName("연도구 동1");
      ynd2.setAreaName("연도구 동2");

      areaList2.add(ynd1);
      areaList2.add(ynd2);
    }

    return areaList2;
  }


  // 선생님 답
  /*@ResponseBody
  @RequestMapping(value = "ajax/selectBox2", method = RequestMethod.POST)
  public Object boxSelected2(@RequestParam("area") String area) {
    List<AreaDto> areaList = new ArrayList<>();

    AreaDto ad1 = new AreaDto();
    AreaDto ad2 = new AreaDto();

    switch (area) {
      case "강서구"
        ad1.setAreaName("강서1동");
        ad2.setAreaName("강서2동");
    } // . . .

    areaList.add(ad1);
    areaList.add(ad2);

    return areaList;
  }*/
}
