package com.aprata.hanghaespringboothomework.service;

import com.aprata.hanghaespringboothomework.dto.CrudPasswordDto;
import com.aprata.hanghaespringboothomework.dto.CrudRequestDto;
import com.aprata.hanghaespringboothomework.dto.CrudResponseDto;
import com.aprata.hanghaespringboothomework.entity.Member;
import com.aprata.hanghaespringboothomework.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudService {
    private final CrudRepository crudRepository; // 레포지토리 사용이 가능하도록 선언

    @Transactional
    public CrudResponseDto createCrud(CrudRequestDto requestDto) {
        Member member = new Member(requestDto);
        crudRepository.save(member); // 자동으로 쿼리가 생성되며 데이터베이스에 연결

        return new CrudResponseDto().entityToDto(member); //Dto객체를 생성하면서 entity를 Dto로 변환하여 전달
    }

    @Transactional(readOnly = true)
    public List<Member> getCrud() {
        return crudRepository.findAllByOrderByCreatedAtDesc(); // 어노테이션 확인해야함.
    }

    public String updateCrud(Long id, CrudRequestDto requestDto, CrudPasswordDto passwordDto) {
        if(checkPassword(id,passwordDto)){
            Member member = crudRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 없습니다.")
            );
            member.update(requestDto);
            return id + "번 게시물 수정 성공";
        }else{
            return "비밀번호가 일치하지 않습니다.";
        }
    }

    public String deleteCrud(Long id, CrudPasswordDto passwordDto) {
            if(checkPassword(id,passwordDto)){
                crudRepository.deleteById(id);
                return id + "번 게시물 삭제 성공";
            }else{
                return "비밀번호가 일치하지 않습니다.";
            }
    }

    public Boolean checkPassword(Long id, CrudPasswordDto crudPasswordDto){
        Member member = crudRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        if(member.getPassword().equals(crudPasswordDto.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}
