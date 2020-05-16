package com.example.demo.service.impl;

import com.example.demo.common.CustomException;
import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccountByNameAndPwd(String loginName, String password) {
        return accountDao.getAccountByNameAndPwd(loginName, password);
    }

    @Override
    public PageInfo<Account> getAccountByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Account> accountList = accountDao.getAccountList();
        PageInfo<Account> accountPageInfo = new PageInfo<>(accountList,5);
        return accountPageInfo;
    }

    @Override
    public void deleteById(int id) {
        accountDao.deleteById(id);
    }

    @Override
    public void register(Account account) {
        try {
            accountDao.insert(account);
        } catch (Exception e) {
            throw new CustomException("注册失败",e);
        }
    }

    @Override
    public PageInfo<Account> getAccountListByName(int pageNum, int pageSize, String accountName) {
        PageHelper.startPage(pageNum, pageSize);
        List<Account> accountList = accountDao.getAccountListByName(accountName);
        PageInfo<Account> accountPageInfo = new PageInfo<>(accountList,5);
        return accountPageInfo;
    }
}
