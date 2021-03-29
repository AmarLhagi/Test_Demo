package TravelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakV6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https:/kayak.com");
		driver.findElement(By.cssSelector("svg[aria-label='Flights icon']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Flight destination input']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Flight destination input']"))).build()
		.perform();

		a.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Flight destination input']"))).sendKeys("LAX")
		.doubleClick().build().perform();

		
	}

}
