package com.carInfo.carShowroom.Service;




import com.carInfo.carShowroom.Dao.MemberDAO;
import com.carInfo.carShowroom.Dao.RoleDAO;
import com.carInfo.carShowroom.Entity.Member;
import com.carInfo.carShowroom.Entity.Role;
import com.carInfo.carShowroom.Entity.RoleId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private RoleDAO roleDao;
    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO, RoleDAO roleDao) {
		super();
		this.memberDAO = memberDAO;
		this.roleDao = roleDao;
	}

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}



    @Override
    @Transactional
    public void saveMember(Member member) {
    	String password=member.getPassword();
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       
        // Encrypt the password
        String encryptedPassword ="{bcrypt}"+encoder.encode(password);
        member.setPassword(encryptedPassword);
        
        memberDAO.save(member);
        Role role=new Role();
        role.setMember(member);
        role.setRole("ROLE_CUSTOMER");
        roleDao.save(role);
    }

    @Override
    @Transactional
    public Member findMemberById(String userId) {
        return memberDAO.findById(userId);
    }
    
//    @Override
//    @Transactional
//    public void updateMember(Member member) {
//    
//                     = roleDao.findById(member.getUserId());
//    	 RoleId roleId = new RoleId();    	
//       
//    	roleId.setRole("ROLE_CUSTOMER");
//        roleId.setMember(member);
//        
//    	System.out.println("roleId");
//    	System.out.println(roleId.getMember().toString());
//    	System.out.println(roleId.getRole());
//    	
//    	Role role=roleDao.findById(roleId);
//        if (role != null) {
//            // Update the role to ROLE_EMPLOYEE
//            role.setRole("ROLE_EMPLOYEE");
//            roleDao.update(role);
//
//    }
        
        @Override
        @Transactional
        public void updateMember(Member member) {
        	 RoleId roleId = new RoleId();    	
           
        	roleId.setRole("ROLE_CUSTOMER");
            roleId.setMember(member);
            
        	Role role=roleDao.findById(roleId);;           
            role.setRole("ROLE_EMPLOYEE");
            roleDao.update(role);

        }


    @Override
    @Transactional
    public void deleteMember(Member member) {
        memberDAO.delete(member);
    }

    @Override
    @Transactional
    public List<Member> findAllMembers() {
        return memberDAO.findAll();
    }

	@Override
	 @Transactional
	public void saveMemberByManager(Member member) {
		// TODO Auto-generated method stub
		String password=member.getPassword();
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       
        // Encrypt the password
        String encryptedPassword ="{bcrypt}"+encoder.encode(password);
        member.setPassword(encryptedPassword);
//        
        memberDAO.save(member);
        Role role=new Role();
        role.setMember(member);
        role.setRole("ROLE_EMPLOYEE");
        roleDao.save(role);
	}
}