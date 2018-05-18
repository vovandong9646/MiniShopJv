package com.dongvv2.controllers;

import com.dongvv2.persistence.data.ProductEntity;
import com.dongvv2.persistence.data.TypeProductEntity;
import com.dongvv2.services.DanhMucService;
import com.dongvv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class ChiTietSanPhamController {

    @Autowired
    ProductService productService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/{id}/chitiet")
    public String index(ModelMap modelMap, @PathVariable int id) {
        ProductEntity productDetail = productService.getProductById(id);
        List<TypeProductEntity> listDanhMuc = danhMucService.getListDanhMuc();
        modelMap.addAttribute("productDetail", productDetail);
        modelMap.addAttribute("danhmuc", listDanhMuc);
        return "DetailProduct";
    }
}
