package com.candra.cov_info.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.candra.cov_info.R;
import com.candra.cov_info.activity.activity_provinsi;
import com.candra.cov_info.model.ModelIndonesia;
import com.candra.cov_info.view.view_indonesia;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_indonesia extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private SwipeRefreshLayout swipe;
    private TextView tvPositive;
    private TextView tvRecovered;
    private TextView tvDeath;
    public fragment_indonesia() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indonesia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton floatingProvince = view.findViewById(R.id.floatingProvince);
        swipe = view.findViewById(R.id.swipeRefreshIdn);
        swipe.setOnRefreshListener(this);
        tvPositive = view.findViewById(R.id.tvValuePositifIdn);
        tvRecovered = view.findViewById(R.id.tvValueRecoveredIdn);
        tvDeath = view.findViewById(R.id.tvValueDeathsIdn);
        floatingProvince.setOnClickListener(this);
        loadIdnData();
    }

    private void loadIdnData() {
        view_indonesia viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(view_indonesia.class);
        viewModel.setSummaryData();
        refreshData(true);
        viewModel.getSummaryData().observe(getViewLifecycleOwner(), new Observer<ArrayList<ModelIndonesia>>() {
            @Override
            public void onChanged(ArrayList<ModelIndonesia> modelIndonesia) {
                if (modelIndonesia.size() > 0) {
                    refreshData(false);
                    tvPositive.setText(modelIndonesia.get(0).getPositifIdn());
                    tvRecovered.setText(modelIndonesia.get(0).getSembuhIdn());
                    tvDeath.setText(modelIndonesia.get(0).getMeninggalIdn());
                }
            }
        });
    }

    private void refreshData(boolean isRefresh) {
        if (isRefresh) {
            swipe.setRefreshing(true);
        } else {
            swipe.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        loadIdnData();
    }

    @Override
    public void onClick(View view) {
        Intent provinceIntent = new Intent(getContext(), activity_provinsi.class);
        startActivity(provinceIntent);
    }
}
