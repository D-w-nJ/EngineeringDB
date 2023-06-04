package com.edb.demo.member.model;

import com.edb.demo.global.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Base Model
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Data
public class Member extends BaseModel {

    @ApiModelProperty(value = "이메일", example = "email@company.com")
    private String email;

    @ApiModelProperty(value = "비밀번호", example = "swMAE12#$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(value = "이름", example = "홍길동")
    private String name;

    @ApiModelProperty(value = "전화번호", example = "010-0000-0000")
    private String phone;

    @ApiModelProperty(value = "성별", example = "남")
    private String gender;

    @ApiModelProperty(value = "나이", example = "20")
    private int age;

    @ApiModelProperty(value = "국적", example = "USA")
    private String nationality;
}
