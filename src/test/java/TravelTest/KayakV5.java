package TravelTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakV5 {

	public static void main(String[] args) throws InterruptedException {
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

		a.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Flight destination input']"))).sendKeys("DAC")
		.doubleClick().build().perform();

		a.moveToElement(driver.findElement(By.xpath("//li[@aria-label='Dhaka, Bangladesh - Zia Intl - Airport']")))
		.doubleClick().build().perform();

		a.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Departure date input']"))).doubleClick().build()
		.perform();

		String dmonth = "March 2021";
		String dday = "29";
		String amonth = "November 2021";
		String aday = "15";

		while (true) {
			String text = driver.findElement(By.xpath("(//div[@class='_ijM _iAr _iaB _idE _iXr'])[3]")).getText();

			if (text.equals(dmonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id='stl-jam-cal-nextMonth']")).click();

			}
		}

		driver.findElement(By.xpath("(//div[contains(@class,'month ')]//div[contains(text()," + dday + ")])[3]"))
		.click();

		while (true) {
			String text = driver.findElement(By.xpath("(//div[@class='_ijM _iAr _iaB _idE _iXr'])[3]")).getText();

			if (text.equals(amonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id='stl-jam-cal-nextMonth']")).click();
			}

			driver.findElement(By.xpath("(//div[contains(@class,'month ')]//div[contains(text()," + aday + ")])[3]"))
			.click();

			a.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).doubleClick().build().perform();

			String homePage = driver.getWindowHandle();
			System.out.println(homePage);
			Thread.sleep(10000);

			Set<String> windows = driver.getWindowHandles();
			System.out.println(windows.size());

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println(windows.size());

			a.moveToElement(driver.findElement(By.xpath("//body"))).doubleClick().build().perform();

			driver.findElement(By.xpath("//a[@data-sort='price_a']")).click();

			System.out.println(driver.findElement(By.xpath("//div[@id='searchResultsList']")).getSize());

			System.out.println(driver.findElement(By.xpath("//div[@id='searchResultsList']")).getText());
		}

	}

}
