package com.edb.demo.member.mapper;

import com.edb.demo.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Member Mapper
 *
 * @since	2022-06-29
 * @author	ywkim
 */
@Mapper
public interface MemberMapper {

    int create(Member member);
    Member read(String id);
    List<Member> list(Member member);
    int update(Member member);
    int delete(String id);

}