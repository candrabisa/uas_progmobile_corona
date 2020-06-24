package com.candra.cov_info.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.candra.cov_info.api.ApiCorona;
import com.candra.cov_info.model.ModelIndonesia;
import com.candra.cov_info.service.RetrofitServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class view_indonesia extends ViewModel {
    private final MutableLiveData<ArrayList<ModelIndonesia>> summaryModel = new MutableLiveData<>();

    public void setSummaryData(){
        Retrofit retrofit = RetrofitServiceApi.getRetrofitServiceIndo();
        ApiCorona endpoint = retrofit.create(ApiCorona.class);
        Call<List<ModelIndonesia>> call = endpoint.getSummaryIdn();
        call.enqueue(new Callback<List<ModelIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelIndonesia>> call, Response<List<ModelIndonesia>> response) {
                summaryModel.setValue((ArrayList<ModelIndonesia>) response.body());
            }

            @Override
            public void onFailure(Call<List<ModelIndonesia>> call, Throwable t) {

            }
        });

    }

    public LiveData<ArrayList<ModelIndonesia>> getSummaryData(){
        return summaryModel;
    }
}
