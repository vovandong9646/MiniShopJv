package com.dongvv2.dao;

import com.dongvv2.persistence.data.BillDetailEntity;
import com.dongvv2.persistence.data.BillEntity;
import com.dongvv2.persistence.data.Cart;
import com.dongvv2.persistence.data.CustomerEntity;

import java.util.List;

public interface DatHangDao {
    int addCustomer(CustomerEntity customerEntity);
    int addBillEntity(BillEntity billEntity);
    int addBillDetailEntity(BillDetailEntity billDetailEntity);
}
