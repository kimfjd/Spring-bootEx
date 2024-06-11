package com.kh.totalEx.entity;

import com.kh.totalEx.constant.Authority;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String pwd;
    @Column(unique = true)
    private String email;
    private String iamge;
    private LocalDateTime regDate;
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String pwd, String email, String image, Authority authority) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.iamge=image;
        this.authority = authority;
    }
}
