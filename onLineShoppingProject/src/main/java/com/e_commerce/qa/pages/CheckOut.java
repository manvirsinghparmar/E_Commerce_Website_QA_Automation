package com.e_commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e_commerce.qa.base.TestBase;

public class CheckOut extends TestBase {

	public CheckOut() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement checkCart;

	@FindBy(xpath = "//span[contains(text(),'Check out')]")
	WebElement checkOutButton;

	@FindBy(xpath = "//td[@class='cart_description']//a[contains(text(),'Printed Dress')]")
	WebElement dressDescription;

	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;

	@FindBy(xpath = "//span[contains(text(),'6472152995')]")
	WebElement contactNumber;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutAddress;

	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutCarrier;

	@FindBy(name = "message")
	public WebElement messageTextArea;

	@FindBy(xpath = "//input[@name='cgv']")
	WebElement checkBoxTermCondition;

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWireButton;

	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;

	@FindBy(xpath = "//h3[@class='page-subheading']")
	WebElement paymentTypeHeading;

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement orderConfirmationButton;

	@FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement orderConfirmationMessage;

	public void movetoCart() {

		Actions actions = new Actions(driver);

		actions.moveToElement(checkCart).build().perform();
	}

	public void clickCheckOutButton() {

		checkOutButton.click();
	}

	public String readDressDescription() {

		String descriptionOfDress = dressDescription.getText().toString();

		return descriptionOfDress;

	}

	public String readPriceOfDress() {

		String priceOfDress = totalPrice.getText().toString();

		return priceOfDress;

	}

	public String readContactno() {

		String contNumber = contactNumber.getText().toString();

		return contNumber;
	}

	public void clickProceedtoCheckoutDefaultButton() {

		proceedToCheckout.click();
	}

	public void writeMessage() {

		messageTextArea.sendKeys(prop.getProperty("addressMessage"));

	}

	public void clickproceedToCheckoutAddress() {

		proceedToCheckoutAddress.click();
	}

	public void clickCheckBox() {

		checkBoxTermCondition.click();
	}

	public void clickproceedToCheckoutCarrier() {

		proceedToCheckoutCarrier.click();
	}

	public void paymentMethod(String paymentway) {

		if (paymentway.equals("Check payment")) {

			payByCheck.click();
		} else {

			payByBankWireButton.click();

		}

	}

	public String readPaymentHeading() {

		String typeOfPayment = paymentTypeHeading.getText().toString();

		return typeOfPayment;

	}

	public void clickOrderConfirmationButton() {

		orderConfirmationButton.click();

	}

	public String readOrderConirmationMessage() {

		String confirmationMessage = orderConfirmationMessage.getText().toString();
		return confirmationMessage;
	}

}
