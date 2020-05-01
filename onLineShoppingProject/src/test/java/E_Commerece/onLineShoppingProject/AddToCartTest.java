package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.AddToCart;
import com.e_commerce.qa.pages.SignIn;

public class AddToCartTest extends TestBase {

	AddToCart addToCart;
	SignIn signin;

	@BeforeMethod
	public void setup() {
		
		logger.info("..........AddToCart Test Execution Started..........");

		intialisation();

		addToCart = new AddToCart();

		signin = new SignIn();

		signin.clickSignInButton();

		signin.Submit(prop.getProperty("username"), prop.getProperty("password"));

		addToCart.clickDressesButton();

		addToCart.clickSelectedDress();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));
	}

	@Test(priority = 1)
	public void clickAddToWishListButtonTest() {
		logger.info("..........AddToCart - First Test..........");

		addToCart.clickAddToWishListButton();

	}

	@Test(priority = 2)
	public void addtoCartTest() {
		
		logger.info("..........AddToCart - Second Test..........");

		addToCart.clickAddButton();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		addToCart.addItemsToCart();

	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();
		
		
		logger.info("..........AddToCart Test Execution Finished..........");
		
	}

}
