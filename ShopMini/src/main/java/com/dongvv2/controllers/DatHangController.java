package com.dongvv2.controllers;

import com.dongvv2.persistence.data.BillDetailEntity;
import com.dongvv2.persistence.data.BillEntity;
import com.dongvv2.persistence.data.Cart;
import com.dongvv2.persistence.data.CustomerEntity;
import com.dongvv2.services.DatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dathang")
public class DatHangController {

    @Autowired
    DatHangService datHangService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("customer", new CustomerEntity());
        return "dathang";
    }

    @PostMapping
    public String addHoaDon(HttpSession session, @RequestParam float total, @ModelAttribute("customer")CustomerEntity customerEntity) {

        if(session.getAttribute("cart") != null) {
            List<Cart> listCarts = (List<Cart>) session.getAttribute("cart");
            customerEntity.setCreated_at(new Timestamp(System.currentTimeMillis()));
            customerEntity.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            int idCustomer = datHangService.addCustomer(customerEntity);
            if(idCustomer > 0) {
                BillEntity billEntity = new BillEntity();
                billEntity.setCustomerEntity(customerEntity);
                billEntity.setDateOrder(new Date());
                billEntity.setTotal(total);
                billEntity.setPayment("Payment");
                billEntity.setNote("Note");
                billEntity.setCreated_at(new Timestamp(System.currentTimeMillis()));
                billEntity.setUpdated_at(new Timestamp(System.currentTimeMillis()));
                int idBill = datHangService.addBill(billEntity);
                if(idBill > 0) {
                    for(Cart cart: listCarts) {
                        BillDetailEntity billDetailEntity = new BillDetailEntity();
                        billDetailEntity.setBillEntity(billEntity);
                        billDetailEntity.setProductEntity(cart.getProductEntity());
                        billDetailEntity.setQuantity(cart.getQuantity());
                        if (cart.getProductEntity().getPromotionPrice() != 0) {
                            billDetailEntity.setUnitPrice(cart.getProductEntity().getPromotionPrice());
                        } else {
                            billDetailEntity.setUnitPrice(cart.getProductEntity().getUnitPrice());
                        }
                        billDetailEntity.setCreated_at(new Timestamp(System.currentTimeMillis()));
                        billDetailEntity.setUpdated_at(new Timestamp(System.currentTimeMillis()));
                        int idBillDetail = datHangService.addBillDetail(billDetailEntity);
                        if (idBillDetail > 0) {
                            System.out.println("Add success");
                        }
                    }
                } else {
                    System.out.println("Add Bill Fail");
                }
            } else {
                System.out.println("Add Customer Fail");
            }
        }
        session.removeAttribute("cart");
        return "redirect:/";
    }
}
