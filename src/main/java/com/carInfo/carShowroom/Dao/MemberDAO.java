package com.carInfo.carShowroom.Dao;

import com.carInfo.carShowroom.Entity.Member;
import java.util.List;

public interface MemberDAO {
    void save(Member member);
    Member findById(String userId);
    void update(Member member);
    void delete(Member member);
    List<Member> findAll();
}

