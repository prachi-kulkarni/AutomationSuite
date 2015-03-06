package com.picmonic.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.picmonic.selenium.utils.ApplicationConstants;

public class PlayList {
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

	@Ignore
	@Test
	public void testClearPlaylist() throws Exception {

		driver.findElement(By.id("header-playlist-button")).click();
		driver.findElement(By.id("current-set")).click();
		driver.findElement(By.id("create-set-item")).click();
		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("ashish");
		driver.findElement(By.id("save_playlist")).click();

		// TODO: add picmonics to playlist

		addPicmonics(3);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		driver.findElement(By.linkText("Clear Playlist")).click();
		driver.findElement(By.xpath("//div[@id='playlist_clear_confirm']//button[@class='btn btn-primary']")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testCreatePlaylistWithBlankField() throws Exception {
		driver.findElement(By.id("header-playlist-button")).click();
		// create playlist
		driver.findElement(By.id("playlist-dropdown-button")).click();

		driver.findElement(By.id("create-set-item")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@id='set_modal']//div[@class='modal-content']//button[contains(text(),'Cancel')]"))
				.click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
	}

	@Test
	public void testDeletePlaylist() throws Exception {

		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		// create playlist

		driver.findElement(By.id("playlist-dropdown-button")).click();
		driver.findElement(By.id("create-set-item")).click();
		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("ashish");
		driver.findElement(By.id("save_playlist")).click();

		// delete playlist
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		driver.findElement(By.id("delete-set")).click();

		// driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testDragandDropplaylist() throws Exception {

		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Ignore
	@Test
	public void testDuplicatePlaylist() throws Exception {

		driver.findElement(By.id("header-playlist-button")).click();
		driver.findElement(By.id("current-set")).click();
		driver.findElement(By.id("create-set-item")).click();
		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("ashish");
		driver.findElement(By.id("save_playlist")).click();

		// TODO: Add picmonic only after that clone can be created

		// Duplicate playlist
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		driver.findElement(By.id("duplicate-set")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Ignore
	@Test
	public void testLearnItNow() throws Exception {

		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		driver.findElement(By.cssSelector("i.icon-plus-circle")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		driver.findElement(By.id("learn-it-now")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Ignore
	@Test
	public void testLearnPlaylist() throws Exception {

		driver.findElement(By.xpath("//a[@href='/library']/div[@class='nav-item']")).click();
		driver.findElement(By.xpath("//a[@id='subnav-add-all']/span")).click();
		driver.findElement(By.id("create-set")).click();
		// driver.get(baseUrl + "/login");
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testNewPlaylist() throws Exception {

		assertEquals("PLAYLIST", driver.findElement(By.id("header-playlist-button")).getText());
		try {
			assertEquals("PLAYLIST", driver.findElement(By.id("header-playlist-button")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("header-playlist-button")).click();
		driver.findElement(By.id("current-set")).click();
		driver.findElement(By.id("create-set-item")).click();
		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("ashish");
		driver.findElement(By.id("save_playlist")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testPlaylist() throws Exception {

		driver.findElement(By.id("header-playlist-button")).click();
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();

	}

	@Test
	public void testRenamePlaylist() throws Exception {
		driver.findElement(By.id("header-playlist-button")).click();
		driver.findElement(By.cssSelector("i.icon-cog")).click();
		driver.findElement(By.id("rename-set")).click();
		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("ashishkumar");
		driver.findElement(By.id("save_playlist")).click();
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

	private void addPicmonics(int count) {
		driver.findElement(By.id("header-playlist-button")).click();

		// create playlist
		driver.findElement(By.id("playlist-dropdown-button")).click();

		driver.findElement(By.id("create-set-item")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("set_name")).clear();
		driver.findElement(By.id("set_name")).sendKeys("xyz");
		driver.findElement(By.id("save_playlist")).click();

		driver.findElement(By.xpath("//button[@class='nav-item']")).click();
		driver.findElement(By.id("header-playlist-button")).click();
		List<WebElement> list = driver.findElements(By.xpath("//i[@class='icon-plus-circle large-icon']/parent::*"));

		if (list != null && list.size() > 0) {
			for (WebElement ele : list) {
				if (count > 0)
					ele.click();
				count--;
			}
		}

		// driver.findElement(By.id("header-playlist-button")).click();
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
