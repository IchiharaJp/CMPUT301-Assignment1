package com.example.assign1cmput301;

import java.util.ArrayList;

public class Log {
    private ArrayList<String> logData = new ArrayList<>();
    
    public void addData(String data) {
        logData.add(data);
    }
    
    public String getLogData() {
        String logTextToSend = "";
        for (int i = logData.size() - 1; i >= 0; i--) {
            logTextToSend += ( logData.get(i) + "\n" );
        }
        return logTextToSend;
    }
    
}
