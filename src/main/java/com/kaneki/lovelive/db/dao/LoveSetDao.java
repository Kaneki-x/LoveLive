package com.kaneki.lovelive.db.dao;

import com.kaneki.lovelive.db.base.BaseDao;
import com.kaneki.lovelive.model.entity.LoveSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoveSetDao extends BaseDao<LoveSet> {

    @Autowired
    private LovePicDao lovePicDao;

    public List<LoveSet> findSetListBySisId(final int sid, final long create_time, final int size) {
        return hibernateTemplate.execute(new HibernateCallback<List<LoveSet>>() {
            public List<LoveSet> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria c = session.createCriteria(LoveSet.class);
                c.add(Restrictions.eq("ls_id", sid));//eq是等于，gt是大于，lt是小于,or是或
                c.add(Restrictions.lt("create_time", create_time));
                c.setMaxResults(size);
                return c.list();
            }
        });
    }
}
