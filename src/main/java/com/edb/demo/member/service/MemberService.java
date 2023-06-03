package com.edb.demo.member.service;

import com.edb.demo.member.dao.MemberDao;
import com.edb.demo.member.dto.request.MemberLogin;
import com.edb.demo.member.dto.response.MemberAuth;
import com.edb.demo.member.dto.response.MemberInfo;
import com.edb.demo.member.exception.MemberNotMatchException;
import com.edb.demo.member.model.Member;
import com.edb.demo.util.JwtService;
import com.edb.demo.util.Sha512Encryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edb.demo.member.mapper.MemberMapper;

import java.util.List;
import java.util.Map;

/**
 * Member Service
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberDao memberDao;
    private final JwtService jwtService;

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberDao memberDao, JwtService jwtService) {
        this.memberMapper = memberMapper;
        this.memberDao = memberDao;
        this.jwtService = jwtService;
    }

    public MemberAuth create(Member member) {

        Sha512Encryptor sha512 = new Sha512Encryptor();
        member.setPassword(sha512.encrypt(member.getPassword()));

        int userIdx = 0;

        try {
            userIdx = memberDao.createMember(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }
        String userJWT = jwtService.createJwt(userIdx);

        MemberAuth memberSignUp = new MemberAuth(userIdx,userJWT);
        return memberSignUp;
    }

    public Member read(int id) {
        Member member = null;

        try {
            member = memberMapper.read(id);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        return member;
    }

    public List<Member> list(Member member) {
        List<Member> list = null;

        try {
            list = memberMapper.list(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        return list;
    }

    public int update(Member member) {
        int updatedCount = 0;

        try {
            updatedCount = memberMapper.update(member);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        return updatedCount;
    }

    public int delete(String id) {
        int deletedCount = 0;

        try {
            deletedCount = memberMapper.delete(id);
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        return deletedCount;
    }

    public MemberAuth login(MemberLogin memberLogin) {

        Sha512Encryptor sha512 = new Sha512Encryptor();
        String inputPassword = sha512.encrypt(memberLogin.getPassword());

        Map<String,Object> memberInfo = memberDao.getIdAndPasswordByEmail(memberLogin.getEmail());
        String memberPassword = (String) memberInfo.get("password");
        String userJWT;

        if (memberPassword.equals(inputPassword)) {
            userJWT = jwtService.createJwt((int)memberInfo.get("id"));
        }else{
            throw new MemberNotMatchException();
        }

        return new MemberAuth((int)memberInfo.get("id"),userJWT);
    }

    public List<MemberInfo> getMembers() {
        return memberDao.getMembers();
    }
}
