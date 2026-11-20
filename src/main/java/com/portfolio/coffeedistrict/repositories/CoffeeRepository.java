
package com.portfolio.coffeedistrict.repositories;

import com.portfolio.coffeedistrict.entities.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    Optional<Coffee> findBySlug(String slug);

    Page<Coffee> findByCountry(String country, Pageable pageable);

    Page<Coffee> findByBrand(String brand, Pageable pageable);

    Page<Coffee> findByCountryAndBrand(String country, String brand, Pageable pageable);

    Page<Coffee> findByAroma(String aroma, Pageable pageable);


    @Query("""
        SELECT c FROM Coffee c
        WHERE (:country IS NULL OR c.country = :country)
        AND (:brand IS NULL OR c.brand = :brand)
        AND (:aroma IS NULL OR c.aroma = :aroma)
        """)


    Page<Coffee> findByFilters(
            @Param("country") String country,
            @Param("brand") String brand,
            @Param("aroma") String aroma,
            Pageable pageable
    );


}







