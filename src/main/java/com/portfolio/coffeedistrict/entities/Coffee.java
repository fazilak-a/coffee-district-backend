package com.portfolio.coffeedistrict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;



    @Entity
    public class Coffee extends Product {


        @Column(name = "region" )
        private String region;

        @Column(name = "aroma" )
        private String aroma;

        @Column(name = "body" )
        private String body;

        @Column(name = "weightPerBag" )
        private int weightPerBag;

        @Column(name = "caffeine" )
        private boolean caffeine;



        // Getters

        public String getRegion() {
            return region;
        }
        public String getAroma() {
            return aroma;
        }
        public String getBody() {
            return body;
        }
        public int getWeightPerBag() {
            return weightPerBag;
        }
        public boolean isCaffeine() {
            return caffeine;
        }


        // Setters

        public void setRegion(String region) {
            this.region = region;
        }
        public void setAroma(String aroma) {
            this.aroma = aroma;
        }
        public void setBody(String body) {
            this.body = body;
        }
        public void setWeightPerBag(int weightPerBag) {
            this.weightPerBag = weightPerBag;
        }
        public void setCaffeine(boolean caffeine) {
            this.caffeine = caffeine;
        }


    }
