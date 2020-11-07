package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        ImageButton buttonSetting = findViewById(R.id.imageButton6);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityData.this, ActivitySettings.class));
            }
        });

    }

}
