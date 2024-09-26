package com.spbpatino.challenge2.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UseCaseXpathDefinitions {
    public static final String anchorInputUser = "//div[@class='login_wrapper-inner']//input[@data-test='username']";
    public static final String anchorInputPassword = "//div[@class='login_wrapper-inner']//input[@data-test='password']";
    public static final String anchorButtonLogin = "//div[@class='login_wrapper-inner']//input[@data-test='login-button']";
    public static final String anchorButtonFirstProduct = "//div[@data-test='inventory-item-description']//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']/ancestor::div[@data-test='inventory-item-description']//button[@data-test='add-to-cart-sauce-labs-backpack']";
    public static final String anchorButtonSecondProduct = "//div[@data-test='inventory-item-description']//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']/ancestor::div[@data-test='inventory-item-description']//button[@data-test='add-to-cart-sauce-labs-bike-light']";
    public static final String anchorButtonShoppingCart = "//div[@data-test='primary-header']//a[@data-test='shopping-cart-link']";
    public static final String anchorButtonCheckout = "//div[@class='cart_footer']//button[@data-test='checkout']";
    public static final String anchorInputFirstName = "//div[@class='checkout_info']//input[@data-test='firstName']";
    public static final String anchorInputLastName = "//div[@class='checkout_info']//input[@data-test='lastName']";
    public static final String anchorInputPostalCode = "//div[@class='checkout_info']//input[@data-test='postalCode']";
    public static final String anchorButtonCheckoutContinue = "//div[@class='checkout_buttons']//input[@data-test='continue']";
    public static final String anchorTextFirstProductPrice = "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']/ancestor::div[@data-test='inventory-item']//div[@data-test='inventory-item-price']";
    public static final String anchorTextSecondProductPrice = "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']/ancestor::div[@data-test='inventory-item']//div[@data-test='inventory-item-price']";
    public static final String anchorTextItemTotal = "//div[@class='summary_info']//div[@data-test='subtotal-label']";
    public static final String anchorTextTatalTax = "//div[@class='summary_info']//div[@data-test='tax-label']";
    public static final String anchorTextTotal = "//div[@class='summary_info']//div[@data-test='total-label']";
    public static final String anchorButtonFinishCheckout = "//div[@class='cart_footer']//button[@data-test='finish']";
    public static final String anchorImgComplete = "//div[@data-test='checkout-complete-container']//img[@data-test='pony-express']";
    public static final String anchorAlt = "alt";

}
