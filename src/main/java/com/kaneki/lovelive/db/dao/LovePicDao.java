package com.kaneki.lovelive.db.dao;

import com.kaneki.lovelive.db.base.BaseDao;
import com.kaneki.lovelive.model.entity.LovePic;
import com.kaneki.lovelive.model.entity.LoveSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yueqian
 * @Desctription 管理员dao
 * @date 2016-5-16
 * @email yueqian@mogujie.com
 */
@Repository
public class LovePicDao extends BaseDao<LovePic> {

    public List<LovePic> findPicListBySetId(final int setId) {
        return hibernateTemplate.execute(new HibernateCallback<List<LovePic>>() {
            public List<LovePic> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria c = session.createCriteria(LovePic.class);
                c.add(Restrictions.eq("ls_set_id", setId));//eq是等于，gt是大于，lt是小于,or是或
                return c.list();
            }
        });
    }
}
