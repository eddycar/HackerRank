package org.example;

public class ConvertionToMilitarTime {
    public static  String timeConversion(String s) {
        // Write your code here
        String[] timeArr = s.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        int second = Integer.parseInt(timeArr[2].substring(0,2));
        String Meridiem = timeArr[2].substring(2);

        if(Meridiem.equals("AM")){
            if(hour == 12){
                hour = 0;
            }
        }else{
            if(hour != 12){
                hour += 12;
            }
        }

        return String.format("%02d:%02d:%02d", hour, minute, second);

    }
}
