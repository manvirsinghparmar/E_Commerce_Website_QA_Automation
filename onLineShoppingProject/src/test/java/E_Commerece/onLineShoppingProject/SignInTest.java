package E_Commerece.onLineShoppingProject;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.SignIn;

public class SignInTest extends TestBase {

	public SignInTest() {
		super();

	}

	SignIn signin;

	@BeforeMethod
	public void setUp() {

		intialisation();

		logger.info("..........Sign In Test Execution Started..........");

		signin = new SignIn();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		logger.info("..........Sign In - First Test..........");

		String pageTitle = signin.loginPageTitle();

		Assert.assertEquals(pageTitle, "My Store");

	}

	@Test(priority = 2)
	public void clickSignInButtonTest() {

		logger.info("..........Sign In - Second Test..........");

		signin.clickSignInButton();

	}

	@Test(priority = 3)
	public void verifyStoreLogoTest() {

		logger.info("..........Sign In - Third Test..........");

		Assert.assertTrue(signin.verifyStoreLogo());

	}

	@Test(dependsOnMethods = { "clickSignInButtonTest" }, priority = 4)
	public void SubmitTest() {

		logger.info("..........Sign In - Fourth Test..........");

		signin.clickSignInButton();

		signin.Submit(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		
		Thread.sleep(1000);

		driver.quit();
		
		logger.info("..........Sign In Test Execution Finished..........");
	}

}
