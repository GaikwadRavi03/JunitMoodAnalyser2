package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyseException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser1");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
