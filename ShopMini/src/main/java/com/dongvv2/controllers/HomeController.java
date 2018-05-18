package com.dongvv2.controllers;

import com.dongvv2.persistence.data.ProductEntity;
import com.dongvv2.persistence.data.TypeProductEntity;
import com.dongvv2.services.DanhMucService;
import com.dongvv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping
    public String index(ModelMap modelMap) {

        List<ProductEntity> listNewProduct = productService.getListNewProduct();
        List<ProductEntity> listSaleProduct = productService.getListSaleProduct();
        List<TypeProductEntity> listDanhMuc = danhMucService.getListDanhMuc();
        modelMap.addAttribute("listNewProduct", listNewProduct);
        modelMap.addAttribute("listSaleProduct", listSaleProduct);
        modelMap.addAttribute("danhmuc", listDanhMuc);
        return "index";
    }

}
