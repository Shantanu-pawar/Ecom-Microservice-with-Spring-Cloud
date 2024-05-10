package com.Ecom.productservice.Controller;

import com.Ecom.productservice.Service.ProductService;
import com.Ecom.productservice.dto.ProductRequest;
import com.Ecom.productservice.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired private ProductService productService;

    @PostMapping("create")
    public ResponseEntity createProduct(@RequestBody ProductRequest request){
        try{
            String response = productService.createProduct(request);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-all")
    public ResponseEntity getAllProduct(){
        try {
            List<ProductResponse> response = productService.getAllProduct();
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
