package com.hellofresh.ui;

import org.openqa.selenium.WebDriver;


public class PageContainer {

    public WebDriver driver;
    public MyStorePage myStorePage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public MyAccountPage myAccountPage;

    /**
     * Constructor of the class
     *
     * @param driver WebDriver
     */
    public PageContainer(WebDriver driver) {
        this.driver = driver;
        initPages();
    }

    /**
     * Intialise & use the methods implemented in the pages
     */
    public void initPages() {
        myStorePage = new MyStorePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage= new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
       
    }

}
