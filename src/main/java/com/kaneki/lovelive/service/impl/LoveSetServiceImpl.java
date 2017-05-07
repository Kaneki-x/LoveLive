package com.kaneki.lovelive.service.impl;

import com.kaneki.lovelive.db.dao.LoveSetDao;
import com.kaneki.lovelive.model.entity.LovePic;
import com.kaneki.lovelive.model.entity.LoveSet;
import com.kaneki.lovelive.service.LovePicService;
import com.kaneki.lovelive.service.LoveSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/7
 * @email yueqian@mogujie.com
 */
@Service
public class LoveSetServiceImpl implements LoveSetService {

    @Autowired
    private LoveSetDao loveSetDao;

    public LoveSet addNewSet(LoveSet loveSet) {
        return loveSetDao.insert(loveSet);
    }
}
