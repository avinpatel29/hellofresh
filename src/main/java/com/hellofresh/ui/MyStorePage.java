package com.hellofresh.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyStorePage extends PageBase {

    public MyStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='login']")
    private WebElement signIn_link;
    
    @FindBy(how = How.XPATH, using = "//input[@id='email_create']")
    private WebElement emailAddress_textfield;
    
    
    public void clickSignInLink() {
    	clickAndWait(signIn_link, emailAddress_textfield);
    }
    
   }
