package com.sideeg.prices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sideeg on 1/12/2019.
 */

public class Categories {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private int Image;

    public Categories(String name, int image) {
        this.name = name;
        Image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
