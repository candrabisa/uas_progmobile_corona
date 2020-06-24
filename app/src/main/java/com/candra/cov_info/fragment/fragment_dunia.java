package com.candra.cov_info.fragment;

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
import com.candra.cov_info.model.ModelDunia;
import com.candra.cov_info.view.view_dunia;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_dunia extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener{

    private SwipeRefreshLayout swipe;
    private TextView tvPositive;
    private TextView tvRecovered;
    private TextView tvDeaths;
    public fragment_dunia() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipe = view.findViewById(R.id.swipeRefreshWorld);
        swipe.setOnRefreshListener(this);
        tvPositive = view.findViewById(R.id.tvValuePositifWorld);
        tvRecovered = view.findViewById(R.id.tvValueRecoveredWorld);
        tvDeaths = view.findViewById(R.id.tvValueDeathsWorld);
        loadWorldData();

    }

    private void loadWorldData() {
        view_dunia viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(view_dunia.class);
        viewModel.setSummaryWorldData();
        refreshData(true);
        viewModel.getSummaryWorldData().observe(getViewLifecycleOwner(), new Observer<ModelDunia>() {
            @Override
            public void onChanged(ModelDunia modelDunia) {
                if (modelDunia != null) {
                    refreshData(false);
                    tvPositive.setText(String.valueOf(modelDunia.getTerkonfirmasi().getValue()));
                    tvRecovered.setText(String.valueOf(modelDunia.getSembuh().getValue()));
                    tvDeaths.setText(String.valueOf(modelDunia.getMeninggal().getValue()));
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dunia, container, false);
    }

    @Override
    public void onClick(View view) {

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
        loadWorldData();
    }
}

