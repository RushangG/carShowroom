package com.carInfo.carShowroom.Controller;


import com.carInfo.carShowroom.Entity.Member;

import com.carInfo.carShowroom.Service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAllMembers();
        if (!members.isEmpty()) {
            return new ResponseEntity<>(members, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
        
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        memberService.saveMember(member);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }
    
    @PostMapping("/manager")
    public Member createMemberBYMANAGER(@RequestBody Member member) {
        memberService.saveMemberByManager(member);
        
        return member;
//        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Member> getMemberById(@PathVariable String userId) {
        Member member = memberService.findMemberById(userId);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Member> updateMember(@PathVariable String userId) {
        Member member = memberService.findMemberById(userId);
        if (member != null) {
           
            memberService.updateMember(member);      
            
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String userId) {
        Member existingMember = memberService.findMemberById(userId);
        if (existingMember != null) {
            memberService.deleteMember(existingMember);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   
  
    
    
}

