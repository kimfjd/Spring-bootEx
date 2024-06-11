package com.kh.totalEx.dto;

import com.kh.totalEx.entity.Member;
import com.kh.totalEx.repository.MemberRepository;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResDto {
    private String name;
    private String email;
    private String image;
    private LocalDateTime regDate;
    public static MemberResDto of(Member member){
        return MemberResDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .image(member.getIamge())
                .regDate(member.getRegDate())
                .build();
    }
}
