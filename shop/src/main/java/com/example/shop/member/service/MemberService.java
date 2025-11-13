package com.example.shop.member.service;

import com.example.shop.member.entity.Member;
import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;

import java.util.List;

public interface MemberService {
    Long createMember(MemberCreateRequest memberCreateRequest);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    void updateMember(Long id, MemberUpdateRequest memberUpdateRequest);
    void deleteMember(Long id);
}
