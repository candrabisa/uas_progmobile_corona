package com.candra.cov_info.api;

import com.candra.cov_info.model.ModelDunia;
import com.candra.cov_info.model.ModelIndonesia;
import com.candra.cov_info.model.ModelProvinsi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiCorona {

    //Endpointt Ringkasan Dunia
    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<ModelDunia> getSummaryWorld();

    //Endpoint Ringkasan Indonesia
    @GET(Api.ENDPOINT_SUMMARY_INDONESIA)
    Call<List<ModelIndonesia>> getSummaryIdn();

    //Endpoint Provinsi Indonesia
    @GET(Api.ENDPOINT_INDONESIA_PROVINSI)
    Call<List<ModelProvinsi>> getProvince();
}
