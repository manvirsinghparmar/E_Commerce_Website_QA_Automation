package E_Commerece.onLineShoppingProject;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.SignIn;
import com.e_commerce.qa.pages.SignUp;
import com.e_commerce.qa.utils.ExcelUtils;

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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "customerDetails")
	public void validateSignUpFormTest(String signUpEmail, String signUpUserFirstName, String signUpUserLastName,
			String signUpPassword, String addessFirstName, String addressLastName, String address, String addressCity,
			String addressZipCode, String addressMobilePhone, String commonName) {

		logger.info("..........Sign Up - First Test..........");

		signUp.SignUpEmail(signUpEmail);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signUp.selectMrs();

		/*
		 * signUp.fillForm(prop.getProperty("signUpUserFirstName"),
		 * prop.getProperty("signUpUserLastName"), prop.getProperty("signUpPassword"),
		 * prop.getProperty("addessFirstName"), prop.getProperty("addressLastName"),
		 * prop.getProperty("address"), prop.getProperty("addressCity"),
		 * prop.getProperty("addressZipCode"), prop.getProperty("addressMobilePhone"),
		 * prop.getProperty("commonName"));
		 */

		signUp.fillForm(signUpUserFirstName, signUpUserLastName, signUpPassword, addessFirstName, addressLastName,
				address, addressCity, addressZipCode, addressMobilePhone, commonName);

		signUp.stateSelection();

		signUp.countrySelection();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signUp.registerButtonClick();

	}

	@DataProvider(name = "customerDetails")
	String[][] dataProvider() throws Exception {
		logger.info("Inside Customer Details Data Provider");

		String filePath = "C:\\Users\\Owner\\git\\E_commerce_automation_selenium\\onLineShoppingProject\\src\\main\\java\\com\\e_commerce\\qa\\testdata\\SignUpUser.xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", 1);

		String[][] customerData = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				customerData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}

		}

		System.out.println("The data provided is: " + customerData.toString());

		return customerData;

	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		Thread.sleep(15000);

		driver.quit();

		logger.info("..........Sign Up Test Execution Finished..........");

	}

}
