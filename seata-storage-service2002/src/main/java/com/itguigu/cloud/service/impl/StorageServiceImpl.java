package com.itguigu.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.cloud.entities.Storage;
import com.itguigu.cloud.service.StorageService;
import com.itguigu.cloud.mapper.StorageMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2026-03-04 15:03:03
*/
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
    implements StorageService{

    @Override
    public Boolean decrease(Long productId, Integer count) {


        Storage storage = baseMapper.selectById(productId);
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);

        baseMapper.updateById(storage);

        return true;
    }
}




