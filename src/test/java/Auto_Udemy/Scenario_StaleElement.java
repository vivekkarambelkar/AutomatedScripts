package Auto_Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_StaleElement {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://demo.opencart.com/index.php?route=account/login");
//		
//		WebElement email = driver.findElement(By.id("input-email"));
		
		//If we refresh a page in between two elements, the last element shows stale element exception, 
		//because element ID changes on refresh
//		email.sendKeys("Vivek_Karambelkar20@gmail.com");
//		Thread.sleep(2000);
//		//email.clear();
//		driver.navigate().refresh();
//		email.sendKeys("testing@gmail.com");
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		List<WebElement> storeList = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		
		System.out.println("List options are -> " + storeList.size());
		
		for(int i=storeList.size()-1; i>0; i--)
		{
			storeList.get(i).click();
			driver.navigate().back();
			storeList = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		}
		
		driver.quit();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		
		
		List<WebElement> gFooterList = driver.findElements(By.xpath("//span[@id='fsl']/a"));
		
		for(int i=0; i<gFooterList.size(); i++)
		{
			gFooterList.get(i+1).click();
			driver.navigate().back();
			gFooterList = driver.findElements(By.xpath("//span[@id='fsl']/a"));
		}
		
		driver.quit();
		
	}

}
