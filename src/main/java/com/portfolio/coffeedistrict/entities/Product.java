package com.portfolio.coffeedistrict.entities;


import jakarta.persistence.*;
import com.portfolio.coffeedistrict.enums.Category;
import java.math.BigDecimal;
import java.time.LocalDateTime;




    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)

    public abstract class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;


        @Column(name = "title", unique = true, nullable = false)
        private String title;


        @Column(name = "slug", unique = true, nullable = false)
        private String slug;


        @Column(name = "tag")
        private String tag;


        @Column(name = "brand", nullable = false)
        private String brand;


        @Column(name = "country", nullable = false )
        private String country;


        @Column(name = "price", nullable = false)
        private BigDecimal price;


        @Column(name = "description", nullable = false)
        private String description;


        @Column(name = "stock")
        private int stock;


        @Column(name = "imageUrl", nullable = false)
        private String imageUrl;


        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;


        @Enumerated(EnumType.STRING)
        @Column(name = "category", nullable = false)
        private Category category;




        // Getters

        public Long getId() {return id;}
        public String getTitle() {return title;}
        public String getSlug() {return slug;}
        public String getTag() {return tag;}
        public String getBrand() {return brand;}
        public String getCountry() {
            return country;
        }
        public BigDecimal getPrice() {return price;}
        public String getDescription() {return description;}
        public int getStock() {return stock;}
        public String getImageUrl() {return imageUrl;}
        public LocalDateTime getCreatedAt() {return createdAt;}
        public Category getCategory() {return category;}


        // Setters
        public void setId(Long id) {this.id = id;}
        public void setTitle(String title) {this.title = title;}
        public void setSlug(String slug) {this.slug = slug;}
        public void setTag(String tag) {this.tag = tag;}
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setPrice(BigDecimal price) {this.price = price;}
        public void setDescription(String description) {this.description = description;}
        public void setStock(int stock) {this.stock = stock;}
        public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

        @PrePersist
        protected void onCreate() {this.createdAt = LocalDateTime.now();}
        public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
        public void setCategory(Category category) {this.category = category;}

    }