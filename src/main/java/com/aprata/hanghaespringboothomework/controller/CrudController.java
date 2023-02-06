package com.aprata.hanghaespringboothomework.controller;

import com.aprata.hanghaespringboothomework.dto.CrudRequestDto;
import com.aprata.hanghaespringboothomework.entity.Member;
import com.aprata.hanghaespringboothomework.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequiredArgsConstructor
public class CrudController {

    private final CrudService crudService; // 서비스와 연결
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index"); // 반환값으로 String을 주면 templates에 있는 String값에 해당하는 뷰를 반환
    }

    @PostMapping("/insert")//POST 방식이므로 Body가 존재.
    public String createMemo(@RequestBody CrudRequestDto requestDto){
        crudService.createCrud(requestDto);
//        return crudService.createCrud(requestDto);
        return "완료";
        // 클라이언트에서 받아온 데이터들을 사용하기 위하여 Dto 사용
    }
}
