package com.edb.demo.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberAuth {
    private int userIdx;
    private String JWT;

    @Builder
    public MemberAuth(int userIdx, String JWT) {
        this.userIdx = userIdx;
        this.JWT = JWT;
    }
}
