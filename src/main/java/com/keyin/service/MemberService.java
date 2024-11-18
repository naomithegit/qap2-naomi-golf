package com.keyin.service;

import com.keyin.model.Member;
import com.keyin.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member addMember(Member member) {
        return repository.save(member);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public List<Member> searchByName(String name) {
        return repository.findByNameContaining(name);
    }
}
