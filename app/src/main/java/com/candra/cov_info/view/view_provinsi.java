package com.candra.cov_info.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.candra.cov_info.api.ApiCorona;
import com.candra.cov_info.model.ModelProvinsi;
import com.candra.cov_info.service.RetrofitServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class view_provinsi extends ViewModel {
    private final MutableLiveData<ArrayList<ModelProvinsi>> liveData = new MutableLiveData<>();

    public void setProvinceData() {
        Retrofit retrofit = RetrofitServiceApi.getRetrofitServiceIndo();
        ApiCorona endpoint = retrofit.create(ApiCorona.class);
        Call<List<ModelProvinsi>> call = endpoint.getProvince();
        call.enqueue(new Callback<List<ModelProvinsi>>() {
            @Override
            public void onResponse(Call<List<ModelProvinsi>> call, Response<List<ModelProvinsi>> response) {
                liveData.setValue((ArrayList<ModelProvinsi>) response.body());
            }

            @Override
            public void onFailure(Call<List<ModelProvinsi>> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ModelProvinsi>> getProvinceData() {
        return liveData;
    }
}
