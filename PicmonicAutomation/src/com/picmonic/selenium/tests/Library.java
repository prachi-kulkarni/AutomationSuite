package com.picmonic.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.picmonic.selenium.utils.ApplicationConstants;

public class Library {
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
	public void testAscendingOrderOfLibrary() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Title A-Z");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testBestMatchInSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Best Match");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testDescendingOrderOfLibrary() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Title Z-A");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testMostRecentInSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Most Recent Viewed");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testNewestInSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Newest");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testRatingOrder15InSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Rating 1-5");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testRatingOrder51InSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Rating 5-1");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testStackInSorting() throws Exception {

		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		new Select(driver.findElement(By.id("sort-library"))).selectByVisibleText("Stack");
		try {
			assertEquals("Picmonic Learning System :: Picmonic", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("sort-library")));
		try {
			assertEquals("Sort:", driver.findElement(By.id("sort-label")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@After
	public void tearDown() throws Exception {

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
