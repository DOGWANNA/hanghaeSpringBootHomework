package com.aprata.hanghaespringboothomework.dto;

import com.aprata.hanghaespringboothomework.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CrudResponseDto {
    private String username;
    private String password;
    private String title;
    private String contents;


    public CrudResponseDto entityToDto(Member member){
        return new CrudResponseDto(
                this.username = member.getUsername(),
                this.password = member.getPassword(),
                this.title = member.getTitle(),
                this.contents = member.getContents()
        );
    }
}
