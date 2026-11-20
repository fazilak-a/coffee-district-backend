package com.portfolio.coffeedistrict.controllers;
import com.portfolio.coffeedistrict.entities.Product;
import com.portfolio.coffeedistrict.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;




    @RestController

    @RequestMapping("/products")



    public class ProductController {

        private final ProductService productService;

        public ProductController(ProductService productService) {
            this.productService = productService;
        }


        @GetMapping
        public Page<Product> getAllProducts(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "12") int size
        ) {
            Pageable pageable = PageRequest.of(page, size);
            return productService.getAllProducts(pageable);
        }

    }
