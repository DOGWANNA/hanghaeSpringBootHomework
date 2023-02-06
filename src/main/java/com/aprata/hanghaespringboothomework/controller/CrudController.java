package com.aprata.hanghaespringboothomework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequiredArgsConstructor
public class CrudController {

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index"); // 반환값으로 String을 주면 templates에 있는 String값에 해당하는 뷰를 반환
    }
}
