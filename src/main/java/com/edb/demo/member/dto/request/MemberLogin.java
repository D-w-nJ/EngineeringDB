package com.edb.demo.member.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLogin {

    @ApiModelProperty(value = "이메일", example = "email@company.com")
    private String email;
    @ApiModelProperty(value = "비밀번호", example = "swMAE12#$")
    private String password;

    @Builder
    public MemberLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}