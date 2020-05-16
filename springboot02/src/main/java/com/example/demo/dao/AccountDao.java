package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Account;

import java.util.List;

public interface AccountDao extends BaseMapper<Account> {
    Account getAccountByNameAndPwd(String loginName,String password);

    List<Account> getAccountList();

    List<Account> getAccountListByName(String accountName);

}
