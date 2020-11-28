package com.example.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class WeatherService {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WEATHER_API_KEY = ",RU&appid=5b99611d6917246a2dd3e3f6469a6e8a";
    private static final int DELTA = 273;

    private static String info (String city) throws IOException {
        URL url = new URL(WEATHER_URL + city + WEATHER_API_KEY);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String collect = in.lines().collect(Collectors.joining("\n"));
        return collect;
    };

    public static WeatherData getWeather(String city) throws IOException {
        String info = info(city);
        Log.i(" XXX", info);
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(info).getAsJsonObject();
        JsonObject main = obj.get("main").getAsJsonObject();
        int temp = (int) (main.get("temp").getAsDouble() - DELTA);
        int tempMin = (int) (main.get("temp_min").getAsDouble() - DELTA);
        int tempMax = (int) (main.get("temp_max").getAsDouble() - DELTA);
        int pressure = (int) ((main.get("pressure").getAsDouble()) / 1.33322);
        int humidity = (int) (main.get("humidity").getAsDouble());
        JsonObject wind = obj.get("wind").getAsJsonObject();
        int speed = (int) (wind.get("speed").getAsDouble());

        return new WeatherData(city,temp,tempMin,tempMax,pressure,humidity,speed);
    }

    static class WeatherData implements Parcelable {
        private  String city;
        private  int temp;
        private  int tempMin;
        private  int tempMax;
        private  int pressure;
        private  int humidity;
        private  int speed;

        public WeatherData(Parcel in) {
            city = in.readString();
            int[] data = new int[6];
            in.readIntArray(data);
            temp = data[0];
            tempMin = data[1];
            tempMax = data[2];
            pressure = data[3];
            humidity = data[4];
            speed = data[5];
        }

        public String getCity() {
            return city;
        }

        public int getTemp() {
            return temp;
        }

        public int getTempMin() {
            return tempMin;
        }

        public int getTempMax() {
            return tempMax;
        }

        public int getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getSpeed() {
            return speed;
        }

        public WeatherData(String city, int temp, int tempMin, int tempMax, int pressure, int humidity, int speed) {
            this.city = city;
            this.temp = temp;
            this.tempMin = tempMin;
            this.tempMax = tempMax;
            this.pressure = pressure;
            this.humidity = humidity;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "WeatherData{" +
                    "city='" + city + '\'' +
                    ", temp=" + temp +
                    ", tempMin=" + tempMin +
                    ", tempMax=" + tempMax +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", speed=" + speed +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(city);
            dest.writeIntArray(new int[] {temp,tempMin,tempMax,pressure,humidity,speed});
        }

        public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>() {

            @Override
            public WeatherData createFromParcel(Parcel source) {
                return new WeatherData(source);
            }

            @Override
            public WeatherData[] newArray(int size) {
                return new WeatherData[size];
            }
        };
    }
}
