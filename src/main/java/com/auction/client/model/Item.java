package com.auction.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String id;
    private String name;
    private String description;
    private double startPrice;
    private String category;
    private String sellerId;
    private String sellerName;
    private String imageUrl;

    public Item(String id,
                String name,
                String description,
                double startPrice,
                String category,
                String sellerId,
                String sellerName,
                String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.category = category;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.imageUrl = imageUrl;
    }

    // Getter - Setter

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartPrice() {
        return startPrice;
    }
    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Override methods
    @Override
    public String toString() {
        return "Item{id='" + id + "', name='" + name + "', category=" + category + "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Item other)) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
