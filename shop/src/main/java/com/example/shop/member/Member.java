package com.example.shop.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Member 도메인 클래스
 * - 온라인 쇼핑몰의 회원 정보를 담는 엔티티
 * - 아직 JPA를 배우지 않았으므로 순수 자바 클래스로 작성
 */
@Getter
@Setter
@NoArgsConstructor
public class Member {

    // 회원 고유 식별자
    private Long id;

    // 회원 아이디
    private String loginId;

    // 비밀번호
    private String password;

    // 전화번호
    private String phoneNumber;

    // 주소
    private String address;

    // 적립금
    private int point;

    /**
     * 회원 생성자 (id와 point는 자동 생성/초기화)
     */
    public Member(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.point = 0; // 신규 회원 적립금은 0으로 초기화
    }

    /**
     * 회원 정보 수정 메서드
     * - 비밀번호, 전화번호, 주소만 수정 가능
     * - loginId는 변경 불가
     */
    public void updateInfo(String password, String phoneNumber, String address) {
        if (password != null) {
            this.password = password;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
        if (address != null) {
            this.address = address;
        }
    }
}

