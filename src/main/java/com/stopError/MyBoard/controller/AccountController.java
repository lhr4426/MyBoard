package com.stopError.MyBoard.controller;

import com.stopError.MyBoard.domain.Account;
import com.stopError.MyBoard.mapper.AccountMapper;
import com.stopError.MyBoard.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    private AccountMapper mapper;

    private final AccountService accountService;

    @GetMapping("/home")
    public String AccountHome(){
        return "/account/home";
    }

    @GetMapping("/new")
    public String newAccountForm() {
        return "/account/new";
    }

    @PostMapping("/new")
    public String newAccount(Account account){
        accountService.uploadAccount(account);
        return "redirect:/account/home";
    }

    @GetMapping("/user")
    public String viewUser(Model model, @RequestParam("id")String id){

        if(accountService.getAccount(id) == null){
            return "/account/noAccount";
        }
        else {
            model.addAttribute("find", accountService.getAccount(id));
            return "/account/user";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "/account/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest httpServletRequest, Model model, String id, String pw){
        HttpSession session = httpServletRequest.getSession();
        if(accountService.loginAccount(id, pw) == null){
            session.setAttribute("LoginId", null);
            return "/account/loginFailed";
        }
        else{
            Account loginUser = accountService.loginAccount(id, pw);
            session.setAttribute("loginUser", loginUser);
            return "account/loginSuccessful";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
