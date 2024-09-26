package com.ayalamac.challenge1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ayalamac.challenge1.helpers.CommonXpathDefinitions;
import com.ayalamac.challenge1.helpers.RegisterPageValues;
import com.ayalamac.challenge1.helpers.RegisterPageXpathDefinitions;
import com.ayalamac.challenge1.helpers.Urls;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterAndLoginTest {

    WebDriver driver;

    @BeforeEach
    public void RunBeforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestRegisterAndFirstLogin() {
        // * ARRANGE
        driver.get(Urls.homePage);

        // * ACT
        // Click on Sign In, then click on Create Account
        WebElement anchorSignIn = driver.findElement(By.xpath(CommonXpathDefinitions.anchorSignIn));
        anchorSignIn.click();

        WebElement anchorCreateAccount = driver.findElement(By.xpath(CommonXpathDefinitions.anchorCreateAccount));
        anchorCreateAccount.click();

        // Fill the form
        WebElement radioInputMale             = driver.findElement(By.xpath(RegisterPageXpathDefinitions.male));
        WebElement inputFirstName             = driver.findElement(By.xpath(RegisterPageXpathDefinitions.firstName));
        WebElement inputLastName              = driver.findElement(By.xpath(RegisterPageXpathDefinitions.lastName));
        WebElement inputEmail                 = driver.findElement(By.xpath(RegisterPageXpathDefinitions.email));
        WebElement inputPassword              = driver.findElement(By.xpath(RegisterPageXpathDefinitions.password));
        WebElement inputBirthdate             = driver.findElement(By.xpath(RegisterPageXpathDefinitions.birthdate));
        WebElement checkboxTermsAndConditions = driver.findElement(By.xpath(RegisterPageXpathDefinitions.termsAndConditions));
        WebElement buttonSave                 = driver.findElement(By.xpath(RegisterPageXpathDefinitions.save));

        radioInputMale.click();
        inputFirstName.sendKeys(RegisterPageValues.firstName);
        inputLastName.sendKeys(RegisterPageValues.lastName);
        inputEmail.sendKeys(RegisterPageValues.email);
        inputPassword.sendKeys(RegisterPageValues.password);
        inputBirthdate.sendKeys(RegisterPageValues.birthdate);
        checkboxTermsAndConditions.click();
        buttonSave.click();

        // * ASSERT
        WebElement spanFullName = driver.findElement(By.xpath(CommonXpathDefinitions.spanFullName));
        assertEquals(RegisterPageValues.GetFullName(), spanFullName.getText());

        // * EXTRA
        // Log out
        WebElement anchorSignOut = driver.findElement(By.xpath(CommonXpathDefinitions.anchorSignOut));
        anchorSignOut.click();
    }

   @AfterEach
   public void RunAfterEach() {
       driver.close();
   }
}
