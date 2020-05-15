package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.ContactUs;
import com.e_commerce.qa.pages.SignIn;
import com.e_commerce.qa.utils.TestUtil;

public class ContactUsTest extends TestBase {

	SignIn signin;
	ContactUs contactus;

	WebDriverWait webDriverWait;

	@BeforeMethod
	public void setUp() {

		logger.info("..........Contact us Test Execution Started..........");
		intialisation();

		signin = new SignIn();
		contactus = new ContactUs();

		signin.clickSignInButton();

		signin.Submit(prop.getProperty("username"), prop.getProperty("password"));

		contactus.contactButtonClick();

	}

	 @Test(priority = 1)
	public void fillContactForm() {

		logger.info("..........Contact us - First Test ..........");

		contactus.selectSubjectHeading();
		contactus.selectOrderReference();
		contactus.writeMessage();

		contactus.sendMail();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Assert.assertTrue(contactus.sucessMessage());

	}

	@AfterMethod
	void tearDown() {

		driver.quit();

		logger.info("..........Contact us Test Execution Finished..........");
	}

}
