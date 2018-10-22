package com.example.rpclearning.controller;

import com.example.rpclearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanjie
 * @date 2018/9/29 17:59
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable("id") Long productId) {
        return productService.select(productId);
    }

    @GetMapping
    public Object getAllProduct() {
        return productService.getAllProduct();
    }

//    @PutMapping("/{id}")
//    public CommonResponse updateProduct(@PathVariable("id") Long productId, @RequestBody Product newProduct) throws ServiceException {
//        return ResponseUtil.generateResponse(productService.update(productId, newProduct));
//    }
//
//    @DeleteMapping("/{id}")
//    public CommonResponse deleteProduct(@PathVariable("id") long productId) throws ServiceException {
//        return ResponseUtil.generateResponse(productService.delete(productId));
//    }
//
//    @PostMapping
//    public CommonResponse addProduct(@RequestBody Product newProduct) throws ServiceException {
//        return ResponseUtil.generateResponse(productService.add(newProduct));
//    }

}
