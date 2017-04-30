package com.kaneki.lovelive.db.base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author yueqian
 * @Desctription
 * @date 16/6/3
 * @email yueqian@mogujie.com
 */
@Repository
public abstract class BaseDao<T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    protected void sqlExecute(final String sql) {
        hibernateTemplate.execute(new HibernateCallback<Void>() {
            public Void doInHibernate(Session session) throws HibernateException, SQLException {
                session.createSQLQuery(sql).executeUpdate();
                session.flush(); //清理缓存，执行批量插入
                session.clear(); //清空缓存中的
                return null;
            }
        });
    }

    public T insert(T t) {
        hibernateTemplate.save(t);
        return t;
    }

    public void update(T t) {
        hibernateTemplate.update(t);
    }

    public void delete(T t) {
        hibernateTemplate.delete(t);
    }

    public void saveOrUpdate(T t) {
        hibernateTemplate.saveOrUpdate(t);
    }
}
