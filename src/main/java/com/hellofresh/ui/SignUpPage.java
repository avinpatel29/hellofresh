package com.hellofresh.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage extends PageBase {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    
    @FindBy(how = How.XPATH, using = "//div[@class='clearfix']//div[1]//label[1]")
    private WebElement radioButton_Mr;
    
    @FindBy(how = How.XPATH, using = "//div[@class='clearfix']//div[2]//label[1]")
    private WebElement radioButton_Mrs;

    @FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']")
    private WebElement firstName_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']")
    private WebElement lastName_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement email_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement password_textfield;
    
    @FindBy(how = How.XPATH, using = "//select[@id='days']")
    private WebElement DOB_day_dropdown;
    
    @FindBy(how = How.XPATH, using = "//select[@id='months']")
    private WebElement DOB_month_dropdown;
    
    @FindBy(how = How.XPATH, using = "//select[@id='years']")
    private WebElement DOB_year_dropdown;
    
    @FindBy(how = How.XPATH, using = "//input[@id='company']")
    private WebElement copmany_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='address1']")
    private WebElement address1_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='address2']")
    private WebElement address2_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='city']")
    private WebElement city_textfield;
    
    @FindBy(how = How.XPATH, using = "//select[@id='id_state']")
    private WebElement state_dropdown;
    
    @FindBy(how = How.XPATH, using = "//input[@id='postcode']")
    private WebElement zipcode_textfield;
    
    @FindBy(how = How.XPATH, using = "//select[@id='id_country']")
    private WebElement country_dropdown;
    
    @FindBy(how = How.XPATH, using = "//textarea[@id='other']")
    private WebElement additionalInformation_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='phone']")
    private WebElement homePhone_textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']")
    private WebElement mobilePhone_textfield;
  
    @FindBy(how = How.XPATH, using = "//input[@id='alias']")
    private WebElement addressAlias_textfield;
    
    @FindBy(how = How.XPATH, using = "//button[@id='submitAccount']")
    private WebElement register_button;
    
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading']")
    private WebElement myAccount_text;
    
    
    public void selectTitle(String title) {
    	if(title.equalsIgnoreCase("mr"))
    		click(radioButton_Mr);
    	else if(title.equalsIgnoreCase("mrs"))
    		click(radioButton_Mrs);
    }
    
    public void enterFirstName(String firstName) {
    	inputText(firstName_textfield, firstName);
    }
    
    public void enterLastName(String lasttName) {
    	inputText(lastName_textfield, lasttName);
    }

    public void enterPassword(String password) {
    	inputText(password_textfield, password);
    }
    
    public void selectDOB(String day,String month, String year) {
    	selectByValueFromTheDropdown(DOB_day_dropdown, day);
    	selectByValueFromTheDropdown(DOB_month_dropdown, month);
    	selectByValueFromTheDropdown(DOB_year_dropdown, year);
    }
    
    public void enterCompany(String companyName) {
    	inputText(copmany_textfield, companyName);
    }
    
    public void enterAddress(String address1, String address2) {
    	inputText(address1_textfield, address1);
    	inputText(address2_textfield, address2);
    }
    
    public void enterCity(String cityName) {
    	inputText(city_textfield, cityName);
    }
    
    public void selectState(String stateName) {
    	selectByVisibleTextFromTheDropdown(state_dropdown, stateName);
    }
    
    public void enterZipcode(String zipcode) {
    	inputText(zipcode_textfield, zipcode);
    }
    
    public void selectCountry(String countryName) {
    	inputText(country_dropdown, countryName);
    }
    
    public void enterAdditionalInformation(String additionalInfo) {
    	inputText(additionalInformation_textfield, additionalInfo);
    }
    
    public void enterHomePhone(String homePhone) {
    	inputText(homePhone_textfield, homePhone);
    }
    
    public void enterMobilePhone(String mobilePhone) {
    	inputText(mobilePhone_textfield, mobilePhone);
    }
    
    public void enterAlias(String alias) {
    	inputText(addressAlias_textfield, alias);
    }
    
    public void clickRegisterButton() {
    	clickAndWait(register_button, myAccount_text);
    }	
    
}
