package com.example.SpringException.ExceptionsDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    static Map<Integer,Product> productMap=new HashMap<Integer, Product>();
    static {
        Product fruits=new Product();
        fruits.setId(1);
        fruits.setName("Apple");
        productMap.put(2,fruits);
    }

    @RequestMapping(value = "/getproduct",method = RequestMethod.GET)
    public ResponseEntity getProducts()
    {
        return new ResponseEntity(productMap.values(),HttpStatus.OK);
    }
    @RequestMapping(value = "/addProduct")
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        productMap.put(product.getId(),product);
        return new ResponseEntity("Product is added",HttpStatus.CREATED);

    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        if (!productMap.containsKey(id)) throw new ProductException();
        productMap.remove(id);
        product.setId(id);
        productMap.put(id,product);
        return new ResponseEntity("Product is updated ", HttpStatus.OK);
    }
}
