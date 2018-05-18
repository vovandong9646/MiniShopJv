package com.dongvv2.daoimp;

import com.dongvv2.dao.DanhMucDao;
import com.dongvv2.persistence.data.TypeProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDaoImp implements DanhMucDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<TypeProductEntity> getListDanhMuc() {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder("from TypeProductEntity");
        List<TypeProductEntity> listDanhMuc = session.createQuery(sql.toString()).getResultList();
        return listDanhMuc;
    }
}
