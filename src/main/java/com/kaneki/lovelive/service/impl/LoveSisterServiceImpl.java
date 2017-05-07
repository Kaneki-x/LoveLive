package com.kaneki.lovelive.service.impl;

import com.kaneki.lovelive.db.dao.LoveSisterDao;
import com.kaneki.lovelive.model.entity.LovePic;
import com.kaneki.lovelive.model.entity.LoveSister;
import com.kaneki.lovelive.service.LovePicService;
import com.kaneki.lovelive.service.LoveSisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/7
 * @email yueqian@mogujie.com
 */
@Service
public class LoveSisterServiceImpl implements LoveSisterService {

    @Autowired
    private LoveSisterDao loveSisterDao;

    public LoveSister addNewSister(LoveSister loveSister) {
        return loveSisterDao.insert(loveSister);
    }
}
