
package com.portfolio.coffeedistrict.controllers;

import com.portfolio.coffeedistrict.entities.Machine;
import com.portfolio.coffeedistrict.services.MachineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/machines")

    public class MachineController {

    private final MachineService machineService;


    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }


    @GetMapping
    public Page<Machine> getAllMachines(


            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,


            @RequestParam(required = false) String country,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,


            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "asc") String direction

    ) {

        if (!sortBy.equals("price")
                && !sortBy.equals("title")) {

            sortBy = "price";
        }

        Sort.Direction sortDirection =
                direction.equalsIgnoreCase("desc")
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC;


        Sort sort = Sort.by(sortDirection, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);


        return machineService.getAllMachines(
                country,
                brand,
                color,
                pageable
        );
    }


    @GetMapping("/{slug}")
    public ResponseEntity<Machine> getMachineBySlug(@PathVariable String slug) {

        return machineService.getMachineBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
