package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.saucedemo.com/
public class Page {
    @FindBy(css = "input[id='user-name']")
    public WebElement inputUsername;

    @FindBy(css = "input[id='password']")
    public WebElement inputPassword;

    By user = By.cssSelector("input[id='user-name']");
    By pass = By.cssSelector("input[id='password']");

    By logo = By.xpath("//div[@class='header_secondary_container']");

    @FindBy(xpath = "//div[@class='header_secondary_container']")
    public WebElement div;

    @BeforeAll
    public static void setUpAll() {
        //  WebDriverRunner.setWebDriver(new EdgeDriver());

        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void intial() {

        //  WebDriver driver = WebDriverRunner.getWebDriver();
        open("https://www.saucedemo.com/");
    }

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverRunner.getWebDriver();
        //      open("https://www.saucedemo.com/");

        $(user).setValue("standard_user");
        $(pass).setValue("secret_sauce").pressEnter();
        System.out.println("Boomer");
        Thread.sleep(3000);
        $(logo).shouldBe(Condition.text("Products"));

    }


    public void teardown() {
        closeWebDriver();
    }


}