package com.stopError.MyBoard.mapper;

import com.stopError.MyBoard.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountMapper {
    Account getAccount(String id);
    void uploadAccount(Account account);
    @Transactional
    void updateAccount(Account account);
    @Transactional
    void deleteAccount(String id);

    Account loginAccount(@Param("id") String id, @Param("pw") String pw);
}
