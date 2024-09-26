package com.ayalamac.challenge1.helpers;

public class RegisterPageValues {
    public static final String firstName = "Andrés";
    public static final String lastName  = "Ayala";
    public static final String email     = "amayalac-" + GetTimestamp() + "@eafit.edu.co";
    public static final String password  = "Esp24.@34f1t*";
    public static final String birthdate = "12/20/1983";

    public static String GetTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String GetFullName() {
        return RegisterPageValues.firstName + " " + RegisterPageValues.lastName;
    }
}
