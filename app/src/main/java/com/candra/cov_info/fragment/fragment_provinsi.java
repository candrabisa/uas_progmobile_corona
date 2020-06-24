package com.candra.cov_info.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.candra.cov_info.R;
import com.candra.cov_info.adapter.AdapterProvinsi;
import com.candra.cov_info.model.ModelProvinsi;
import com.candra.cov_info.view.view_provinsi;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_provinsi extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    public fragment_provinsi() {
        // Required empty public constructor
    }

    private AdapterProvinsi adapter;
    private SwipeRefreshLayout swipeRefreshProvince;
    private TextView tvEmpty;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvEmpty = view.findViewById(R.id.tvEmptyListProvince);
        RecyclerView recyclerView = view.findViewById(R.id.provinceRecycler);
        adapter = new AdapterProvinsi(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        swipeRefreshProvince = view.findViewById(R.id.swipeRefreshProvince);
        swipeRefreshProvince.setOnRefreshListener(this);

        loadProvinceData();

    }
    private void loadProvinceData() {
        view_provinsi viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(view_provinsi.class);
        viewModel.setProvinceData();
        refreshing(true);
        viewModel.getProvinceData().observe(getViewLifecycleOwner(), new Observer<ArrayList<ModelProvinsi>>() {
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

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provinsi, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}
