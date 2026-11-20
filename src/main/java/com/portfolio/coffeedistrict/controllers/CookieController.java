
package com.portfolio.coffeedistrict.controllers;

import com.portfolio.coffeedistrict.entities.Cookie;
import com.portfolio.coffeedistrict.services.CookieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController

    @RequestMapping("/cookies")


    public class CookieController {

    private final CookieService cookieService;


    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }


    @GetMapping
    public Page<Cookie> getAllCookies(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,

            @RequestParam(required = false) String country,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String mainFlavour,
            @RequestParam(required = false) String allergens,

            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "asc") String direction

    ) {


        if (!sortBy.equals("price")
                && !sortBy.equals("title")
                && !sortBy.equals("quantityPerPacket")) {

            sortBy = "price";
        }

        Sort.Direction sortDirection =
                direction.equalsIgnoreCase("desc")
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC;


        Sort sort = Sort.by(sortDirection, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        return cookieService.getAllCookies(
                country,
                brand,
                mainFlavour,
                allergens,
                pageable
        );
    }


    @GetMapping("/{slug}")
    public ResponseEntity<Cookie> getCookieBySlug(@PathVariable String slug) {

        return cookieService.getCookieBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
