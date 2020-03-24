package com.sideeg.prices.NetWorkApis;



import com.sideeg.prices.models.CategoriesBaseRespnse;
import com.sideeg.prices.models.ItemsBaseRespnse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NetWorkApis {


    @GET("categories")
    Call<CategoriesBaseRespnse> getCatogies();

    @GET()
    Call<ItemsBaseRespnse> getItems(@Url String url);

}
