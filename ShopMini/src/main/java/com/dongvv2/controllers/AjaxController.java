package com.dongvv2.controllers;

import com.dongvv2.dto.ProductDto;
import com.dongvv2.persistence.data.ProductEntity;
import com.dongvv2.persistence.data.TypeProductEntity;
import com.dongvv2.services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AjaxController {

    @Autowired
    ProductService productService;

    @Autowired
    ServletContext servletContext;

    @GetMapping(path = "/getProductLimit", produces = {"text/plain; charset=utf-8"})
    @ResponseBody
    public String getProductLimit(@RequestParam int page) {
        int position  = (page - 1) * 5;
        List<ProductEntity> listProducts = productService.getFindAllProduct(position);
        String html = "";
        int stt = position;
        for(ProductEntity product : listProducts) {
            html += "<tr>";
            html += "<th scope='row'>"+(stt = stt + 1)+"</th>";
            html += "<td>"+ product.getName() +"</td>";
            html += "<td>"+product.getTypeProductEntity().getName()+"</td>";
            html += "<td>"+ (product.getPromotionPrice() !=0 ? product.getPromotionPrice() : product.getUnitPrice())+"</td>";
            html += "<td>";
            html += "<button class=\"btn btn-primary editProduct\" data-id='"+product.getId()+"'>Edit</button>";
            html += "<button class=\"btn btn-danger deleteProduct\" data-id='"+product.getId()+"'>Delete</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(MultipartHttpServletRequest request) {

        // lay ra path thuc te cua project de upload anh vao
        // duong dan nay` nam` o tomcat(server) => khac voi php vi php cai dat o xampp lun
        String pathSave = servletContext.getRealPath("/resources/image/product/");

        // get ra listfile
        Iterator<String> listFile = request.getFileNames();

        // get file co trong list file
        MultipartFile mpf = request.getFile(listFile.next());

        // get ra duoc file roi => lay ten cua file => save vao path o tren
        File file = new File(pathSave + mpf.getOriginalFilename());
        try {
            mpf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public String addProduct(@RequestParam String jsonData) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductEntity productEntity = new ProductEntity();
        try {
            JsonNode jsonObject = objectMapper.readTree(jsonData);
            productEntity.setName(jsonObject.get("name").asText());
            TypeProductEntity typeProductEntity = new TypeProductEntity();
            typeProductEntity.setId(jsonObject.get("typeProductEntity").asInt());
            productEntity.setTypeProductEntity(typeProductEntity);
            productEntity.setUnitPrice(jsonObject.get("unitPrice").asLong());
            productEntity.setPromotionPrice(jsonObject.get("promotionPrice").asLong());
            productEntity.setUnit(jsonObject.get("unit").asText());
            productEntity.setNews(jsonObject.get("news").asInt());
            productEntity.setDescription(jsonObject.get("description").asText());
            productEntity.setImage(jsonObject.get("image").asText());
            productEntity.setCreated_at(new Timestamp(System.currentTimeMillis()));
            productEntity.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            // add product
            productService.addProduct(productEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "add product success";
    }

    @GetMapping(path = "/getProductById", produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public ProductDto getProductById(@RequestParam int id) {
        ProductEntity productEntity = productService.getProductById(id);
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setDescription(productEntity.getDescription());
        productDto.setCreated_at(productEntity.getCreated_at());
        productDto.setImage(productEntity.getImage());
        productDto.setNews(productEntity.getNews());
        productDto.setPromotionPrice(productEntity.getPromotionPrice());
        productDto.setUnit(productEntity.getUnit());
        productDto.setUnitPrice(productEntity.getUnitPrice());
        productDto.setUpdated_at(productEntity.getUpdated_at());
        TypeProductEntity typeProductEntity = new TypeProductEntity();
        typeProductEntity.setId(productEntity.getTypeProductEntity().getId());
        typeProductEntity.setName(productEntity.getTypeProductEntity().getName());
        typeProductEntity.setDescription(productEntity.getTypeProductEntity().getDescription());
        typeProductEntity.setImage(productEntity.getTypeProductEntity().getImage());
        productDto.setTypeProductEntity(typeProductEntity);
        return productDto;
    }

    @PostMapping("/updateProduct")
    @ResponseBody
    public String updateProduct(@RequestParam String jsonData) {
        ProductEntity productEntity = new ProductEntity();
        // parse json  => Object
        // php co ham encode=> trong java => lam thu cong met lam => su dung thu vien jackson
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonObject = objectMapper.readTree(jsonData);
            productEntity.setId(jsonObject.get("id").asInt());

            TypeProductEntity typeProductEntity = new TypeProductEntity();
            typeProductEntity.setId(jsonObject.get("typeProductEntity").asInt());

            productEntity.setTypeProductEntity(typeProductEntity);
            productEntity.setName(jsonObject.get("name").asText());
            productEntity.setUnitPrice(jsonObject.get("unitPrice").asLong());
            productEntity.setPromotionPrice(jsonObject.get("promotionPrice").asLong());
            productEntity.setUnit(jsonObject.get("unit").asText());
            productEntity.setDescription(jsonObject.get("description").asText());
            productEntity.setNews(jsonObject.get("news").asInt());
            productEntity.setImage(jsonObject.get("image").asText());
            productEntity.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            productService.updateProduct(productEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ok";
    }
}
