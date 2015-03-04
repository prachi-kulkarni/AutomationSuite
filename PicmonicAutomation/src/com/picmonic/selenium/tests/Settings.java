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

public class Settings {
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
	public void testAudioSetting() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Default Audio".equals(driver.findElement(By.cssSelector("label.col-md-8")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		try {
			assertEquals("Default Audio", driver.findElement(By.cssSelector("label.col-md-8")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		new Select(driver.findElement(By.id("learn_audio"))).selectByVisibleText("Educational");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testChangeAudioSettingToStory() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Default Audio".equals(driver.findElement(By.cssSelector("label.col-md-8")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		try {
			assertEquals("Default Audio", driver.findElement(By.cssSelector("label.col-md-8")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Picmonic Player Settings", driver.findElement(By.cssSelector("h4")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		new Select(driver.findElement(By.id("learn_audio"))).selectByVisibleText("Story");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testCheckTheCheckBoxforHideIntroductoryPopup() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Hide the introductory popups for Picmonics I haven't viewed",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Hide the introductory popups')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("skip_intro")).click();
		assertTrue(isElementPresent(By.name("skip_intro")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testDifferentNewPasswordAndConfirmOassword() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome1");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Welcome1");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Welcome2");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.cssSelector("div.formErrorContent")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testEditableChangePassword() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("abc");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("abc");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("abc");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testHideTheIntroductoryPopups() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Hide the introductory popups for Picmonics I haven't viewed",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Hide the introductory popups')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.name("skip_intro")));
		driver.findElement(By.name("skip_intro")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testHideThePopups() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Hide the popups between Learning modes",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Hide the popups between Learning modes')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.name("skip_congrats")));
		driver.findElement(By.name("skip_congrats")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testHideThePopupsInLearningMode() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Hide the popups between Learning modes",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Hide the popups between Learning modes')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("", driver.findElement(By.name("skip_congrats")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("skip_congrats")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testIncorrectCurrentPassword() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome2");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Welcome2");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Welcome2");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.cssSelector("span.post_message")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testNewPassword() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome1");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Welcome2");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Welcome2");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.cssSelector("span.post_message")));
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome2");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Welcome1");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testNewPicmonicUpdate() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"New Picmonic Updates",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'New Picmonic Updates')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("", driver.findElement(By.id("new_card_updates")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("new_card_updates")).click();
		assertTrue(isElementPresent(By.id("new_card_updates")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testPasswordCharacterLessThen8() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome1");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Wel1");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Wel1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.cssSelector("div.formErrorContent")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testPicmonicNewsLetter() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Communication Settings",
					driver.findElement(
							By.xpath("//div[@id='main-container']//h4[contains(text(),'Communication Settings')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(
					"Picmonic Newsletter",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Picmonic Newsletter')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("picmonic_news")).click();
		assertTrue(isElementPresent(By.id("picmonic_news")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testShowTextInAudioWalkThrough() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Show text during audio walk-through",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Show text during audio walk-through')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.name("learn_definition")));
		try {
			assertEquals("", driver.findElement(By.name("learn_definition")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("learn_definition")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testTurnOnSafetyMode() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Turn on Safety Mode",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Turn on Safety Mode')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertTrue(isElementPresent(By.id("safety_mode")));
		driver.findElement(By.id("safety_mode")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testUncheckTheCheckbox() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Show text during audio walk-through",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Show text during audio walk-through')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("", driver.findElement(By.name("learn_definition")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("learn_definition")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testUncheckTheCheckboxInNewPicmonicUpdate() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"New Picmonic Updates",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'New Picmonic Updates')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("new_card_updates")).click();
		assertTrue(isElementPresent(By.id("new_card_updates")));
		try {
			assertEquals("", driver.findElement(By.id("new_card_updates")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testUncheckTheCheckboxInTurnOnSafetyMode() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals("Content Rating",
					driver.findElement(By.xpath("//div[@id='main-container']//h4[contains(text(),'Content Rating')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("safety_mode")).click();
		assertTrue(isElementPresent(By.id("safety_mode")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testUncheckTheCheckboxOfPicmonicNewsLetter() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		try {
			assertEquals(
					"Picmonic Newsletter",
					driver.findElement(
							By.xpath("//div[@id='main-container']//label[contains(text(),'Picmonic Newsletter')]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("picmonic_news")).click();
		assertTrue(isElementPresent(By.id("picmonic_news")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testWithoutDigitPassword() throws Exception {

		driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Site Settings')]")).click();
		driver.findElement(By.id("current_password")).clear();
		driver.findElement(By.id("current_password")).sendKeys("Welcome1");
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Welcomee");
		driver.findElement(By.id("column_new_password")).clear();
		driver.findElement(By.id("column_new_password")).sendKeys("Welcomee");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.id("new_password")));
		assertTrue(isElementPresent(By.cssSelector("div.formErrorContent")));
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
