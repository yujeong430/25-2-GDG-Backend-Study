package com.example.shop.member.dto;


// password, phoneNumber, address

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberUpdateRequest {

    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하입니다.")
    private String password;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호 형식은 010-xxxx-xxxx입니다.")
    private String phoneNumber;

    @Size(min = 1, max = 255, message = "주소는 1자 이상 255자 이하입니다.")
    private String address;

    public MemberUpdateRequest(String password, String phoneNumber, String address) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
