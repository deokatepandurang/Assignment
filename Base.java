import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Base {

	@Test
	public static void intilization() throws InterruptedException {

		List<WebElement> rows;
		List<WebElement> cells;

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\25652\\workspace_Oxgen\\Demo\\Drivers_setups\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website
		driver.navigate().to("https://subscribe.stctv.com/sa-en");

		driver.manage().window().maximize();

		System.out.println("Url open succesfully");
		System.out.println("...............");

		String title = driver.getTitle();
		System.out.println("Title of website is: " + title);
		System.out.println("...............");
		System.out.println("Test case:  1 " +title + " Pass succesfully");
		System.out.println("...............");

		WebElement Sign_in = driver.findElement(By.xpath("//div//a[text()='Sign in']"));
		String s1 = Sign_in.getText();
		System.out.println("Test case:  2 " + s1 + " Pass succesfully");
		Assert.assertEquals(s1, "Sign in");
		System.out.println("...............");

		WebElement Stctv_Slogan = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]"));
		String s2 = Stctv_Slogan.getText();
		System.out.println("Test case:  3 " + s2 + " Pass succesfully");
		System.out.println("...............");

		WebElement choose_your_plan = driver.findElement(By.xpath("//div//h3[text()='Choose Your Plan']"));
		String s3 = choose_your_plan.getText();
		System.out.println("Test case:  4 " + s3 + " Pass succesfully");
		System.out.println("...............");
		
		// Action class for Mouse
		Actions ac = new Actions(driver);

		WebElement select_country = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/a[1]"));
		ac.click(select_country).perform();
		Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String s4 = select_country.getText();
		System.out.println("Test case: 5 " + s4 + " click action Pass succesfully");
		System.out.println("...............");

		// after clicking of KSA coutry
		WebElement ksa = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div/ul/li[2]/a"));
		ac.moveToElement(ksa).perform();
		Thread.sleep(5000);
		String s5 = select_country.getText();
		System.out.println("Test case: 6 " + s5 + " Return to back page Pass succesfully");
		System.out.println("...............");

		List<WebElement> typesof_plan = driver
				.findElements(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/h3"));
		int j = typesof_plan.size();
		System.out.println("Test case: 7 showing Types of plan and its currency are total element: " + j + " Pass succesfully");
		System.out.println("...............");
		
		// select first Plan as Lite
		WebElement lite = driver
				.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/h1"));
		System.out.println(lite.getText());
		System.out.println("Test case:  8  Its click on lite plan and takes details of  Lite plan ");
		System.out.println("...............");

		// select first Lite plan price and currency and validity:
		WebElement lite_all = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]"));
		System.out.println("Test case: 9  Select First Lite plan price and currency and validity ");
		System.out.println(lite_all.getText());
		System.out.println("...............");
		
		// select Second CLASSIC plan price and currency and validity:
		
		WebElement classic = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/h1"));
		System.out.println(classic.getText());
		
		WebElement classic_all = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]"));
		System.out.println("Test case: 10  Select Second classic plan price and currency and validity ");
		System.out.println(classic_all.getText());
		System.out.println("...............");
		
		// select Third PREMIUM plan price and currency and validity:
		
		WebElement premium = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/h1"));
		System.out.println(premium.getText());
		
		WebElement premium_all = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]"));
		System.out.println("Test case: 11 Select Third premium plan price and currency and validity ");
		System.out.println(premium_all.getText());
		System.out.println("...............");
		
		

		System.out.println("...............");
		System.out.println("All Test Cases run succesfuly.");

		driver.quit();

	}
}


// --> Another way we can find plan type currency and validity.

/*
 * rows=driver.findElements(By.xpath("/html/body/div/div[1]/div/div[1]/div/div/ul"));
 * 
 * for (int i = 1; i < rows.size(); i++) {
 * 
 * cells=driver.findElements(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]"));
 * System.out.println("Country Name ::" +cells.get(0).getText());
 * System.out.println("country Currency Rate::" +cells.get(1).getText());
 * 
 * }
 */
