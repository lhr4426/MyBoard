package com.stopError.MyBoard.service;


import com.stopError.MyBoard.domain.Account;
import com.stopError.MyBoard.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final AccountMapper accountMapper;

    public Account getAccount(String id) {
        return accountMapper.getAccount(id);
    }

    public void uploadAccount(Account account){
        accountMapper.uploadAccount(account);
    }

    public void updateAccount(Account account){
        accountMapper.updateAccount(account);
    }

    public void deleteAccount(String id){
        accountMapper.deleteAccount(id);
    }

    public Account loginAccount(String id, String pw){
        return accountMapper.loginAccount(id, pw);
    }
}
