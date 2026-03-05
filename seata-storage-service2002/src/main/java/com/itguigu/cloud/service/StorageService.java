package com.itguigu.cloud.service;

import com.itguigu.cloud.entities.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2026-03-04 15:03:03
*/
public interface StorageService extends IService<Storage> {

    Boolean decrease(Long productId, Integer count);

}
