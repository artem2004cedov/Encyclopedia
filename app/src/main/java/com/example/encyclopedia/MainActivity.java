package com.example.encyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMenu();
    }


    // устанавлевам навигетин вьев
    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuFragmentList mMenuFragment = (MenuFragmentList) fm.findFragmentById(R.id.fragment_id);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuFragmentList();
            // мост
            mMenuFragment.setNavItemSelectedListener(this);
            fm.beginTransaction().add(R.id.fragment_id, mMenuFragment).commit();
        }
    }


    @Override
    public void onNavItemSelectedListener(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

    }
}