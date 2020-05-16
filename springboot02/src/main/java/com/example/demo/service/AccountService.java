package com.example.demo.service;

import com.example.demo.entity.Account;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AccountService {
    Account getAccountByNameAndPwd(String loginName,String password);
    PageInfo<Account> getAccountByPage(int pageNum,int pageSize);
    void deleteById(int id);
    void register(Account account);
    PageInfo<Account> getAccountListByName(int pageNum,int pageSize,String accountName);
}
