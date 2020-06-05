package com.rockets.app.domain;

public class Strategy {

    public static double decideAction(int currentTime, double length, double maxTime) {
        if (currentTime == 0)
            return length / maxTime;
        else if (currentTime < 5) {
            return 12;
        }
        return 0;
    }
}