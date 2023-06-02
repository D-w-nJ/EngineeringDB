package com.edb.demo.member.exception;

import com.edb.demo.global.error.NotMatchException;

public class MemberNotMatchException extends NotMatchException {

    private static final String MESSAGE = "비밀번호가 틀렸습니다.";

    public MemberNotMatchException() {
        super(MESSAGE);
    }
}
