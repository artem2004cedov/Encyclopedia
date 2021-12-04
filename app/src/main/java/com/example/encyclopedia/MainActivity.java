package com.example.encyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.encyclopedia.adapter.DateAdapter;
import com.example.encyclopedia.adapter.ListItem;
import com.example.encyclopedia.adapter.RecOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener {
    private RecOnClickListener recOnClickListener;
    private DateAdapter adapter;
    private List<ListItem> listData;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMenu();
        setRecOnClicListener();
        init();
    }

    // устанавлевам навигетин вьев
    @Override
    public void onNavItemSelectedListener(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.id_planets:
                updateMainList(getResources().getStringArray(R.array.planets),"planets");
                break;
            case R.id.id_starts:
                updateMainList(getResources().getStringArray(R.array.stars), "stars");
                break;
            case R.id.id_travel:
                updateMainList(getResources().getStringArray(R.array.travel), "travel");
                break;
            case R.id.id_smart:
                updateMainList(getResources().getStringArray(R.array.smart_quotes), "quotes");
                break;
            case R.id.id_filosof:
                updateMainList(getResources().getStringArray(R.array.philosophers), "philosophers");
                break;
            case R.id.id_umer:
                updateMainList(getResources().getStringArray(R.array.humor), "humor");
                break;
        }

    }

    // берет все элементы масива
    private void updateMainList(String[] array, String cat) {



        // новый лист для заолнения адаптера
        List<ListItem> list = new ArrayList<>();
        // цикл проходит по всем элементам
        for (int i = 0; i < array.length; i++) {
            ListItem item = new ListItem();
            item.setText(array[i]);
            item.setFavarite(false);
            item.setCat(cat);
            list.add(item);
        }
        adapter.updetList(list);

        // 1 элемент в нем имя,кат,age.. итд
    }

    private void init() {
        recyclerView = findViewById(R.id.recalcalviev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listData = new ArrayList<>();
        // передаем контекст, позацию, List
        adapter = new DateAdapter(this, recOnClickListener, listData);
        recyclerView.setAdapter(adapter);
    }

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

    private void setRecOnClicListener() {
        recOnClickListener = new RecOnClickListener() {
            @Override
            public void onClickItem(int positeon) {
                Toast.makeText(MainActivity.this, "позиция " + positeon, Toast.LENGTH_SHORT).show();
            }
        };
    }
}