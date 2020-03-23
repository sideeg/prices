package com.sideeg.prices.NetWorkApis;



import com.sideeg.prices.models.CategoriesBaseRespnse;
import com.sideeg.prices.models.ItemsBaseRespnse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetWorkApis {


    @GET("Category")
    Call<CategoriesBaseRespnse> getCatogies();

    @GET("Item")
    Call<ItemsBaseRespnse> getItems();

}
