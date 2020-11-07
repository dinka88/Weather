package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
        TextView city = findViewById(R.id.textView3);
        final String cityName = getIntent().getExtras().getString("cityName");
        city.setText(cityName);

        ImageButton buttonInfo = findViewById(R.id.imageButton);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlCity= "https://en.wikipedia.org/wiki/"+cityName;
                Uri uriCity= Uri.parse(urlCity);
                Intent infoCity = new Intent(Intent.ACTION_VIEW, uriCity);
                startActivity(infoCity);
            }
        });

        ImageButton buttonSetting = findViewById(R.id.imageButton6);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityData.this, ActivitySettings.class));
            }
        });

    }

}
