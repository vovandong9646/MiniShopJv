package com.dongvv2.dao;

import com.dongvv2.persistence.data.TypeProductEntity;

import java.util.List;

public interface DanhMucDao {
    List<TypeProductEntity> getListDanhMuc();
}
