package com.example.assign1cmput301;

import android.widget.Button;

import java.time.LocalDate;
import java.time.LocalTime;

// The EmoticonBTN class is a simple class that stores the type of the emotions button as it's constructor
// It is set as constructor rather than using setType method to ensure the object always has a type.
// The central important method of this class is getEmotionData which returns the String Array that is
// to be stored in the Log class. It also provides getEmotionText which is used to return String
// that is to be displayed as a Toast when the individual buttons are clicked. This is to confirmation
// to the user that the button has been clicked.

public class EmoticonBTN {
    private String type;

    public EmoticonBTN(String type) {
        this.type = type;
    }

    public String getEmotionText() {
        String[] data = this.getEmotionData();
        return "You clicked on " + type + " on " + data[1] + " " + data[2];
    }

    public String[] getEmotionData() {
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString().substring(0, 5);

        String[] logData = {type, date, time};
        return logData;
    }
}
