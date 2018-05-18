package com.dongvv2.daoimp;

import com.dongvv2.dao.DatHangDao;
import com.dongvv2.persistence.data.BillDetailEntity;
import com.dongvv2.persistence.data.BillEntity;
import com.dongvv2.persistence.data.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DatHangDaoImp implements DatHangDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public int addCustomer(CustomerEntity customerEntity) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(customerEntity);
        if(id > 0) {
            return id;
        } else {
            return 0;
        }
    }

    @Override
    public int addBillEntity(BillEntity billEntity) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(billEntity);
        if(id > 0) {
            return id;
        } else {
            return 0;
        }
    }

    @Override
    public int addBillDetailEntity(BillDetailEntity billDetailEntity) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(billDetailEntity);
        if(id > 0) {
            return id;
        } else {
            return 0;
        }
    }

}
