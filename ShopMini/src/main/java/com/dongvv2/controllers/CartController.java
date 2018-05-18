package com.dongvv2.controllers;

import com.dongvv2.persistence.data.Cart;
import com.dongvv2.persistence.data.ProductEntity;
import com.dongvv2.persistence.data.TypeProductEntity;
import com.dongvv2.services.DanhMucService;
import com.dongvv2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping
    public String getListCart(ModelMap modelMap) {
        List<TypeProductEntity> listdanhmuc = danhMucService.getListDanhMuc();
        modelMap.addAttribute("danhmuc", listdanhmuc);
        return "cart";
    }

    @GetMapping("/{id}")
    public String addCart(HttpSession session, @PathVariable int id) {

        // c1: query tu product theo id
        // c2: truyen tat ca gia tri muon insert vao qua url => khong can query sql
        if(null == session.getAttribute("cart")) {
            // add cart
            List<Cart> listCart = new ArrayList<Cart>();
            Cart cart = new Cart();
            cart.setProductEntity(productService.getProductById(id));
            cart.setQuantity(1);
            listCart.add(cart);
            session.setAttribute("cart", listCart);
        } else {
            // increment quantity
            List<Cart> listCart = (List<Cart>) session.getAttribute("cart");
            int index = findIndex(id, listCart);
            if(index != -1) {
                listCart.get(index).setQuantity(listCart.get(index).getQuantity() + 1);
            } else {
                Cart cart = new Cart();
                cart.setProductEntity(productService.getProductById(id));
                cart.setQuantity(1);
                listCart.add(cart);
            }
        }
        return "redirect: /cart";
    }

    private Integer findIndex(int id, List<Cart> listCart) {
        int index = -1;
        for(int i=0;i<listCart.size();i++) {
            if(listCart.get(i).getProductEntity().getId() == id) {
                index = i;
            }
        }
        return index;
    }

    @GetMapping("/{id}/remove")
    public String removeCart(@PathVariable int id, @SessionAttribute("cart") List<Cart> carts) {
        //c1: dung id query sql => remove truyen vao Object
        // c2: dung ham findIndex => tim vi tri index => remove di vi tri index
        if(carts != null) {
            int index = this.findIndex(id, carts);
            carts.remove(index);
        }
        return "redirect: /cart";
    }

    @GetMapping("/update")
    @ResponseBody
    public String updateCart(HttpSession httpSession,@RequestParam int quantity, @RequestParam int id) {
        // c1: lay lun cai list tim index => update lai quantity
        // c2: for vong lap so sanh => update lai quantity
        float price = 0;
        if(httpSession.getAttribute("cart")!=null) {
            List<Cart> listCart = (List<Cart>) httpSession.getAttribute("cart");

            for(Cart cart : listCart) {
                if(cart.getProductEntity().getId() == id) {
                    cart.setQuantity(quantity);
                    price = (cart.getProductEntity().getPromotionPrice() != 0) ? cart.getProductEntity().getPromotionPrice() : cart.getProductEntity().getUnitPrice();
                    break;
                }
            }
        }
        return ""+price;
    }
}
