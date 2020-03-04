package com.sideeg.prices.NetWorkApis;



import com.sideeg.prices.models.CategoriesBaseRespnse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetWorkApis {


    @GET("studentsave")
    Call<CategoriesBaseRespnse> getCatogies(@Query("name") String studentName, @Query("className") String className, @Query("schoolid") String schoolid, @Query("supervisor_id") int supervisor_id, @Query("parent_id") int parent_id);

}
