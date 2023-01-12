package com.stopError.MyBoard;

import com.stopError.MyBoard.domain.Account;
import com.stopError.MyBoard.mapper.AccountMapper;
import com.stopError.MyBoard.service.AccountService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AccountTest {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    @Test
    void 멤버찾기() {
        Account findAccount = accountService.getAccount("1234");
        Assertions.assertThat(findAccount).isEqualTo(null);
    }
}
