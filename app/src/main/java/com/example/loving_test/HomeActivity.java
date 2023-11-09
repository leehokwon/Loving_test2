package com.example.loving_test;

import static com.example.loving_test.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.loving_test.Fragment.AiFragment;
import com.example.loving_test.Fragment.HomeFragment;
import com.example.loving_test.Fragment.QuestionFragment;
import com.example.loving_test.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        bottomNavigationView = findViewById(id.bottomNav);

        // 초기 프래그먼트 로드
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

    }

    private boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == id.navigation_Home) {
            loadFragment(new HomeFragment());
            return true;
        } else if (itemId == id.navigation_Question) {
            loadFragment(new QuestionFragment());
            return true;
        } else if (itemId == id.navigation_AiChat) {
            loadFragment(new AiFragment());
            return true;
        } else if (itemId == id.navigation_Setting) {
            loadFragment(new SettingFragment());
            return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id.containers, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}