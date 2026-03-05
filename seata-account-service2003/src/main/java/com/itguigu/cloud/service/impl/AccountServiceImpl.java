package com.itguigu.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.cloud.entities.Account;
import com.itguigu.cloud.resp.ResultData;
import com.itguigu.cloud.service.AccountService;
import com.itguigu.cloud.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
* @author admin
* @description 针对表【t_account】的数据库操作Service实现
* @createDate 2026-03-04 15:00:13
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{


    @Override
    public Boolean decrease(Long userId, Long money) {

        // 【模拟异常点】：如果是 1 号用户，故意抛出异常触发全线回滚
        if (userId == 2L) {
            throw new RuntimeException("账户余额不足，触发分布式事务回滚！");
        }

        Account account = baseMapper.selectById(userId);
        account.setUsed(account.getUsed() + count());
        account.setResidue(account.getResidue() - count());

        baseMapper.updateById(account);


        return true;
    }
}




