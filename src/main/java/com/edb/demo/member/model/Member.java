package com.edb.demo.member.model;

import com.edb.demo.util.BaseModel;
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

    @ApiModelProperty(value = "사용자 아이디", example = "gdhong")
    private String id;

    @ApiModelProperty(value = "비밀번호", example = "swMAE12#$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(value = "이름", example = "홍길동")
    private String name;

    @ApiModelProperty(value = "이메일", example = "email@company.com")
    private String email;

    @ApiModelProperty(value = "전화번호", example = "010-0000-0000")
    private String phone;

}
