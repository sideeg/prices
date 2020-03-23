package com.sideeg.prices.models;

/**
 * Created by sideeg on 1/12/2019.
 */

public class Item {
    private String name;
    private String descroption;
    private String image;
    private int price;
    private String data;

    public Item() {
    }

    public Item(String name, String descroption, String image, int price,String data) {
        this.name = name;
        this.descroption = descroption;
        this.image = image;
        this.price = price;
        this.data = data;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
