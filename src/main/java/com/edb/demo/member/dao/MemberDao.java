package com.edb.demo.member.dao;

import com.edb.demo.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.Map;

@Repository
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //회원가입
    public int createMember(Member member) {
        String createMemberQuery = "INSERT INTO MEMBER (email, password, name, phone, gender, age, nationality) VALUES (?,?,?,?,?,?,?)";
        Object[] createMemberParams = new Object[]{
                member.getEmail(), member.getPassword(), member.getName(), member.getPhone(), member.getGender(), member.getAge(), member.getNationality()
        };
        this.jdbcTemplate.update(createMemberQuery, createMemberParams);

        String lastInserIdQuery = "select last_insert_id()";

        return this.jdbcTemplate.queryForObject(lastInserIdQuery, int.class);
    }

    //로그인
    public Map<String, Object> getIdAndPasswordByEmail(String email) {
        String getPasswordByEmailQuery = "SELECT id, password FROM MEMBER WHERE email = ?";
        Object[] getPasswordByEmailParams = new Object[]{email};

        Map<String,Object> result = jdbcTemplate.queryForMap(getPasswordByEmailQuery, getPasswordByEmailParams);
        return result;
    }
}
