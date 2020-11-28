package com.example.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataFragment extends Fragment {
    private static final String WEB= "https://en.wikipedia.org/wiki/";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data,container,false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments != null) {
            WeatherService.WeatherData weatherData = arguments.getParcelable(MainActivitySearch.WEATHER);

            TextView city = view.findViewById(R.id.textView3);
            final String cityName = weatherData.getCity();
            city.setText(cityName);

            TextView temp= view.findViewById(R.id.textView4);
            final Integer tempInfo = weatherData.getTemp();
            temp.setText(tempInfo.toString());

            TextView speed= view.findViewById(R.id.textView5);
            final Integer speedInfo = weatherData.getSpeed();
            speed.setText(speedInfo.toString() + " m/s ");

            TextView himidity= view.findViewById(R.id.textView6);
            final Integer himidityInfo = weatherData.getHumidity();
            himidity.setText(himidityInfo.toString() + " % ");

            TextView pressure= view.findViewById(R.id.textView7);
            final Integer pressureInfo = weatherData.getPressure();
            pressure.setText(pressureInfo.toString());



            ImageButton buttonInfo = view.findViewById(R.id.imageButton);
            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String urlCity = WEB + cityName;
                    Uri uriCity = Uri.parse(urlCity);
                    Intent infoCity = new Intent(Intent.ACTION_VIEW, uriCity);
                    startActivity(infoCity);
                }
            });
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getContext(), "fragment - onActivityCreated",Toast.LENGTH_SHORT).show();

    }
}
