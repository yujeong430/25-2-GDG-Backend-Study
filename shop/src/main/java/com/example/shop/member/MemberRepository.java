package com.example.shop.member;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository
 * 현재 구현: 메모리 저장소 (Map 사용)
 */
@Repository
public class MemberRepository {

    /**
     * 메모리 저장소
     * - HashMap: Key-Value 쌍으로 데이터를 저장
     * - Key: 회원 ID (Long), Value: 회원 객체 (Member)
     */
    private final Map<Long, Member> store = new HashMap<>();

    /**
     * ID 자동 생성기
     * - 회원이 추가될 때마다 1씩 증가
     */
    private long sequence = 0L;

    /**
     * 회원 저장
     *
     * @param member 저장할 회원 객체
     * @return 저장된 회원 객체 (ID가 할당된 상태)
     */
    public Member save(Member member) {
        // ID가 없으면 새로운 회원 (생성)
        if (member.getId() == null) {
            // 새로운 ID 생성 (1부터 시작)
            sequence++;
            member.setId(sequence);
        }
        // ID가 있으면 기존 회원 (수정)
        // Map에 저장 (같은 ID면 덮어씀)
        store.put(member.getId(), member);
        return member;
    }

    /**
     * ID로 회원 조회
     *
     * @param id 조회할 회원의 ID
     * @return Member - 회원이 있으면 Member 객체, 없으면 null 반환
     */
    public Member findById(Long id) {
        // Map에서 ID로 조회
        return store.get(id);
    }

    /**
     * 전체 회원 조회
     *
     * @return 모든 회원의 리스트
     */
    public List<Member> findAll() {
        // Map의 모든 값(Member 객체들)을 리스트로 변환하여 반환
        return new ArrayList<>(store.values());
    }

    /**
     * 로그인 아이디로 회원 조회
     *
     * @param loginId 조회할 로그인 아이디
     * @return member - 해당 로그인 아이디를 가진 회원, 없으면 null 반환
     */
    public Member findByLoginId(String loginId) {
        // Map의 모든 회원을 순회하며 로그인 아이디가 일치하는 회원을 찾는다
        for (Member member : store.values()) {
            if (member.getLoginId().equals(loginId)) {
                return member;  // 찾으면 즉시 반환
            }
        }
        return null;  // 못 찾으면 null 반환
    }

    /**
     * 회원 삭제
     *
     * @param id 삭제할 회원의 ID
     */
    public void deleteById(Long id) {
        // Map에서 해당 ID의 회원을 제거
        store.remove(id);
    }

    /**
     * 전체 회원 삭제 (테스트용)
     * - 데이터 초기화할 때 사용
     */
    public void deleteAll() {
        store.clear();
    }

    /**
     * 회원 수 조회 (테스트용)
     *
     * @return 저장된 회원의 수
     */
    public long count() {
        return store.size();
    }
}

