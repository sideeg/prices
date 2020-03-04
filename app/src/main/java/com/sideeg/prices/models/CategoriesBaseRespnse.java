package com.sideeg.prices.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesBaseRespnse {

    @SerializedName("data")
    private List<Categories> data;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setData(List<Categories> data){
        this.data = data;
    }

    public List<Categories> getData(){
        return data;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return
                "BaseResponse{" +
                        "data = '" + data + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}