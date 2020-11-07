package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivitySearch extends AppCompatActivity {
    private static final String TAG ="MyLog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final EditText city = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo(city);
            }
        });
        city.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && (keyCode== KeyEvent.KEYCODE_ENTER ))
                {
                    showInfo(city);
                    return true;
                }


                return false;
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

    private void showInfo(EditText city) {
        final String nameCity = city.getText().toString();
        Info.getInstance().setDegrees((int) (Math.random()*30));
        Intent intent = new Intent(MainActivitySearch.this, ActivityData.class);
        intent.putExtra("cityName",nameCity);
        startActivity(intent);
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
