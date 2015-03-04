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

public class EditProfile {
	  private static WebDriver driver;
	  private static String baseUrl;
	  private boolean acceptNextAlert = true;
	  private static StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass
	  public static void classSetup(){
			driver = new FirefoxDriver();
		    baseUrl = ApplicationConstants.BASEURL;
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
		    //Login code
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
  public void testBiographyWith150Characters() throws Exception {
    
	  	driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
	    driver.findElement(By.name("biography")).clear();
	    driver.findElement(By.name("biography")).sendKeys("A picture is worth a thousand words. Picmonic takes that literally, by turning the information you need to know into unforgettable images and stories ");
	    assertEquals("0 characters left", driver.findElement(By.cssSelector("div.chars_left")).getText());
	    assertEquals("Biography", driver.findElement(By.xpath("//div[@class='margin-added aligned']//label")).getText());
	    driver.findElement(By.xpath("//div[@id='edit-form']//button[@class='btn btn-blue save']")).click();
	    assertTrue(isElementPresent(By.cssSelector("div.msg")));
	    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  
  @Test
  public void testInvalidCharactersInPnoneNumber() throws Exception {
   
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("abc1234");
    driver.findElement(By.xpath("//div[@id='edit-form']//button[@class='btn btn-blue save']")).click();
    assertTrue(isElementPresent(By.cssSelector("div.msg")));
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  
  @Test
  public void testInvalidEmailAddress() throws Exception {
   
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    driver.findElement(By.id("primary-email")).clear();
    driver.findElement(By.id("primary-email")).sendKeys("pkedar");
    driver.findElement(By.xpath("//div[@id='edit-form']//button[@class='btn btn-blue save']")).click();
    assertTrue(isElementPresent(By.cssSelector("div.msg")));
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }

  @Test
  public void testRemoveProfilePicture() throws Exception {
    
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    assertEquals("Remove", driver.findElement(By.id("remove-picture")).getText());
    driver.findElement(By.id("remove-picture")).click();
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  
  @Test
  public void testSaveProfile() throws Exception {
    
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    driver.findElement(By.name("first_name")).click();
    driver.findElement(By.name("ko_unique_1")).click();
    new Select(driver.findElement(By.id("country-id"))).selectByVisibleText("India");
    new Select(driver.findElement(By.id("market-name"))).selectByVisibleText("Medicine");
    driver.findElement(By.cssSelector("option[value=\"100\"]")).click();
    new Select(driver.findElement(By.id("school-name"))).selectByVisibleText("All Saints University School of Medicine");
    new Select(driver.findElement(By.id("grad-month"))).selectByVisibleText("January");
    new Select(driver.findElement(By.id("grad-year"))).selectByVisibleText("2020");
    driver.findElement(By.xpath("//div[@id='edit-form']//button[@class='btn btn-blue save']")).click();
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  
  @Test
  public void testEditProfile() throws Exception {
    
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    assertTrue(isElementPresent(By.cssSelector("div.bar.tip")));
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  
  @Test
  public void testUploadProfilePicture() throws Exception {
   
    driver.findElement(By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]")).click();
    assertEquals("Upload", driver.findElement(By.id("upload-picture")).getText());
    driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  @Test
  public void testEmptyFirstName() throws Exception {
    
	  
		driver.findElement(
				By.xpath("//div[@class='nav-item'][contains(text(),'Edit Profile')]"))
				.click();
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys("");
		driver.findElement(
				By.xpath("//div[@id='edit-form']//button[@class='btn btn-blue save']"))
				.click();
		assertTrue(isElementPresent(By.cssSelector("div.msg")));
		driver.findElement(By.xpath("//button//i[@class='icon-bars']")).click();
  }
  

  @After
  public void tearDown() throws Exception {
    
  }

  @AfterClass
  public static void classTeardown(){
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
