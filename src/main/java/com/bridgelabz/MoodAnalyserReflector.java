package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) throws MoodAnalyseException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_ACCESS, e);
        } catch (InvocationTargetException | InstantiationException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.OBJECT_CREATION_ISSUE, e);
        }
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


    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalyseException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_CLASS,
                    "Define Proper class name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD,
                    "Define Proper Method name");
        }
    }
}

