
package com.portfolio.coffeedistrict.services;

import com.portfolio.coffeedistrict.entities.Coffee;
import com.portfolio.coffeedistrict.repositories.CoffeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


    @Service


    public class CoffeeService {

        private final CoffeeRepository coffeeRepository;

        public CoffeeService(CoffeeRepository coffeeRepository) {
            this.coffeeRepository = coffeeRepository;
        }


        public Page<Coffee> getAllCoffees(String country, String brand, String aroma, Pageable pageable) {

            country = normalizeFilter(country);
            brand = normalizeFilter(brand);
            aroma = normalizeFilter(aroma);

            return coffeeRepository.findByFilters(country, brand, aroma, pageable);
        }


        private String normalizeFilter(String filter) {
            return filter == null || filter.isBlank() ? null : filter.trim();
        }

        public Optional<Coffee> getCoffeeBySlug(String slug) {
            return coffeeRepository.findBySlug(slug);
        }
    }

