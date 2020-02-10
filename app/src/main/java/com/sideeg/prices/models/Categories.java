package com.sideeg.prices.models;

/**
 * Created by sideeg on 1/12/2019.
 */

public class Categories {

    private String name;
    private int Image;

    public Categories(String name, int image) {
        this.name = name;
        Image = image;
    }

    public Categories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
