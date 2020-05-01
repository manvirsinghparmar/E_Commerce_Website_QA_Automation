package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.SignIn;
import com.e_commerce.qa.pages.SignUp;

public class SignUpTest extends TestBase {

	SignUp signUp;
	SignIn signIn;

	public SignUpTest() {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {

		logger.info("..........Sign Up Test Execution Started..........");

		intialisation();

		signIn = new SignIn();

		signIn.clickSignInButton();

		signUp = new SignUp();

		signUp.SignUpEmail(prop.getProperty("signUpEmail"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void fillFormTest() {

		logger.info("..........Sign Up - First Test..........");

		signUp.selectMrs();

		signUp.fillForm(prop.getProperty("signUpUserFirstName"), prop.getProperty("signUpUserLastName"),
				prop.getProperty("signUpPassword"), prop.getProperty("addessFirstName"),
				prop.getProperty("addressLastName"), prop.getProperty("address"), prop.getProperty("addressCity"),
				prop.getProperty("addressZipCode"), prop.getProperty("addressMobilePhone"),
				prop.getProperty("commonName"));

		signUp.stateSelection();

		signUp.countrySelection();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signUp.registerButtonClick();

	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		Thread.sleep(15000);

		driver.quit();

		logger.info("..........Sign Up Test Execution Finished..........");

	}

}
