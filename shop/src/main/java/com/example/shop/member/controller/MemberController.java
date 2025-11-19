package com.example.shop.member.controller;


import java.net.URI;
import java.util.List;

import com.example.shop.member.entity.Member;
import com.example.shop.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "회원 관리", description = "회원 CRUD API")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원 생성", description = "새로운 회원을 등록합니다.")
    @ApiResponse(responseCode = "400", description = "잘못된 요청 (유효성 검사 실패 또는 중복된 로그인 아이디)")
    public ResponseEntity<Void> createMember(@RequestBody @Valid MemberCreateRequest request) {
        Long memberId = memberService.createMember(request);
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        // Service 계층에서 회원 목록을 가져온다
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }


    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long memberId,
            @RequestBody @Valid MemberUpdateRequest request) {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build(); // 204 no content
    }



}
