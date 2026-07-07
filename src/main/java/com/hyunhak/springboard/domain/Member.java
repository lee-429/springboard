package com.hyunhak.springboard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;         // 회원 고유 번호(PK)
    private String loginId;  // 로그인 아이디
    private String password; // 로그인 비밀번호
    private String username; // 사용자 닉네임

    public Member() {}

    public Member(String loginId, String password, String username) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
    }
}
