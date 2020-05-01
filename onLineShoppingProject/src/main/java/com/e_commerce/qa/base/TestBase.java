package com.e_commerce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.e_commerce.qa.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

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

		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

	public static void intialisation() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\onLineShoppingProject\\drivers\\chromedriver.exe");

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
