package com.example.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;
import java.util.TreeMap;

public class CityAdapter extends RecyclerView.Adapter <CityAdapter.ViewHolder> {
    private String[] dataCity;

    public CityAdapter(String [] dataCity) {
        this.dataCity = dataCity;
    }

    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_temper ,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.ViewHolder holder, int position) {
     holder.setData(dataCity[position]);
    }
    @Override
    public int getItemCount() {
        return dataCity.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= (TextView) itemView;
        }
        public void setData( String text){
            textView.setText(text);
        }
    }
}
