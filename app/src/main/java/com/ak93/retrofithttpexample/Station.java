package com.ak93.retrofithttpexample;

import java.util.List;

/**
 * Created by Anže Kožar on 19.11.2016.
 */

public class Station {
    int number;
    String name;
    List<Bus> buses;

    @Override
    public String toString() {
        return String.valueOf(number)+" - "+name+" #buses: "+buses.size();
    }
}
