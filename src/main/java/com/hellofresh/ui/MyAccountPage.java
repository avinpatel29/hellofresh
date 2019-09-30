package com.hellofresh.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends PageBase {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
   Actions action = new Actions(driver);
   JavascriptExecutor js = (JavascriptExecutor)driver;
    
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading']")
    private WebElement myAccount_text;
    
    @FindBy(how = How.XPATH, using = " //*[@class='account']")
    private WebElement accountName;
  
    @FindBy(how = How.XPATH, using = "//p[@class='info-account']")
    private WebElement accountInfo;
    
    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement signout_link;
    
    @FindBy(how = How.XPATH, using = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    private WebElement women_link;
    
    @FindBy(how = How.XPATH, using = "//ul[@class='product_list grid row']")
    private WebElement item_list;
  
    @FindBy(how = How.XPATH, using = "//*[@name='Submit']")
    private WebElement addToCart_button;
    
    @FindBy(how = How.XPATH, using = "//*[@id='layer_cart']//*[@class and @title='Proceed to checkout']")
    private WebElement proceedToCheckout_button;
    
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'cart_navigation')]/*[@title='Proceed to checkout']")
    private WebElement shoppingcartSummary_proceedToCheckout_button;
    
    @FindBy(how = How.XPATH, using = "//*[@name='processAddress']")
    private WebElement address_proceedToCheckout_button;
    
    @FindBy(how = How.XPATH, using = "//*[@id='uniform-cgv']")
    private WebElement TandC_checkbox;
  
    @FindBy(how = How.XPATH, using = "//*[@name='processCarrier']")
    private WebElement shipping_proceedToCheckout_button;
    
    @FindBy(how = How.XPATH, using = "//a[@class='bankwire']")
    private WebElement payByBankWire_option;
    
    @FindBy(how = How.XPATH, using = "//*[@id='cart_navigation']/button")
    private WebElement iConfirmMyOrder_Button;
    
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading']")
    private WebElement orderConfirmation_text;
    
    @FindBy(how = How.XPATH, using = "//li[@class='step_done step_done_last four']")
    private WebElement shippingStep;
    
    @FindBy(how = How.XPATH, using = "//li[@id='step_end' and @class='step_current last']")
    private WebElement paymentStep;

    @FindBy(how = How.XPATH, using = "//*[@class='cheque-indent']/strong")
    private WebElement orderIsCompleteText;
 
    public String myAccountText() {
    	return getText(myAccount_text);
    }
    
    public String myAccountInfo() {
    	return getText(accountInfo);
    }
    
    public String getAccountName() {
    	return getText(accountName);
    }
    public boolean isSignoutLinkDisplayed() {
    	return isElementPresent(signout_link);
    }

	public void clickWomenCategory() {
		clickAndWait(women_link, item_list);
	}
	
	public void selectDress(String dressName) {
		waitForPageToLoad();		
		driver.findElement(By.xpath("//*[@class='product-container']//*[contains(text(),'"+dressName+"')]")).click();		
	}
	
	public void addToCart() {
		clickAndWait(addToCart_button, proceedToCheckout_button);
	}
	
	public void clickProceedToCheckoutButton() {
		clickAndWait(proceedToCheckout_button, shoppingcartSummary_proceedToCheckout_button);
	}
    
	public void clickProceedToCheckoutButton_ShoppingCartSummary() {
		waitForPageToLoad();
		clickAndWait(shoppingcartSummary_proceedToCheckout_button, address_proceedToCheckout_button);
	}
	
	public void clickProceedToCheckoutButton_Addresses() {
		waitForPageToLoad();
		clickAndWait(address_proceedToCheckout_button, TandC_checkbox);
	}
	
	public void checkTandCCheckbox(){
		click(TandC_checkbox);
		clickAndWait(shipping_proceedToCheckout_button, payByBankWire_option);
	}
	
	public void payByBanWireOption() {
		clickAndWait(payByBankWire_option, iConfirmMyOrder_Button);
	}
	
	public void clickIConfirmMyOrderButton() {
		clickAndWait(iConfirmMyOrder_Button, orderIsCompleteText);
	}
	
	public String getTextOrderConfirmation() {
		return getText(orderConfirmation_text);
	}
	
	public boolean isShippingStepDisplayed() {
		return isElementPresent(shippingStep);
	}
	
	public boolean isPaymentStepDisplayed() {
		return isElementPresent(paymentStep);
	}
	
	public String getTextOrderIsCompleteText() {
		return getText(orderIsCompleteText);
	}
}
