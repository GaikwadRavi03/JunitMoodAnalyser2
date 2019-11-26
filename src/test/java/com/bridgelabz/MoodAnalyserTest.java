package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

    @Test
    public void givenMessageWhenSadShow() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is SAD mood");
        try {
            Assert.assertEquals("SAD",MoodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessageWhenHappyShow() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is Happy mood");
        try {
            Assert.assertEquals("HAPPY",MoodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_ExceptionHappy_Show() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            Assert.assertEquals("HAPPY",MoodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMood_ShouldThrows_MoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_NULL, e.type);
        }
    }
}
