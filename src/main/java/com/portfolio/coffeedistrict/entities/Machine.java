package com.portfolio.coffeedistrict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;



    @Entity
    public class Machine extends Product {


            @Column( name = "dimensions" )
            private String dimensions;


            @Column(name = "capacityLiters")
            private BigDecimal capacityLiters;


            @Column(name = "voltage")
                private int voltage;


            @Column (name = "color")
                private String color;


            @Column (name = "warrantyMonths")
                private int warrantyMonths;



            // Getters
            public String getDimensions() {
                return dimensions;
            }
            public BigDecimal getCapacityLiters() {
                return capacityLiters;
            }
            public int getVoltage() {
                return voltage;
            }
            public String getColor() {
                return color;
            }
            public int getWarrantyMonths() {
                return warrantyMonths;
            }



            // Setters
            public void setDimensions(String dimensions) {
                this.dimensions = dimensions;
            }
            public void setCapacityLiters(BigDecimal capacityLiters) {
                this.capacityLiters = capacityLiters;
            }
            public void setVoltage(int voltage) {
                this.voltage = voltage;
            }
            public void setColor(String color) {
                this.color = color;
            }
            public void setWarrantyMonths(int warrantyMonths) {
                this.warrantyMonths = warrantyMonths;
            }

    }
