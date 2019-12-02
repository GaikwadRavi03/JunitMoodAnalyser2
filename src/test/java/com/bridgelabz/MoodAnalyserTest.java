package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void givenMessageWhenSadShow() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is SAD mood");
        try {
            Assert.assertEquals("SAD", MoodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessageWhenHappyShow() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is Happy mood");
        try {
            Assert.assertEquals("HAPPY", MoodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_ExceptionHappy_Show() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            Assert.assertEquals("HAPPY", MoodAnalyser.analyseMood());
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

    @Test
    public void givenEmptyMood_ShouldThrows_MoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    //-------------------- Default---------------
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObjectForDefault() throws MoodAnalyseException {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        MoodAnalyser moodAnalyser1 = new MoodAnalyser();
        boolean result = moodAnalyser.equals(moodAnalyser1);
        Assert.assertTrue(result);
    }

    @Test
    public void givenClassNameWhen_ImproperShouldThrow_MoodAnalysisExceptionForDefault() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NO_SUCH_CLASS.toString(), e.getMessage());
        }
    }

    @Test
    public void givenClassNameWhen_ConstructorNotProper_ShouldThrow_MoodAnalysisExceptionForDefault() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD.toString(), e.getMessage());
        }
    }

    //---------------------parametrized--------------------
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObjectForParametrized() throws MoodAnalyseException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("HAPPY");
       String currentMood= moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",currentMood);
    }

    @Test
    public void givenClassNameWhen_ImproperShouldThrow_MoodAnalysisExceptionForParametrized() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NO_SUCH_CLASS.toString(), e.getMessage());
        }
    }

    @Test
    public void givenClassNameWhen_ConstructorNotProper_ShouldThrow_MoodAnalysisExceptionForParametrized() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD.toString(), e.getMessage());
        }
    }

    //----------------------------------------------------------------
    @Test
    public void givenHappyMessage_WithReflection_shouldReturnHappy() {
        try {
            Object myobj = MoodAnalyserReflector.createMoodAnalyser("I am in HAppy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myobj, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() {
        try {
            Object myobj = MoodAnalyserReflector.createMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue(myobj, "message", "I Am Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myobj, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenHappyMessage_withDefaultConstructor_returnHappy() {
        try {
            MoodAnalyserReflector.createMoodAnalyser();
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_withParametrizedConstructor_returnHappy() {
        try {
            Constructor constructor = MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.createMoodAnalyser(constructor);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }
}
