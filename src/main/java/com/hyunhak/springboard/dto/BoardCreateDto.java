package com.hyunhak.springboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 입력(create)을 위한 데이터를 담는 DTO
public class BoardCreateDto {

    private String title;
    private String content;
    private String writer;
}
