package com.bridgelabz;

public class MoodAnalyser {

    private static String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static String analyseMood() throws MoodAnalyseException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.ENTERED_EMPTY, "Please enter proper mood");
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.ENTERED_NULL, "Please enter proper mood");
        }
    }

    public boolean equals(Object another) {
        if (another instanceof MoodAnalyser)
            return true;
        return false;
    }
}
