package com.dongvv2.services;

import com.dongvv2.dao.ProductDao;
import com.dongvv2.daoimp.ProductDaoImp;
import com.dongvv2.persistence.data.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<ProductEntity> getFindAllProduct(int position) {
        return productDao.getListProduct(position);
    }
    public List<ProductEntity> getListNewProduct() {
        return productDao.getListNewProduct();
    }
    public List<ProductEntity> getListSaleProduct() {
        return productDao.getListSaleProduct();
    }

    public List<ProductEntity> getListProductByType(int idTypeProduct, int position, int quantity) {
        return productDao.getListProductByType(idTypeProduct, position, quantity);
    }

    public ProductEntity getProductById(int idProduct) {
        return productDao.getProductById(idProduct);
    }
    public Long countProductByType(int idTypeProduct) {
        return productDao.countProductByType(idTypeProduct);
    }
    public void addProduct(ProductEntity productEntity) {
        productDao.addProduct(productEntity);
    }
    public boolean updateProduct(ProductEntity productEntity) {
        return productDao.updateProduct(productEntity);
    }
}
