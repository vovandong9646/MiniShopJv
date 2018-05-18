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

import java.util.List;

@Controller
@RequestMapping("/themSanPham")
public class ThemSanPhamController {

    @Autowired
    DanhMucService danhMucService;

    @Autowired
    ProductService productService;

    @GetMapping
    public String index(ModelMap modelMap) {
        int position = 0;
        List<TypeProductEntity> danhmuc = danhMucService.getListDanhMuc();
        List<ProductEntity> listProducts = productService.getFindAllProduct(0);
        List<ProductEntity> allProducts = productService.getFindAllProduct(-1);
        int totalPage = (int) Math.ceil((double)allProducts.size() / 5);
        System.out.println(allProducts.size());
        System.out.println(totalPage);
        modelMap.addAttribute("danhmuc", danhmuc);
        modelMap.addAttribute("listProducts", listProducts);
        modelMap.addAttribute("totalPage", totalPage);
        return "themsanpham";
    }
}
