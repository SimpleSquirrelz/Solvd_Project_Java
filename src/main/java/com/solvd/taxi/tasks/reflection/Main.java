package com.solvd.taxi.tasks.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("SECRET FIELDS:");
        Arrays.stream(PrivateInformation.class.getDeclaredFields())
                .forEach(f -> System.out.println(f.getName()));

        System.out.println("\nSECRET METHODS:");
        Arrays.stream(PrivateInformation.class.getDeclaredMethods())
                .forEach(m -> System.out.println(m.getName()));

        var privateInformation = new PrivateInformation("Name", "Surname", "Username", "Pass", "I am banana");

        try {
            Method method = PrivateInformation.class.getDeclaredMethod("tellSecret");
            method.setAccessible(true);
            String secret = (String) method.invoke(privateInformation);
            System.out.println("\nI GOT YOUR SECRET: '" + secret + "'");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field field = PrivateInformation.class.getDeclaredField("password");
            field.setAccessible(true);
            String password = (String) field.get(privateInformation);
            System.out.println("\nEHEHEHEHHE HERE IS YOUR PASSWORD: " + password);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
