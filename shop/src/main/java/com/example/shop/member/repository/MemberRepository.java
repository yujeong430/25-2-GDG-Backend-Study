package com.example.shop.member.repository;

import com.example.shop.member.entity.Member;

import java.util.List;

public interface MemberRepository {
    Member findById(Long id);
    List<Member> findAll();
    Member findByLoginId(String loginId);
    void save(Member member);
    void deleteById(Long id);
}
