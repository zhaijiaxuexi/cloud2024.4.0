package com.itguigu.cloud.service;

import com.itguigu.cloud.entities.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【t_account】的数据库操作Service
* @createDate 2026-03-04 15:00:13
*/
public interface AccountService extends IService<Account> {


    Boolean decrease(Long userId,Long money);

}
