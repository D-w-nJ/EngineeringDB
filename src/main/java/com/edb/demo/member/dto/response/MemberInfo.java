package com.edb.demo.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfo {
    private int id;
    private String email;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private String nationality;

    @Builder
    public MemberInfo(int id, String email, String name, String phone, String gender, int age, String nationality) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
    }
}
