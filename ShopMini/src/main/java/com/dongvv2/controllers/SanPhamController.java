package com.dongvv2.controllers;

import com.dongvv2.persistence.data.ProductEntity;
import com.dongvv2.persistence.data.TypeProductEntity;
import com.dongvv2.services.DanhMucService;
import com.dongvv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/danhmuc")
public class SanPhamController {

    @Autowired
    ProductService productService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/{idType}/{page}")
    public String index(ModelMap modelMap, @PathVariable int idType, @PathVariable int page) {
        int quantity = 2;
        int position = (page - 1) * quantity;
        List<ProductEntity> listProductByType = productService.getListProductByType(idType, position, quantity);
        List<TypeProductEntity> listDanhMuc = danhMucService.getListDanhMuc();
        Long countProductByType = productService.countProductByType(idType);
        double soTrang = Math.ceil((double)countProductByType / quantity);
        System.out.println(countProductByType);
        System.out.println(soTrang);
        modelMap.addAttribute("listProductByType", listProductByType);
        modelMap.addAttribute("soTrang", soTrang);
        modelMap.addAttribute("danhmuc", listDanhMuc);
        return "TypeProduct";
    }
}
