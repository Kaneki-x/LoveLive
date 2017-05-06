package com.kaneki.lovelive.db.dao;

import com.kaneki.lovelive.db.base.BaseDao;
import com.kaneki.lovelive.model.entity.LoveSet;
import com.kaneki.lovelive.model.entity.LoveSister;
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
 * @Desctription 小姐姐dao
 * @date 2017-5-06
 * @email yueqian@mogujie.com
 */
@Repository
public class LoveSisterDao extends BaseDao<LoveSet> {

    public LoveSister findSisterById(final int sid) {
        return hibernateTemplate.execute(new HibernateCallback<LoveSister>() {
            public LoveSister doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria c = session.createCriteria(LoveSister.class);
                c.add(Restrictions.eq("id", sid));//eq是等于，gt是大于，lt是小于,or是或
                return  c.list().size() == 0 ? null : (LoveSister) c.list().get(0);
            }
        });
    }
}
