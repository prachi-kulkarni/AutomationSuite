package com.picmonic.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.picmonic.selenium.utils.ApplicationConstants;

public class Menu {
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
	public void testEditProfileInMenu() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
		assertTrue(isElementPresent(By.cssSelector("div.bar.tip")));
		assertTrue(isElementPresent(By.id("portrait")));
		assertEquals("Upload", driver.findElement(By.id("upload-picture")).getText());
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testLibraryInMenu() throws Exception {

		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals("Library", driver.findElement(By.id("mine")).getText());
		assertEquals("Marketplace", driver.findElement(By.id("world")).getText());
		assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		assertTrue(isElementPresent(By.id("playlist-dropdown-button")));
		driver.findElement(By.cssSelector("div.card-list-container")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testMenu() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item']//span[contains(text(),'Dashboard')]")).click();
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals("List of Picmonics", driver.findElement(By.linkText("List of Picmonics")).getText());
		assertEquals("Picmonic News", driver.findElement(By.cssSelector("span.title")).getText());
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testMuSubscriptionInMenu() throws Exception {
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'My Subscriptions')]")).click();
		assertEquals("PRODUCT ACCESS", driver.findElement(By.linkText("PRODUCT ACCESS")).getText());
		assertEquals("ORDER HISTORY", driver.findElement(By.linkText("ORDER HISTORY")).getText());
		assertEquals("BILLING HISTORY", driver.findElement(By.linkText("BILLING HISTORY")).getText());
		assertEquals("PAYMENT INFO", driver.findElement(By.linkText("PAYMENT INFO")).getText());
		driver.findElement(By.linkText("ORDER HISTORY")).click();
		driver.findElement(By.linkText("BILLING HISTORY")).click();
		driver.findElement(By.linkText("PAYMENT INFO")).click();
		driver.findElement(By.linkText("PRODUCT ACCESS")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testSignOutInMenu() throws Exception {

		assertEquals("Sign Out", driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Sign Out')]"))
				.getText());
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testSiteSettingInMenu() throws Exception {
		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		assertEquals("Picmonic Player Settings", driver.findElement(By.cssSelector("h4")).getText());
		assertEquals("Communication Settings",
				driver.findElement(By.xpath("//div[@id='main-container']/div/div/div[2]/div/h4")).getText());
		assertEquals("Content Rating", driver
				.findElement(By.xpath("//div[@id='main-container']/div/div/div[4]/div/h4")).getText());
		assertEquals("Change Password",
				driver.findElement(By.xpath("//div[@id='main-container']/div/div/div[5]/div/h4")).getText());
		assertEquals("Save Password", driver.findElement(By.xpath("//button[@type='submit']")).getText());
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testStoreInMenu() throws Exception {
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='http://picmonic.com/store']/div[@class='nav-item']")).click();
		assertEquals("NURSING", driver.findElement(By.cssSelector("h2.portfolio-title")).getText());
		assertEquals("MEDICINE", driver.findElement(By.xpath("//div[@id='carousel_77']/div/ul/li[2]/a/div/div/div/h2"))
				.getText());
		assertEquals("MCAT", driver.findElement(By.xpath("//div[@id='carousel_77']/div/ul/li[3]/a/div/div/div/h2"))
				.getText());
		assertTrue(isElementPresent(By.cssSelector("span.copyright")));

	}

	@Test
	public void testIdeasInMenu() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(				
				By.xpath("//a[contains(@href, 'http://feedback.picmonic.com')]/span[@class='nav-item']"))
				.click();

		driver.get("http://feedback.picmonic.com/forums/239315-picmonic-v2");
		assertEquals("Contact support", driver.findElement(By.xpath("(//button[@type='button'])[24]")).getText());
		assertTrue(isElementPresent(By.linkText("Give feedback")));

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
