package com.e_commerce.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.utils.TestUtil;

public class AddToCart extends TestBase {

	public AddToCart() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']"
			+ "/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul["
			+ "@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	WebElement dresses;

	@FindBy(xpath = "//img[@title='Printed Dress']")
	WebElement selectedDress;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;

	@FindBy(xpath = "//a[@id='wishlist_button']")
	@CacheLookup
	WebElement wishListButton;

	@FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
	WebElement dismissWishListPopUp;

	@FindBy(xpath = "//i[@class='icon-plus']")
	@CacheLookup
	WebElement plusIcon;

	@FindBy(xpath = "//div[@id='page']//span[@class='cross']")
	@CacheLookup
	WebElement crossIcon;

	WebDriverWait wait2 = new WebDriverWait(driver, 20);

	public void clickDressesButton() {

		wait2.until(ExpectedConditions.visibilityOf(dresses));

		dresses.click();

	}

	public void clickSelectedDress() {

		Actions action = new Actions(driver);

		wait2.until(ExpectedConditions.visibilityOf(selectedDress));

		action.moveToElement(selectedDress).click().build().perform();

	}

	public void clickAddToWishListButton() {

		wishListButton.click();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		dismissWishListPopUp.click();

	}

	public void clickAddButton() {

		plusIcon.click();
	}

	public void addItemsToCart() {

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		addToCartButton.click();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();

		crossIcon.click();

	}

}
