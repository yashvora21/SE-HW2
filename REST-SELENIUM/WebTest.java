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

	@Test
	public void Closed() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));

		assertNotNull(spans);
		assertEquals(5, spans.size());
	}

	@Test
	public void ParticipantCount() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//span[.='Frustration of Software Developers']/parent::h3/parent::div/parent::div//span[@data-bind=\"text: votes\"]"));

		assertEquals("55", spans.get(0).getText());
	}
	
	@Test
	public void StatusOpenParticipate() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='OPEN']/parent::a/parent::div//button[.='Participate']"));

		assertEquals(true, spans.get(0).isEnabled());
	}

	@Test
	public void AmazonReward() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//span[ .='Software Changes Survey']/parent::h3/parent::div//img[@data-bind='attr: {src: awardImg}']"));

		assertEquals("http://www.checkbox.io/media/amazongc-micro.jpg", spans.get(0).getAttribute("src"));
	}
	
	
}
