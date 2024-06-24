package com.carInfo.carShowroom.Service;




import com.carInfo.carShowroom.Entity.Member;
import java.util.List;

public interface MemberService {
    void saveMember(Member member);
    Member findMemberById(String userId);
    void updateMember(Member member);
    void deleteMember(Member member);
    List<Member> findAllMembers();
	void saveMemberByManager(Member member);
}