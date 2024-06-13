package com.kh.totalEx.controller;

import com.kh.totalEx.dto.MemberReqDto;
import com.kh.totalEx.dto.MemberResDto;
import com.kh.totalEx.dto.TokenDto;
import com.kh.totalEx.service.AuthService;
import com.kh.totalEx.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberReqDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
    @GetMapping("/list")
    public ResponseEntity<List<MemberResDto>> memberList() {
        List<MemberResDto> list = memberService.getMemberList();
        return ResponseEntity.ok(list);
    }
}
