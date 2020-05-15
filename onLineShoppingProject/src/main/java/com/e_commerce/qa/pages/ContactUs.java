package com.e_commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e_commerce.qa.base.TestBase;

public class ContactUs extends TestBase {

	public ContactUs() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Contact Us']")
	@CacheLookup
	WebElement contactUsButton;

	@FindBy(id = "id_contact")
	public WebElement subjectHeading;

	@FindBy(name = "id_order")
	WebElement orderReference;

	@FindBy(id = "186618_order_products")
	WebElement productInfo;

	@FindBy(xpath = "//span[contains(text(),'Send')]")
	@CacheLookup
	WebElement sendButton;

	@FindBy(id = "message")
	WebElement message;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	public WebElement sucessmessage;

	@FindBy(xpath = "//input[@id='fileUpload']")
	WebElement chooseFileButton;

	WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

	public void contactButtonClick() {

		contactUsButton.click();

	}

	public void selectSubjectHeading() {

		Select select = new Select(subjectHeading);

		select.selectByIndex(1);

	}

	public void selectOrderReference() {

		Select select = new Select(orderReference);

		select.selectByIndex(1);
	}

	public void selectProduct() {

		Select select = new Select(productInfo);

		select.selectByValue("2");

	}

	public void writeMessage() {

		message.sendKeys(prop.getProperty("messagedummy"));

	}

	public void sendMail() {

		sendButton.click();

	}

	public boolean sucessMessage() {

		return sucessmessage.isDisplayed();

	}

	// Using Sikuli to Upload File
	/*
	 * public void clickChooseFileButton() throws Exception {
	 * 
	 * logger.info("Inside Click choose File Button");
	 * 
	 * webDriverWait.until(ExpectedConditions.visibilityOf(chooseFileButton));
	 * 
	 * logger.info("Visible");
	 * 
	 * chooseFileButton.isDisplayed();
	 * 
	 * logger.info("Is Displayed");
	 * 
	 * chooseFileButton.click();
	 * 
	 * logger.info("Button Clicked");
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * 
	 * String imageFilePath =
	 * "C:\\Users\\Owner\\eclipse-workspace\\Pics for Sikuli\\"; String
	 * inputFilePath = "C:\\Users\\Owner\\Desktop\\";
	 * 
	 * Screen screen = new Screen();
	 * 
	 * Pattern fileInputBox = new Pattern(imageFilePath + "FileName.PNG"); Pattern
	 * openButton = new Pattern(imageFilePath + "openButton.PNG");
	 * 
	 * Thread.sleep(5000);
	 * 
	 * screen.wait(fileInputBox, 20); screen.type(fileInputBox, inputFilePath +
	 * "File 2.pdf"); screen.click(openButton);
	 * 
	 * logger.info("Closed");
	 * 
	 */

}
