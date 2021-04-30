package com.richardduahboakye.shopit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemModel {
    private String name;
    private String description;
    private String Rating;
    private String price;
    @SerializedName("categorie")
    @Expose
    private String category;
    private String stock;
    private String img;

    public ItemModel(String name, String description, String rating, String price, String category, String stock, String img) {
        this.name = name;
        this.description = description;
        Rating = rating;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.img = img;
    }



    public ItemModel() {
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

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
