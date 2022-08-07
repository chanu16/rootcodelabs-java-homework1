package com.rootcodelabs.java.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

public class LoginTestCases {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        //Create a browser driver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        //Create an instance of browser and assign to WebDriver
        driver = new ChromeDriver();

        //Navigate to URL
        driver.get("https://www.saucedemo.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //maximize the window
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod(){
        if(driver != null){
            driver.close();
        }

    }

    @AfterClass
    public void afterClass(){

    }

    //Valid Login Scenarios
    @Test
    public void testLoginValidCredentials(){

        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("login-button")).click();

        //Verify the outcome against the expected outcome
        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");

    }

    @Test
    public void testLoginValidCredentialsWithPressEnterKey(){

        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);


        //Verify the outcome against the expected outcome
        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");

    }

    //Invalid Login Scenarios

    //Assume that the Password is valid
    @Test
    public void testLoginWithInvalidUsername(){

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualError = driver.findElement(By.tagName("h3")).getText();

        //Verify the outcome against the expected outcome
        assertThat(actualError).isEqualTo(expectedError);
    }

    //Assume that the Username is valid
    @Test
    public void testLoginWithInvalidPassword(){

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();
        String actualError = driver.findElement(By.tagName("h3")).getText();

        //Verify the outcome against the expected outcome
        assertThat(actualError).isEqualTo(expectedError);

    }

    @Test
    public void testLoginWithBlankPassword(){

        String expectedError = "Epic sadface: Password is required";
        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String actualError = driver.findElement(By.tagName("h3")).getText();

        //Verify the outcome against the expected outcome
        assertThat(actualError).isEqualTo(expectedError);

    }

    @Test
    public void testLoginWithBlankUserName(){

        String expectedError = "Epic sadface: Username is required";
        //Actions
        //Type username, Type password, Click the Login button
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualError = driver.findElement(By.tagName("h3")).getText();

        //Verify the outcome against the expected outcome
        assertThat(actualError).isEqualTo(expectedError);

    }

}
