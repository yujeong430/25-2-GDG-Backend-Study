package com.example.shop.common.message;

public class ErrorMessage {

    // Member 관련 에러 메시지
    public static final String MEMBER_NOT_FOUND = "회원을 찾을 수 없습니다.";
    public static final String MEMBER_ALREADY_EXISTS = "이미 존재하는 로그인 아이디입니다.";

    // DTO
    public static final String LOGIN_ID_NOT_NULL = "로그인 아이디는 필수입니다.";
    public static final String LOGIN_ID_SIZE = "로그인 아이디는 4자 이상 20자 이하입니다.";

}
