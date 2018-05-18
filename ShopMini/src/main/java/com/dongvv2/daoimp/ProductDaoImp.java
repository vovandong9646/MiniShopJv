package com.dongvv2.daoimp;

import com.dongvv2.dao.ProductDao;
import com.dongvv2.persistence.data.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDaoImp implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<ProductEntity> getListProduct(int position) {
        Session session = sessionFactory.getCurrentSession();
        List<ProductEntity> listProduct = new ArrayList<ProductEntity>();
        String sql = "from ProductEntity";
        Query query;
        if(position >= 0) {
            query = session.createQuery(sql.toString()).setFirstResult(position).setMaxResults(5);
        } else {
            query = session.createQuery(sql.toString());
        }
        listProduct = query.getResultList();
        return listProduct;
    }

    @Override
    @Transactional
    public List<ProductEntity> getListNewProduct() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductEntity where news = 1";
        List<ProductEntity> listNewProduct = session.createQuery(sql.toString()).setFirstResult(0).setMaxResults(4).getResultList();
        return listNewProduct;
    }

    @Override
    @Transactional
    public List<ProductEntity> getListSaleProduct() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductEntity where promotionPrice <> 0";
        List<ProductEntity> listSaleProduct = session.createQuery(sql.toString()).setFirstResult(0).setMaxResults(8).getResultList();
        return listSaleProduct;
    }

    @Override
    @Transactional
    public List<ProductEntity> getListProductByType(int idTypeProduct, int position, int quantity) {
        List<ProductEntity> listProductByType = new ArrayList<ProductEntity>();
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductEntity where typeProductEntity.id = :idTypeProduct order by id DESC";
        Query query = session.createQuery(sql.toString());
        query.setParameter("idTypeProduct", idTypeProduct);
        listProductByType = query.setFirstResult(position).setMaxResults(quantity).getResultList();
        return listProductByType;
    }

    @Override
    @Transactional
    public ProductEntity getProductById(int idProduct) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from ProductEntity where id = :idProduct";
        Query query = session.createQuery(sql.toString());
        query.setParameter("idProduct", idProduct);
        ProductEntity product = (ProductEntity) query.uniqueResult();
        return product;
    }

    @Override
    @Transactional
    public Long countProductByType(int idTypeProduct) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select count(*) from ProductEntity where typeProductEntity.id = :idTypeProduct";
        Query query = session.createQuery(sql.toString());
        query.setParameter("idTypeProduct", idTypeProduct);
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    @Transactional(rollbackFor={Exception.class})
    public void addProduct(ProductEntity productEntity) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.save(productEntity);
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public boolean updateProduct(ProductEntity productEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(productEntity);
        return false;
    }
}
