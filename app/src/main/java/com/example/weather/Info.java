package com.example.weather;

public final class Info {
    private static Info instance= null;
    public static Object mon= new Object();

    public int degrees;

    private Info() {
        int degrees = 0;
    }
    public static Info getInstance (){
        synchronized (mon){
            if (instance== null){
                instance= new Info();
            }
        }
        return instance;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }
}
