package com.sideeg.prices.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public class ItemsBaseRespnse {

    @SerializedName("data")
    private List<Item> data;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setData(List<Item> data){
        this.data = data;
    }

    public List<Item> getData(){
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

    @NonNull
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