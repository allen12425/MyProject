package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Menu;
import org.springframework.stereotype.Repository;

/**
 * MenuMapper继承基类
 * baseMapper里是mybatisplus 封装的接口，里面提供了简单sql功能，但是用起来很麻烦，不推荐
 * 因此还是在xml文件里去写sql
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
}
