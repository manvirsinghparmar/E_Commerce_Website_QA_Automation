package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.HomePage;
import com.e_commerce.qa.pages.SignIn;
import com.e_commerce.qa.utils.TestUtil;

public class HomePageTest extends TestBase {

	SignIn signin;
	HomePage homepage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	void setup() {

		logger.info("..........Home Page Test Execution Started..........");

		intialisation();

		signin = new SignIn();

		homepage = new HomePage();

		signin.clickSignInButton();

		signin.Submit(prop.getProperty("username"), prop.getProperty("password"));

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void verifyUserNameTest() {

		logger.info("..........Home Page -First Test ..........");

		Assert.assertTrue(homepage.verifyUserName());
	}

	@Test(priority = 2)
	public void verifyHomeIconTest() {

		logger.info("..........Home Page - Second Test ..........");

		Assert.assertTrue(homepage.verifyHomeIcon(), "Home Page Icon Not Found");
	}

	@Test(priority = 3)
	public void shoppingCartItemsTest() throws InterruptedException {

		logger.info("..........Home Page - Third Test ..........");

		homepage.shoppingCartItems();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		WebElement cartTitle=driver.findElement(By.xpath("//h1[@id='cart_title']"));
		
		String titleOfCart=cartTitle.getText();
		
		Assert.assertEquals(titleOfCart, "SHOPPING-CART SUMMARY-Manvir");

	}

	@AfterMethod
	void tearDown() throws InterruptedException {
		Thread.sleep(2000);

		driver.quit();

		logger.info("..........Home Page Test Execution Finished..........");
	}

}
