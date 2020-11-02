package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivitySearch extends AppCompatActivity {
    private static final String TAG ="MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info.getInstance().setDegrees((int) (Math.random()*30));
                startActivity(new Intent(MainActivitySearch.this, ActivityData.class));


            }
        });
        ImageButton buttonSetting = findViewById(R.id.imageButton6);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivitySearch.this, ActivitySettings.class));

            }
        });
        Toast.makeText(getApplicationContext(), "onCreate",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onRestart");
    }

}
