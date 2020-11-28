package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

public class MainActivitySearch extends AppCompatActivity {
    private static final String TAG ="MyLog";
    public static final String WEATHER ="weather";
    private boolean isLandscape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final TextInputLayout cityLayout = findViewById(R.id.textInputLayout);
        final EditText city = cityLayout.getEditText();

        this.isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Snackbar snackInfo = Snackbar.make(v, "Идет поиск", Snackbar.LENGTH_LONG);
                snackInfo.show();
                    final Handler handler = new Handler();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final WeatherService.WeatherData weather = WeatherService.getWeather(city.getText().toString());
                                Log.i("XXX", weather.toString());

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        showInfo(weather);

                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                                Snackbar errorInfo = Snackbar.make(v, "Город не найден", Snackbar.LENGTH_LONG);
                                errorInfo.show();
                            }
                        }
                    }).start();
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

    private void showInfo(WeatherService.WeatherData weather) {
            Log.i(TAG, isLandscape +" is land");
            if(isLandscape) {
                DataFragment dataFragment = new DataFragment();
                Bundle bundle = new Bundle();
                 bundle.putParcelable(WEATHER, weather);
                dataFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, dataFragment).commit();

            } else {
                Intent intent = new Intent(MainActivitySearch.this, ActivityData.class);
                intent.putExtra(WEATHER, weather);
                startActivity(intent);
            }
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
