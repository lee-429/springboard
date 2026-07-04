package com.hyunhak.springboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity // 이 클래스가 DB의 테이블과 매핑되는 엔티티임을 의미
@Getter
@Setter
public class BoardEntity {

    @Id // 기본 키(pk) 지정
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT를 사용하여 id를 자동 증가
    private Long id;

    private String title;

    private String content;

    private String writer;
}
