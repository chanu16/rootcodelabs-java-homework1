package com.rootcodelabs.java.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class BrowserTesting {

    public static final String URL =  "https://www.saucedemo.com/";

    @Test
    public void testInChrome(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");
        driver.close();
    }

    @Test
    public void testInFireFox(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");
        driver.close();
    }

    @Test
    public void testInEdge(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get(URL);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");
        driver.close();
    }

    @Test
    public void testInOpera(){
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        driver.get(URL);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        assertThat(actualTitle).isEqualTo("PRODUCTS");
        driver.close();
    }
}
