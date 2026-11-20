package com.portfolio.coffeedistrict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;




    @Entity
    public class Cookie extends Product {

        @Column(name = "mainFlavour")
        private String mainFlavour;


        @Column(name = "quantityPerPacket")
        private int quantityPerPacket;


        @Column(name = "allergens")
        private String allergens;



        // Getters
        public String getMainFlavour() {
            return mainFlavour;
        }
        public int getQuantityPerPacket() {
            return quantityPerPacket;
        }
        public String getAllergens() {
            return allergens;
        }

        // Setters
        public void setMainFlavour(String mainFlavour) {
            this.mainFlavour = mainFlavour;
        }
        public void setQuantityPerPacket(int quantityPerPacket) {
            this.quantityPerPacket = quantityPerPacket;
        }
        public void setAllergens(String allergens) {
            this.allergens = allergens;
        }

    }
