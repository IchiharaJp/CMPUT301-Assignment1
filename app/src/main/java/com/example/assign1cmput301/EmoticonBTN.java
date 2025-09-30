package com.example.assign1cmput301;

import android.widget.Button;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmoticonBTN {
    private int ID;
    private String type;

    public EmoticonBTN(int ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public String getLogText() {
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString().substring(0, 5);
        return "You clicked on " + type + " on " + date + " " + time;
    }
}
