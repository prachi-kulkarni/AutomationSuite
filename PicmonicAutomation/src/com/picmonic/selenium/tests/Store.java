package com.picmonic.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.Predicate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.picmonic.selenium.utils.ApplicationConstants;
import com.thoughtworks.selenium.Wait;

public class Store {
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public static void classSetup() {
		driver = new FirefoxDriver();
		baseUrl = ApplicationConstants.BASEURL;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login code
		driver.get(baseUrl + "/login");
		driver.findElement(By.name("credentials[email]")).clear();
		driver.findElement(By.name("credentials[email]")).sendKeys(ApplicationConstants.EMAIL);
		driver.findElement(By.name("credentials[password]")).clear();
		driver.findElement(By.name("credentials[password]")).sendKeys(ApplicationConstants.PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAnnualSubscribefromNursing() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		assertEquals("SUBSCRIBE",
				driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).getText());
		try {
			assertEquals("SUBSCRIBE",
					driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).click();

	}

	@Test
	public void testBuyNowfromNursing() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		assertEquals("BUY NOW",
				driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]"))
						.getText());
		try {
			assertEquals(
					"BUY NOW",
					driver.findElement(
							By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();

	}

	@Test
	public void testChangeSubscriptionPlan() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		driver.findElement(By.linkText("SUBSCRIBE")).click();

	}

	@Test
	public void test18MonthsSubscriptionforMedicine() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MEDICINE']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).click();
		// assertEquals("1 time payment for 18 Months of access",
		// driver.findElement(By.xpath("//div[@id='main-container']//h4[contains(text(),'1 time payment for 18 Months')]")).getText());
		// try {
		// assertEquals("1 time payment for 18 Months of access",
		// driver.findElement(By.xpath("//div[@id='main-container']//h4[contains(text(),'1 time payment for 18 Months')]")).getText());
		// } catch (Error e) {
		// verificationErrors.append(e.toString());
		// }

	}

	@Test
	public void testHelpFeedbackfromSubscription() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MCAT']")).click();
		driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).click();

	}

	@Test
	public void testMCATfromStore() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MCAT']")).click();
		assertEquals("PICMONIC FOR MCAT BIOLOGY", driver.findElement(By.cssSelector("span")).getText());
		try {
			assertEquals("PICMONIC FOR MCAT BIOLOGY", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}

	@Test
	public void testMedicinefromStore() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MEDICINE']")).click();
		assertEquals("PICMONIC\nFOR MEDICINE", driver.findElement(By.cssSelector("h1.hero-title")).getText());
		try {
			assertEquals("PICMONIC\nFOR MEDICINE", driver.findElement(By.cssSelector("h1.hero-title")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}

	@Test
	public void testMonthlySubscribefromMedicine() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MEDICINE']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		driver.findElement(By.linkText("SUBSCRIBE")).click();

	}

	@Test
	public void testMonthlySubscriptionfromNursing() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));

		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));

		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		assertEquals("SUBSCRIBE", driver.findElement(By.linkText("SUBSCRIBE")).getText());
		try {
			assertEquals("SUBSCRIBE", driver.findElement(By.linkText("SUBSCRIBE")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("SUBSCRIBE")).click();

	}

	@Test
	public void testNursingfromStore() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		assertEquals("PICMONIC\nFOR NURSING", driver.findElement(By.cssSelector("h1.hero-title")).getText());
		try {
			assertEquals("PICMONIC\nFOR NURSING", driver.findElement(By.cssSelector("h1.hero-title")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}

	@Test
	public void test6MonthsfromMCAT() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MCAT']")).click();
		assertEquals("SUBSCRIBE",
				driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).getText());
		try {
			assertEquals("SUBSCRIBE",
					driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//div[@class='selectePrice-content']//a[@class='signup']")).click();

	}

	@Test
	public void testSixMonthsSubscribeforMedicine() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MEDICINE']")).click();
		driver.findElement(By.xpath("//span[@class='hero-description-bottom']//a[contains(text(),'Buy Now')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Subscribe')])[2]")).click();

	}

	@Test
	public void testStore() throws Exception {

		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
	}

	@Test
	public void test3MonthsfromMCAT() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MCAT']")).click();
		try {
			assertEquals("SUBSCRIBE",
					driver.findElement(By.xpath("(//a[@class='signup'][contains(text(),'Subscribe')])[1]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[@class='signup'][contains(text(),'Subscribe')])[1]")).click();

	}

	@Test
	public void testTrialfromNursing() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		driver.findElement(By.linkText("TRY FREE")).click();

	}

	@Test
	public void testTryFreefromMedicine() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='MEDICINE']")).click();
		driver.findElement(By.linkText("TRY FREE")).click();

	}

	@Test
	public void testTryFreeFromNursing() throws Exception {
		clickWhenReady(By.xpath("//button//i[@class='icon-bars']"));
		clickWhenReady(By.xpath("//div[@class='nav-item']/i[@class='icon-shopping-cart']"));
		driver.findElement(By.xpath("//div[@id='carousel_77']//a[@title='NURSING']")).click();
		assertEquals("TRY FREE", driver.findElement(By.linkText("TRY FREE")).getText());
		try {
			assertEquals("TRY FREE", driver.findElement(By.linkText("TRY FREE")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("TRY FREE")).click();

	}

	@After
	public void tearDown() throws Exception {
		String currentURL = driver.getCurrentUrl();

		if (!currentURL.contains(baseUrl)) {
			driver.get(baseUrl + "/login");
			driver.findElement(By.name("credentials[email]")).clear();
			driver.findElement(By.name("credentials[email]")).sendKeys("pkedar@intraedge.com");
			driver.findElement(By.name("credentials[password]")).clear();
			driver.findElement(By.name("credentials[password]")).sendKeys("Welcome1");
			driver.findElement(By.xpath("//button[@type='submit']")).click();

		}
	}

	@AfterClass
	public static void classTeardown() {
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Sign Out')]")).click();

		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public static void clickWhenReady(By locator) {
		int timeout = 10;
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}
	
	
}
