package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebTest
{
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}
	
// Test Case to test "The participant count of "Frustration of Software Developers" is 55"
	
	@Test
	public void ParticipantCount() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> parCount = driver.findElements(By.xpath("//span[.='Frustration of Software Developers']/parent::h3/parent::div/parent::div//span[@data-bind=\"text: votes\"]"));

		assertEquals("55", parCount.get(0).getText());
	}

// Test Case to test "The total number of studies closed is 5."
	
	@Test
	public void StatusClosed() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> statusClosed = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));

		assertNotNull(statusClosed);
		assertEquals(5, statusClosed.size());
	}
	
// Test Case to test "If a status of a study is open, you can click on a "Participate" button."
	
	@Test
	public void StatusOpenParticipate() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> participate = driver.findElements(By.xpath("//a[@class='status']/span[.='OPEN']/parent::a/parent::div//button[.='Participate']"));

		assertEquals(true, participate.get(0).isEnabled());
	}

// Test Case to test "Check if the "Software Changes Survey" has a Amazon reward image."
	
	@Test
	public void AmazonReward() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> amazonReward = driver.findElements(By.xpath("//span[ .='Software Changes Survey']/parent::h3/parent::div//img[@data-bind='attr: {src: awardImg}']"));

		assertEquals("http://www.checkbox.io/media/amazongc-micro.jpg", amazonReward.get(0).getAttribute("src"));
	}

}
