package com.e_commerce.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.utils.TestUtil;

public class HomePage extends TestBase {

	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Manvir Singh']")
	WebElement userName;

	@FindBy(xpath = "//i[@class='icon-home']")
	WebElement homeIcon;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement viewShoppingCart;

	public boolean verifyUserName() {

		return userName.isDisplayed();
	}

	public boolean verifyHomeIcon() {

		return homeIcon.isDisplayed();
	}

	public void shoppingCartItems() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(viewShoppingCart).click().build().perform();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
