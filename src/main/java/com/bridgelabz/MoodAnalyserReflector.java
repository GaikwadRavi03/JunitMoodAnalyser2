package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyseException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalyseException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(Object.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD);
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObj, String methodName) throws MoodAnalyseException {
        try {
            return moodAnalyserObj.getClass().getMethod(methodName).invoke(moodAnalyserObj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD,
                    "Define Proper Method name");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "May be issue with data entered");
        }
    }

    public static void setFieldValue(Object myobj, String fieldName, String fieldValue) throws MoodAnalyseException {
        try {
            Field field = myobj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myobj, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_FIELD,
                    "Define proper field name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_ACCESS,
                    "May be issue with access");
        }
    }
}

