package Auto_Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);

		By search = By.id("twotabsearchtextbox");
		
		WebElement cookies = driver.findElement(search);
		
		By results = By.xpath("//div[@class='ac_results']//li");
		
		WebElement search_results = driver.findElement(results);
		
		driver.findElement(search).sendKeys("dress");
		
		
		
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(cookies).click().perform();
		
		System.out.println("Coockies accepted");
	}

	public static WebElement doFindElement(By locator) {
		return driver.findElement(locator);
	}

}
