package com.ayalamac.challenge1.helpers;

public class RegisterPageXpathDefinitions {
    public static final String male               = "//form[@id = 'customer-form']/descendant::input[@type ='radio' and @value = 1]";
    public static final String firstName          = "//form[@id = 'customer-form']/descendant::input[@name = 'firstname']";
    public static final String lastName           = "//form[@id = 'customer-form']/descendant::input[@name = 'lastname']";
    public static final String email              = "//form[@id = 'customer-form']/descendant::input[@name = 'email' and @type = 'email']";
    public static final String password           = "//form[@id = 'customer-form']/descendant::input[@name = 'password' and @type = 'password']";
    public static final String birthdate          = "//form[@id = 'customer-form']/descendant::input[@name = 'birthday']";
    public static final String termsAndConditions = "//form[@id = 'customer-form']/descendant::input[@type = 'checkbox' and @name = 'psgdpr' and @required]";
    public static final String save               = "//form[@id = 'customer-form']/descendant::button[@type = 'submit' and @data-link-action = 'save-customer']";
}
