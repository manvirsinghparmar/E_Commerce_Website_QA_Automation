package com.e_commerce.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.e_commerce.qa.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public Logger logger;

	public TestBase() {

		prop = new Properties();

		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\Owner\\eclipse-workspace\\onLineShoppingProject\\"
					+ "src\\main\\java\\com\\e_commerce\\qa\\config\\config.properties");

			try {
				prop.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	@BeforeClass
	public void logSetUp() {

		logger = Logger.getLogger("TestBase");
		PropertyConfigurator.configure(
				"C:\\Users\\Owner\\git\\E_commerce_automation_selenium\\onLineShoppingProject\\src\\main\\resources\\log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.DEBUG);

		logger.info("Inside Log Set Up");

	}

	//This id shaminder
	public void failedTestScreenShot(String testMethodName) {
		
		

		System.out.println("Failed Test ........Taking Screen Shot........");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		File screenShotFfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile, new File(
					"C:\\Users\\Owner\\git\\E_commerce_automation_selenium\\onLineShoppingProject\\screenShotsOfFailedTests\\"
							+ "_" + testMethodName+ "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}

	public static void intialisation() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Owner\\git\\E_commerce_automation_selenium\\onLineShoppingProject\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\onLineShoppingProject\\drivers\\geckodriver.exe");

		} else {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\onLineShoppingProject\\drivers\\IEDriverServer.exe");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
