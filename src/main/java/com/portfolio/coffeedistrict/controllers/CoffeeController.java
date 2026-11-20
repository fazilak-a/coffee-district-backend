
package com.portfolio.coffeedistrict.controllers;

import com.portfolio.coffeedistrict.entities.Coffee;
import com.portfolio.coffeedistrict.services.CoffeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


    @RestController

    @RequestMapping("/coffees")


    public class CoffeeController {

    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("price", "title", "aroma");


    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;

    }


    @GetMapping

    public Page<Coffee> getAllCoffees(
            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "12") int size,

            @RequestParam(required = false) String country,

            @RequestParam(required = false) String brand,

            @RequestParam(required = false) String aroma,

            @RequestParam(required = false) String sortBy,

            @RequestParam(defaultValue = "asc") String direction

    ) {

        Sort sort = Sort.unsorted();

        if (sortBy != null && ALLOWED_SORT_FIELDS.contains(sortBy)) {


            Sort.Direction sortDirection = direction.equalsIgnoreCase("desc")
                    ? Sort.Direction.DESC
                    : Sort.Direction.ASC;

            sort = Sort.by(sortDirection, sortBy);
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        return coffeeService.getAllCoffees(country, brand, aroma, pageable);

    }


    @GetMapping("/{slug}")

    public ResponseEntity<Coffee> getCoffeeBySlug(@PathVariable String slug) {
        return coffeeService.getCoffeeBySlug(slug)
                .map(ResponseEntity::ok)

                .orElse(ResponseEntity.notFound().build());

    }

}
