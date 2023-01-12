package com.stopError.MyBoard.controller;

import com.stopError.MyBoard.domain.Account;
import com.stopError.MyBoard.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account/")
public class AccountController {

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
    public String login(Model model, String id, String pw){
        if(accountService.loginAccount(id, pw) == null){
            return "/account/loginFailed";
        }
        else{
            model.addAttribute("LoginId", accountService.getAccount(id));
            return "account/loginSuccessful";
        }
    }


}
