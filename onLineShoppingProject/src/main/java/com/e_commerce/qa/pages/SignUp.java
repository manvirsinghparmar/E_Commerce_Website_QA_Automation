package com.e_commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import com.e_commerce.qa.base.TestBase;

public class SignUp extends TestBase {

	public SignUp() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_create")
	WebElement signUpEmail;

	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	WebElement createAnAccount;

	@FindBy(id = "id_gender1")
	WebElement mister;

	@FindBy(id = "id_gender2")
	WebElement mrs;

	@FindBy(name = "customer_firstname")
	WebElement customerFirstName;

	@FindBy(name = "customer_lastname")
	WebElement customerLastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(name = "firstname")
	WebElement addressFirstName;

	@FindBy(name = "lastname")
	WebElement addressLastName;

	@FindBy(id = "address1")
	WebElement addressFirstLine;

	@FindBy(id = "city")
	WebElement addressCity;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "postcode")
	WebElement postCode;

	@FindBy(id = "id_country")
	WebElement country;

	@FindBy(id = "phone_mobile")
	WebElement phoneMobile;

	@FindBy(id = "alias")
	WebElement commonName;

	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement registerButton;

	public void SignUpEmail(String emailForSignUp)  {

		signUpEmail.sendKeys(emailForSignUp);

		createAnAccount.click();

	}

	public void selectMrs() {

		mrs.click();
	}

	public void fillForm(String cFirstName, String cLastName, String cPassword, String addFirstName, String addLastName,
			String addFirstline, String city, String postalCode, String phoneNumber, String cName) {

		customerFirstName.sendKeys(cFirstName);
		customerLastName.sendKeys(cLastName);
		password.sendKeys(cPassword);
		addressFirstName.sendKeys(addFirstName);
		addressLastName.sendKeys(addLastName);
		addressFirstLine.sendKeys(addFirstline);
		addressCity.sendKeys(city);
		postCode.sendKeys(postalCode);
		phoneMobile.sendKeys(phoneNumber);
		commonName.clear();
		commonName.sendKeys(cName);

	}

	public void stateSelection() {

		Select selectbyState = new Select(state);

		selectbyState.selectByIndex(3);
	}

	public void countrySelection() {

		Select selectbyState = new Select(country);

		selectbyState.selectByIndex(1);

	}

	public HomePage registerButtonClick() {

		registerButton.click();

		return new HomePage();
	}

}
