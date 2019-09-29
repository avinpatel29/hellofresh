package com.hellofresh;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Date;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;
import com.hellofresh.ui.TestBaseUI;

public class UI_Tests extends TestBaseUI implements ITestNGListener {
	String timestamp = String.valueOf(new Date().getTime());
    String emailId = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";

    @Test(priority = 1, description="Sign up a new customer")
    public void signInTest() throws ConfigurationException {
        container.myStorePage.clickSignInLink();
        container.loginPage.createAnAccount(emailId);
        container.signUpPage.selectTitle(data.get("title"));
        container.signUpPage.enterFirstName(data.get("firstName"));
        container.signUpPage.enterLastName(data.get("lastName"));
        container.signUpPage.enterPassword(data.get("password"));
        container.signUpPage.selectDOB(data.get("DOB").split("/")[0],data.get("DOB").split("/")[1],data.get("DOB").split("/")[2]);
        container.signUpPage.enterCompany(data.get("company"));
        container.signUpPage.enterAddress(data.get("address1"), data.get("address2"));
        container.signUpPage.enterCity(data.get("city"));
        container.signUpPage.selectState(data.get("state"));
        container.signUpPage.enterZipcode(data.get("zipcode"));
        container.signUpPage.enterAdditionalInformation(data.get("addInfo"));
        container.signUpPage.enterHomePhone(data.get("homePhone"));
        container.signUpPage.enterMobilePhone(data.get("mobilePhone"));
        container.signUpPage.enterAlias(data.get("alias"));
        container.signUpPage.clickRegisterButton();
        
        Assert.assertEquals(container.myAccountPage.myAccountText(), "MY ACCOUNT");
        Assert.assertTrue(container.myAccountPage.myAccountInfo().contains("Welcome to your account."));
        Assert.assertTrue(container.myAccountPage.isSignoutLinkDisplayed());
        Assert.assertTrue(container.myAccountPage.getCurrentURL().contains("controller=my-account"));
    }

    @Test(priority = 2, description="Testcase to login with existing created customer credentials")
    public void logInTest() throws ConfigurationException {
    	container.myStorePage.clickSignInLink();
    	container.loginPage.login(data.get("email"), data.get("password"));
    	
    	Assert.assertEquals(container.myAccountPage.myAccountText(), "MY ACCOUNT");
    	Assert.assertEquals(container.myAccountPage.getAccountName(),"Joe Black");
        Assert.assertTrue(container.myAccountPage.myAccountInfo().contains("Welcome to your account."));
        Assert.assertTrue(container.myAccountPage.isSignoutLinkDisplayed());
        Assert.assertTrue(container.myAccountPage.getCurrentURL().contains("controller=my-account"));
    }

    @Test(priority = 3, description="Testcase to check conditions on every job profile")
    public void checkoutTest() throws ConfigurationException {
    	container.myStorePage.clickSignInLink();
    	container.loginPage.login(data.get("email"), data.get("password"));
    	
    	container.myAccountPage.clickWomenCategory();
    	container.myAccountPage.selectDress(data.get("dressName"));
    	container.myAccountPage.addToCart();
    	container.myAccountPage.clickProceedToCheckoutButton();
    	container.myAccountPage.clickProceedToCheckoutButton_ShoppingCartSummary();
    	container.myAccountPage.clickProceedToCheckoutButton_Addresses();
    	container.myAccountPage.checkTandCCheckbox();
    	container.myAccountPage.payByBanWireOption();
    	container.myAccountPage.clickIConfirmMyOrderButton();
    	
    	assertEquals(container.myAccountPage.getTextOrderConfirmation(),"ORDER CONFIRMATION");
        assertTrue(container.myAccountPage.isShippingStepDisplayed());
        assertTrue(container.myAccountPage.isPaymentStepDisplayed());
        assertTrue(container.myAccountPage.getTextOrderIsCompleteText().contains("Your order on My Store is complete."));
        assertTrue(container.myAccountPage.getCurrentURL().contains("controller=order-confirmation"));
    	
    }
    
    
}
