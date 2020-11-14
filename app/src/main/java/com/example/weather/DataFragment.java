package com.example.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
            final String cityName = arguments.getString("cityName");

            TextView city = view.findViewById(R.id.textView3);
            city.setText(cityName);

            ImageButton buttonInfo = view.findViewById(R.id.imageButton);
            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String urlCity = "https://en.wikipedia.org/wiki/" + cityName;
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
