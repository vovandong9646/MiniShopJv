package com.dongvv2.services;

import com.dongvv2.daoimp.DanhMucDaoImp;
import com.dongvv2.persistence.data.TypeProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService {

    @Autowired
    DanhMucDaoImp danhMucDaoImp;

    public List<TypeProductEntity> getListDanhMuc() {
        return danhMucDaoImp.getListDanhMuc();
    }

}
