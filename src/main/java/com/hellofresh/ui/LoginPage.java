package com.hellofresh.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(how = How.XPATH, using = "//input[@id='email_create']")
    private WebElement emailAddress_textfield;
    
    @FindBy(how = How.XPATH, using = "//form[@id='create-account_form']//span[1]")
    private WebElement createAnAccount_button;
    
    @FindBy(how = How.XPATH, using = "//div[@class='clearfix']//div[2]//label[1]")
    private WebElement radioButton_Mrs;
    
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement emailId_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement password_textfield;
    
    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
    private WebElement signIn_button;
    
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading']")
    private WebElement myAccount_text;
    
    
    public void enterEmailAddress(String emailId) {
    	inputText(emailAddress_textfield, emailId);
    }
    
    public void clickCreateAccountButton() {
    	clickAndWait(createAnAccount_button, radioButton_Mrs);
    }
    
    public void createAnAccount(String emailId) {
    	enterEmailAddress(emailId);
    	clickCreateAccountButton();
    }
    
    public void login(String email, String password) {
    	enterLoginEmailAddress(email);
    	enterPassword(password);
    	clickSignInButton();
    		
    }

	private void clickSignInButton() {
		clickAndWait(signIn_button, myAccount_text);
		
	}

	private void enterPassword(String password) {
		// TODO Auto-generated method stub
		inputText(password_textfield, password);
	}

	private void enterLoginEmailAddress(String email) {
		// TODO Auto-generated method stub
		inputText(emailId_textfield, email);
	}
        
}
