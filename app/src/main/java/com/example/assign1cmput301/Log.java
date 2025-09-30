package com.example.assign1cmput301;

import java.time.LocalDate;
import java.util.ArrayList;

// The Log class stores an String array each containing type, date and time
// inside an ArrayList. It will get the daily summaries with the emotions count and
// the log text all combined appended to a StringBuilder class which is
// converted to a String and returned which is displayed using SafeArgs the second fragment screen.
// All log and daily summaries can be modified on this class with all the methods being used by the class itself.
// Each String Array inside in ArrayList is in [type, date, time] format with extensive use of date[0] and date[1]
// to retrieve the type and date.

// getLog is the central method that returns the final output String to be passed by SafeArgs and displayed,
// The getLog first calls and appends the String returned by getDailySummary which uses countEmotions method
// to count all the emotions that occurred today. The log ues addData method to add all the String Arrays.
public class Log {
    private final ArrayList<String[]> logData = new ArrayList<>();

    public void addData(String[] data) {
        logData.add(data);
    }

    public String getLogData(int i) {
        String[] data = logData.get(i);
        return "         " + data[0] + ": " + data[2];
    }

    public int countEmotions(String type, String date) {
        int count = 0;
        for (String[] data : logData) {
            if ((data[0].equals(type)) && (data[1].equals(date))) {
                count++;
            }
        }
        return count;
    }

    public String getDailySummary() {
        String today = LocalDate.now().toString();
        StringBuilder summary = new StringBuilder();
//        summary.setLength(0);
        summary.append("Today's Daily Summary\n");

        ArrayList<String> currentEmotions = new ArrayList<>();
        for (String[] data : logData) {
            if ((!currentEmotions.contains(data[0])) && (data[1].equals(today))) {
                currentEmotions.add(data[0]);
                summary.append("    Your ")
                        .append(data[0])
                        .append(" level is ")
                        .append(Integer.toString(countEmotions(data[0], today)))
                        .append("\n");
            }
        }
        if (currentEmotions.isEmpty()) {
            return "You haven't added any emotions today :<\n\nAdd emotions on the main screen to see your daily summary :>";
        }
        return summary.toString();
    }
    
    public String getLog() {
        StringBuilder logTextToSend = new StringBuilder();
        logTextToSend.append(getDailySummary()).append("\n");

        String currentDate = "";
        for (int i = logData.size() - 1; i >= 0; i--) {
            String[] currentLog = logData.get(i);
            if (!currentDate.equals(currentLog[1])) {
                logTextToSend.append(currentLog[1]).append("\n");
                currentDate = currentLog[1];
            }
            logTextToSend.append(this.getLogData(i)).append("\n");
        }
        return logTextToSend.toString();
    }

}
