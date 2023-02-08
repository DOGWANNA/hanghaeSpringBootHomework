package com.aprata.hanghaespringboothomework.controller;

import com.aprata.hanghaespringboothomework.dto.CrudPasswordDto;
import com.aprata.hanghaespringboothomework.dto.CrudRequestBody;
import com.aprata.hanghaespringboothomework.dto.CrudRequestDto;
import com.aprata.hanghaespringboothomework.dto.CrudResponseDto;
import com.aprata.hanghaespringboothomework.entity.Member;
import com.aprata.hanghaespringboothomework.service.CrudService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrudController {

    private final CrudService crudService; // 서비스와 연결
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index"); // 반환값으로 String을 주면 templates에 있는 String값에 해당하는 뷰를 반환
    }

    @PostMapping("/crud")//POST 방식이므로 Body가 존재.
    public CrudResponseDto createCrud(@RequestBody CrudRequestDto requestDto){
        CrudResponseDto responseDto = crudService.createCrud(requestDto);
        return responseDto;
        // 클라이언트에서 받아온 데이터들을 사용하기 위하여 Dto 사용
    }

    @GetMapping("/crud") // POST는 요청 url에 하위 엔티티를 생성 ,PUT은 있는 엔티티에 값을 갱신한다.
    public List<Member> getCrud(){
        return crudService.getCrud();
    }

//    @PutMapping("/crud/{id}")
//    public String updateCrud(@PathVariable Long id, @RequestBody ObjectNode objectNode) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        CrudRequestDto requestDto = mapper.treeToValue(objectNode.get("requestDto"),CrudRequestDto.class);
//        CrudPasswordDto passwordDto = mapper.treeToValue(objectNode.get("passwordDto"),CrudPasswordDto.class);
//
//        return crudService.updateCrud(id, requestDto, passwordDto);
//    }
    @PutMapping("/crud/{id}")
    public String updateCrud(@PathVariable Long id, @RequestBody CrudRequestBody requestBody){
        return crudService.updateCrud(id, requestBody.getCrudRequestDto(), requestBody.getCrudPasswordDto());
    }
    @DeleteMapping("/crud/{id}")
    public String delete(@PathVariable Long id, @RequestBody CrudPasswordDto passwordDto){
        return crudService.deleteCrud(id, passwordDto);
    }
}

