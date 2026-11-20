
package com.portfolio.coffeedistrict.repositories;

import com.portfolio.coffeedistrict.entities.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MachineRepository extends JpaRepository<Machine, Long> {


    Optional<Machine> findBySlug(String slug);


    @Query("""
        SELECT m FROM Machine m
        WHERE (:country IS NULL OR m.country = :country)
        AND (:brand IS NULL OR m.brand = :brand)
        AND (:color IS NULL OR LOWER(m.color) = LOWER(:color))
        """)
    Page<Machine> findByFilters(
            @Param("country") String country,
            @Param("brand") String brand,
            @Param("color") String color,
            Pageable pageable
    );

}
