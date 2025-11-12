package com.example.shop.member.repository;

import com.example.shop.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaMemberRepository implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 회원 id로 회원 조회
    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 조회
    @Override
    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    // 로그인 id로 회원 조회
    @Override
    public Member findByLoginId(String loginId) {
        List<Member> result = em.createQuery(
                        "SELECT m FROM Member m WHERE m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    // 회원 등록
    @Override
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 삭제
    @Override
    public void deleteById(Long id) {
        Member member = em.find(Member.class, id);
        em.remove(member);
    }
}
