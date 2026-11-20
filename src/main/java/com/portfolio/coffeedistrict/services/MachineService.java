
package com.portfolio.coffeedistrict.services;

import com.portfolio.coffeedistrict.entities.Machine;
import com.portfolio.coffeedistrict.repositories.MachineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


    @Service
    public class MachineService {

    private final MachineRepository machineRepository;


    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }


    public Page<Machine> getAllMachines(
            String country,
            String brand,
            String color,
            Pageable pageable
    ) {

        country = normalizeFilter(country);
        brand = normalizeFilter(brand);
        color = normalizeFilter(color);

        return machineRepository.findByFilters(
                country,
                brand,
                color,
                pageable
        );
    }


    private String normalizeFilter(String filter) {

        return filter == null || filter.isBlank()
                ? null
                : filter.trim();
    }


    public Optional<Machine> getMachineBySlug(String slug) {

        return machineRepository.findBySlug(slug);
    }

}
