package com.ayalamac.challenge1.helpers;

public class CommonXpathDefinitions {
    public static final String anchorSignIn        = "//*[@class = 'header-nav']/descendant::div[@class = 'user-info']/a[contains(@title, 'Log in')]";
    public static final String anchorCreateAccount = "//*[@class = 'login-form']//following-sibling::*[@class='no-account']/descendant::a[contains(@href, '=registration')]";
    public static final String spanFullName        = "//*[@class = 'user-info']//a[@class = 'account']/span";
    public static final String anchorSignOut       = "//*[@class = 'user-info']/a[contains(@class, 'logout')]";
}
