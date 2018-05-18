package com.dongvv2.services;

import com.dongvv2.daoimp.DatHangDaoImp;
import com.dongvv2.persistence.data.BillDetailEntity;
import com.dongvv2.persistence.data.BillEntity;
import com.dongvv2.persistence.data.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatHangService {

    @Autowired
    DatHangDaoImp datHangDaoImp;

    public int addCustomer(CustomerEntity customerEntity) {
        return datHangDaoImp.addCustomer(customerEntity);
    }

    public int addBill(BillEntity billEntity) {
        return datHangDaoImp.addBillEntity(billEntity);
    }

    public int addBillDetail(BillDetailEntity billDetailEntity) {
        return datHangDaoImp.addBillDetailEntity(billDetailEntity);
    }
}
