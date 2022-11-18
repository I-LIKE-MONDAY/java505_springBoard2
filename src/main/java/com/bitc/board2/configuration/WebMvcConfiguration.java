package com.bitc.board2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  @Value("${resources.images.location}")
  private String imagesLocation;

  @Value("${resources.image.location1}")
  private String imagesLocation1;

  @Value("${resources.image.location2}")
  private String imagesLocation2;
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    addResourceHandler : 스프링 내에서 사용할 폴더명 설정, 여러 개의 폴더명을 설정하고자 할 경우,
//                         addResourceHandler()를 여러 개 사용하면 됨
//    addResourceLocations : 실제 시스템 내의 폴더 위치 설정, 스프링 내에서는 1개의 폴더로 설정하고
//                           실제 폴더는 여러개의 폴더를 등록하고자 할 경우 addResourceLocations()에 여러개의 경로를 입력함
//              주의사항 : 경로의 마지막에 / 를 반드시 붙여야 함.
//    file:///경로  <- 시스템이 윈도우일 경우
//    file:경로   <- linux, mac 시스템일 경우





    String imgPath = "file:///" + imagesLocation;
    String imgPath1 = "file:///" + imagesLocation1;
    String imgPath2 = "file:///" + imagesLocation2;

    registry.addResourceHandler("/images/**")
        .addResourceLocations("file:///C:/images/"); // .addResourceLocations ~~ 로 계속 설정파일 위치 등록 가능

    registry.addResourceHandler("/image/**")
        .addResourceLocations(imgPath1, imgPath2);
  }


}
