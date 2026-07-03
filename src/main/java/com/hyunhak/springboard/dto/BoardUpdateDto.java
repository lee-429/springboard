package com.hyunhak.springboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 수정(update)을 위한 데이터를 담는 DTO
public class BoardUpdateDto {

    private String title;
    private String writer;
    private String content;

}
