package com.keyin.controller;

import com.keyin.model.Member;
import com.keyin.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return service.addMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }

    @GetMapping("/search")
    public List<Member> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }
}
