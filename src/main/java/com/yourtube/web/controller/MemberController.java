package com.yourtube.web.controller;

import com.yourtube.service.MemberService;
import com.yourtube.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class MemberController {
    private MemberService memberService;

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @GetMapping("/member/signup")
    public String signupForm(Model model){
        model.addAttribute("member", new MemberDto());

        return "member/signupForm";
    }

    @PostMapping("/member/signup")
    public String signup(MemberDto memberDto){
        memberService.signUp(memberDto);

        return ("redirect:/");
    }

    @GetMapping("/member/login")
    public String login(){
        return "member/loginForm";
    }
}
