package com.candra.cov_info.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.candra.cov_info.R;
import com.candra.cov_info.adapter.AdapterProvinsi;
import com.candra.cov_info.model.ModelProvinsi;
import com.candra.cov_info.view.view_provinsi;

import java.util.ArrayList;

public class activity_provinsi extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private AdapterProvinsi adapter;
    private SwipeRefreshLayout swipeRefreshProvince;
    private TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Provinsi");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        tvEmpty = findViewById(R.id.tvEmptyListProvince);
        RecyclerView recyclerView = findViewById(R.id.provinceRecycler);
        adapter = new AdapterProvinsi(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        swipeRefreshProvince = findViewById(R.id.swipeRefreshProvince);
        swipeRefreshProvince.setOnRefreshListener(this);

        loadProvinceData();

    }
    private void loadProvinceData() {
        view_provinsi viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(view_provinsi.class);
        viewModel.setProvinceData();
        refreshing(true);
        viewModel.getProvinceData().observe(this, new Observer<ArrayList<ModelProvinsi>>() {
            @Override
            public void onChanged(ArrayList<ModelProvinsi> indonesiaProvinsiModels) {
                if (indonesiaProvinsiModels == null) {
                    tvEmpty.setVisibility(View.VISIBLE);
                    refreshing(false);
                } else {
                    adapter.setIndoList(indonesiaProvinsiModels);
                    refreshing(false);
                }

            }
        });
    }

    private void refreshing(boolean isRefreshing) {
        if (isRefreshing) {
            swipeRefreshProvince.setRefreshing(true);
        } else {
            swipeRefreshProvince.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        loadProvinceData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
