package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.AddToCart;
import com.e_commerce.qa.pages.CheckOut;
import com.e_commerce.qa.pages.SignIn;

public class CheckOutTest extends TestBase {

	SignIn signin;
	AddToCart addToCart;
	CheckOut checkOut;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {

		logger.info("..........Checkout Test Execution Started..........");

		intialisation();

		wait = new WebDriverWait(driver, 10);

		signin = new SignIn();
		addToCart = new AddToCart();
		checkOut = new CheckOut();

		signin.clickSignInButton();
		signin.Submit(prop.getProperty("username"), prop.getProperty("password"));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='icon-home']"))));

		addToCart.clickDressesButton();
		addToCart.clickSelectedDress();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));

		addToCart.addItemsToCart();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		checkOut.movetoCart();

		checkOut.clickCheckOutButton();

	}

	@Test(priority = 1)
	public void readDressDescriptionTest() {

		logger.info("..........Checkout  - First Test ..........");

		Assert.assertEquals(checkOut.readDressDescription(), "Printed Dress");

	}

	@Test(priority = 2)
	public void readContactnoTest() {
		logger.info("..........Checkout  - Second Test ..........");

		Assert.assertEquals(checkOut.readContactno(), "6472152995");

	}

	@Test(priority = 3)
	public void readPriceOfDress() {
		logger.info("..........Checkout  - Third Test ..........");

		Assert.assertEquals(checkOut.readPriceOfDress(), "$29.12");
	}

	@Test(priority = 4)
	public void addMessageTest() {
		logger.info("..........Checkout  - Fourth Test ..........");
		checkOut.clickProceedtoCheckoutDefaultButton();

		wait.until(ExpectedConditions.visibilityOf(checkOut.messageTextArea));

		checkOut.writeMessage();
	}

	@Test(priority = 5)
	public void paymentMethodTest() {
		logger.info("..........Checkout  - Fifth Test ..........");

		// Navigate to address Tab
		checkOut.clickProceedtoCheckoutDefaultButton();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to Shipping Tab
		checkOut.clickproceedToCheckoutAddress();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		checkOut.clickCheckBox();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to Payment Tab
		checkOut.clickproceedToCheckoutCarrier();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		checkOut.paymentMethod(prop.getProperty("page-subheading"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Assert.assertEquals(checkOut.readPaymentHeading(), "CHECK PAYMENT");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		checkOut.clickOrderConfirmationButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.quit();

		logger.info("..........Checkout Test Execution Finished..........");

	}

}
