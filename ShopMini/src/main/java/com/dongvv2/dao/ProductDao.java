package com.dongvv2.dao;

import com.dongvv2.persistence.data.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface ProductDao {
    List<ProductEntity> getListProduct(int position);
    List<ProductEntity> getListNewProduct();
    List<ProductEntity> getListSaleProduct();
    List<ProductEntity> getListProductByType(int idTypeProduct, int position, int quantity);
    ProductEntity getProductById(int idProduct);
    Long countProductByType(int idTypeProduct);
    void addProduct(ProductEntity productEntity);
    boolean updateProduct(ProductEntity productEntity);
}
