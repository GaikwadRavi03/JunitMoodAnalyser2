package com.bridgelabz;

public class MoodAnalyser {

    private static String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static String analyseMood() {

        if (message.contains("SAD")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
