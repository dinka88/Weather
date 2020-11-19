package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ActivityData extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        TextView textDegrees = findViewById(R.id.textView4);
        textDegrees.setText(Info.getInstance().getDegrees() + " C");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);
        DataFragment dataFragment = new DataFragment();
        dataFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentData, dataFragment).commit();
        initDataCity();
    }
    private void initDataCity(){
        String [] data= getResources().getStringArray(R.array.city_info);
        initRecyclerView(data);
    }
    private CityAdapter initRecyclerView (String[] dataCity){
        RecyclerView recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        CityAdapter cityAdapter= new CityAdapter(dataCity);
        recyclerView.setAdapter(cityAdapter);
        return cityAdapter;
    }

}
