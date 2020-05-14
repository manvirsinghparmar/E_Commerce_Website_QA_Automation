package E_Commerece.onLineShoppingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.e_commerce.qa.base.TestBase;
import com.e_commerce.qa.pages.HomePage;
import com.e_commerce.qa.pages.SignIn;
import com.e_commerce.qa.pages.SignUp;
import com.e_commerce.qa.utils.ExcelUtils;

public class SignUpTest extends TestBase {

	SignUp signUp;
	SignIn signIn;
	HomePage homepage;

	WebDriverWait wait;

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

		homepage = new HomePage();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "customerDetailsFromOracleServerDatabase")
	public void validateSignUpFormTest(String signUpEmail, String signUpUserFirstName, String signUpUserLastName,
			String signUpPassword, String addessFirstName, String addressLastName, String address, String addressCity,
			String addressZipCode, String addressMobilePhone, String commonName) {

		logger.info("..........Sign Up - First Test..........");

		signUp.SignUpEmail(signUpEmail);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signUp.selectMrs();

		signUp.fillForm(signUpUserFirstName, signUpUserLastName, signUpPassword, addessFirstName, addressLastName,
				address, addressCity, addressZipCode, addressMobilePhone, commonName);

		signUp.stateSelection();

		signUp.countrySelection();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signUp.registerButtonClick();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class='icon-home']")).isDisplayed());

	}

	@DataProvider(name = "customerDetailsFromExcelSheet")
	String[][] dataProviderofExcelsheet() throws Exception {
		logger.info("Inside Customer Details Data Provider from excelsheet ");

		String filePath = "C:\\Users\\Owner\\git\\E_commerce_automation_selenium\\onLineShoppingProject\\src\\main\\java\\com\\e_commerce\\qa\\testdata\\SignUpUser 1.xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", 1);

		String[][] customerData = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				customerData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}

		}

		return customerData;

	}

	@DataProvider(name = "customerDetailsFromOracleServerDatabase")
	String[][] dataProviderofOracleDataBase() throws SQLException {

		logger.info("Inside Customer Details Data Provider from Oracle Database ");

		Connection connection;

		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "Manvir1988");

		Statement statement = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		String query = "select * from USERSIGNUPDETAILS";

		ResultSet result;

		result = statement.executeQuery(query);

		int rowSize = 0;

		result.last();
		rowSize = result.getRow();
		result.beforeFirst();

		ResultSetMetaData rsmd = result.getMetaData();
		int columnSize = rsmd.getColumnCount();

		String[][] customerData = new String[rowSize][columnSize];

		System.out.println("Total rows are :" + rowSize);

		int i = 0;
		while (result.next() && i < rowSize) {
			for (int j = 0; j < columnSize; j++) {
				customerData[i][j] = result.getString(j + 1);
			}
			i++;
		}
		result.close();
		statement.close();
		connection.close();

		return customerData;

	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		driver.quit();

		logger.info("..........Sign Up Test Execution Finished..........");

	}

}
