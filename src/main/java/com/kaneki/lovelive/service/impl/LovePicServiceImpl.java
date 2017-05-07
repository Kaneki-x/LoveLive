package com.kaneki.lovelive.service.impl;

import com.kaneki.lovelive.db.dao.LovePicDao;
import com.kaneki.lovelive.model.entity.LovePic;
import com.kaneki.lovelive.service.LovePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/7
 * @email yueqian@mogujie.com
 */
@Service
public class LovePicServiceImpl implements LovePicService {

    @Autowired
    private LovePicDao lovePicDao;

    public LovePic addNewPic(LovePic lovePic) {
        return lovePicDao.insert(lovePic);
    }
}
