package com.e_commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e_commerce.qa.base.TestBase;

public class SignIn extends TestBase {
	


	public SignIn() {
		super();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	@CacheLookup
	WebElement signInButton;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	@CacheLookup
	WebElement storeLogo;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement userName;

	@FindBy(name = "passwd")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//p[@class='submit']//span[1]")
	@CacheLookup
	WebElement submitButton;

	public String loginPageTitle() {

		String pageTitle = driver.getTitle();

		return pageTitle;
	}

	public void clickSignInButton() {

		signInButton.click();

	}

	public boolean verifyStoreLogo() {

		return storeLogo.isDisplayed();
	}

	public HomePage Submit(String uName, String uPassword) {

		userName.sendKeys(uName);
		password.sendKeys(uPassword);

		submitButton.click();

		return new HomePage();

	}
}
