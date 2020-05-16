package com.example.demo.mapper;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * AccountMapper继承基类
 */
@Repository
public interface AccountMapper extends MyBatisBaseDao<Account,Integer,AccountExample> {

}
