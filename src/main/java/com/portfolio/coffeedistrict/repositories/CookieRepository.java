
package com.portfolio.coffeedistrict.repositories;

import com.portfolio.coffeedistrict.entities.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CookieRepository extends JpaRepository<Cookie, Long> {


    Optional<Cookie> findBySlug(String slug);

    @Query("""
        SELECT c FROM Cookie c
        WHERE (:country IS NULL OR c.country = :country)
        AND (:brand IS NULL OR c.brand = :brand)
        AND (:mainFlavour IS NULL OR c.mainFlavour = :mainFlavour)
        AND (:allergens IS NULL OR LOWER(c.allergens) LIKE LOWER(CONCAT('%', :allergens, '%')))
        """)
    Page<Cookie> findByFilters(
            @Param("country") String country,
            @Param("brand") String brand,
            @Param("mainFlavour") String mainFlavour,
            @Param("allergens") String allergens,
            Pageable pageable
    );

}
