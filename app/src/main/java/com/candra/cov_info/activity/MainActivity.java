package com.candra.cov_info.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.candra.cov_info.R;
import com.candra.cov_info.fragment.fragment_dunia;
import com.candra.cov_info.fragment.fragment_indonesia;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TextView tvToday;
    String hariIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragment_dunia Fragment_dunia = new fragment_dunia();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, Fragment_dunia)
                    .commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_dunia:
                    fragment_dunia Fragment_dunia = new fragment_dunia();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, Fragment_dunia)
                            .commit();
                    return true;

                case R.id.navigation_indonesia:
                    fragment_indonesia Fragment_indonesia = new fragment_indonesia();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, Fragment_indonesia)
                            .commit();
                    return true;

            }
            return false;
        }
    };
}
