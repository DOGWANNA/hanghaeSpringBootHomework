package com.aprata.hanghaespringboothomework.service;

import com.aprata.hanghaespringboothomework.dto.CrudRequestDto;
import com.aprata.hanghaespringboothomework.entity.Member;
import com.aprata.hanghaespringboothomework.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CrudService {
    private final CrudRepository crudRepository; // 레포지토리 사용이 가능하도록 선언


    @Transactional
    public void createCrud(CrudRequestDto requestDto) {
        Member member = new Member(requestDto);
        crudRepository.save(member); // 자동으로 쿼리가 생성되며 데이터베이스에 연결
//        return member; //저장된 정보를 반환
    }
}
