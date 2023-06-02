package com.edb.demo.member.mapper;

import com.edb.demo.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * Member Mapper
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Mapper
public interface MemberMapper {

    int create(Member member);
    int getLastInsertedId();
    Member read(int id);
    Member findByEmail(String email);
    List<Member> list(Member member);
    int update(Member member);
    int delete(String id);

}
