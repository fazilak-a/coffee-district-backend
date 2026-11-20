
package com.portfolio.coffeedistrict.services;

import com.portfolio.coffeedistrict.entities.Cookie;
import com.portfolio.coffeedistrict.repositories.CookieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


    @Service
    public class CookieService {

    private final CookieRepository cookieRepository;


    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }


    public Page<Cookie> getAllCookies(
            String country,
            String brand,
            String mainFlavour,
            String allergens,
            Pageable pageable
    ) {


        country = normalizeFilter(country);
        brand = normalizeFilter(brand);
        mainFlavour = normalizeFilter(mainFlavour);
        allergens = normalizeFilter(allergens);



        return cookieRepository.findByFilters(
                country,
                brand,
                mainFlavour,
                allergens,
                pageable
        );
    }

    private String normalizeFilter(String filter) {

        return filter == null || filter.isBlank()
                ? null
                : filter.trim();
    }


    public Optional<Cookie> getCookieBySlug(String slug) {

        return cookieRepository.findBySlug(slug);
    }

}
