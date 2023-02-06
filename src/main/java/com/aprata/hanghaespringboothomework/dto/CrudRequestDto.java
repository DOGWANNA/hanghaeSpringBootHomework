package com.aprata.hanghaespringboothomework.dto;

import lombok.Getter;

@Getter
public class CrudRequestDto {
    private String username;
    private String password;
    private String title;
    private String contents;
}
