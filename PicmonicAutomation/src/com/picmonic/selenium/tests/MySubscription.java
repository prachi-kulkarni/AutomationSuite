package com.picmonic.selenium.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.picmonic.selenium.utils.ApplicationConstants;

public class MySubscription {
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
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testBillingHistoryOfMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		driver.findElement(By.linkText("BILLING HISTORY")).click();
		assertTrue(isElementPresent(By.linkText("BILLING HISTORY")));
		try {
			assertEquals("You don't have any orders yet. Please go to the Store page to start a new subscription!",
					driver.findElement(By.cssSelector("p.centered")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testFAQofMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		try {
			assertEquals("FAQs", driver.findElement(By.xpath("//div[@id='purchase-container']//h2")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.linkText("VIEW ALL >")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		try {
			assertEquals("STATUS",
					driver.findElement(By.xpath("//div[@id='purchase-container']//th[contains(text(),'STATUS')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("PRODUCT",
					driver.findElement(By.xpath("//div[@id='purchase-container']//th[contains(text(),'PRODUCT')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(
					"EXPIRATION DATE",
					driver.findElement(
							By.xpath("//div[@id='purchase-container']//th[contains(text(),'EXPIRATION DATE')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testMySubscription1() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		try {
			assertEquals("PRODUCT",
					driver.findElement(By.xpath("//div[@id='purchase-container']//th[contains(text(),'PRODUCT')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(
					"Picmonic for Medicine",
					driver.findElement(
							By.xpath("//div[@id='purchase-container']//td[contains(text(),'Picmonic for Medicine')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("INACTIVE", driver.findElement(By.xpath("//descendant::span[@class = 'status'][1]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.linkText("SUBSCRIBE")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testMySubscriptionForMCAT() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		assertEquals("MCAT Biology",
				driver.findElement(By.xpath("//div[@id='purchase-container']//td[contains(text(),'MCAT Biology')]"))
						.getText());
		assertEquals("INACTIVE", driver.findElement(By.xpath("//descendant::span[@class = 'status'][2]")).getText());
		assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'SUBSCRIBE')])[2]")));
		driver.findElement(By.xpath("(//a[contains(text(),'SUBSCRIBE')])[2]")).click();
		// driver.get(baseUrl + "/login");
		// driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testMySubscriptionForMedicine() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		try {
			assertEquals(
					"Picmonic for Medicine",
					driver.findElement(
							By.xpath("//div[@id='purchase-container']//td[contains(text(),'Picmonic for Medicine')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'SUBSCRIBE')])[2]")).click();
		// driver.get(baseUrl + "/login");
		// driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testMySubscriptionStatus() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		try {
			assertEquals("STATUS",
					driver.findElement(By.xpath("//div[@id='purchase-container']//th[contains(text(),'STATUS')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("INACTIVE", driver.findElement(By.xpath("//descendant::span[@class = 'status'][1]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.linkText("SUBSCRIBE")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testOrderHistoryOfMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		driver.findElement(By.linkText("ORDER HISTORY")).click();
		assertTrue(isElementPresent(By.linkText("ORDER HISTORY")));
		try {
			assertEquals("You don't have an order history. Go to the Store to Subscribe today!",
					driver.findElement(By.cssSelector("p.centered")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testPaymentInfoOfMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		driver.findElement(By.linkText("PAYMENT INFO")).click();
		assertTrue(isElementPresent(By.linkText("PAYMENT INFO")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testTabsOfMySubscription() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("PRODUCT ACCESS".equals(driver.findElement(By.linkText("PRODUCT ACCESS")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		try {
			assertEquals("PRODUCT ACCESS", driver.findElement(By.linkText("PRODUCT ACCESS")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.linkText("PRODUCT ACCESS")));
		try {
			assertEquals("ORDER HISTORY", driver.findElement(By.linkText("ORDER HISTORY")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("BILLING HISTORY", driver.findElement(By.linkText("BILLING HISTORY")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("PAYMENT INFO", driver.findElement(By.linkText("PAYMENT INFO")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("ORDER HISTORY")).click();
		driver.findElement(By.linkText("BILLING HISTORY")).click();
		driver.findElement(By.linkText("PAYMENT INFO")).click();
		driver.findElement(By.linkText("PRODUCT ACCESS")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

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
			driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
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
}
