package Auto_Udemy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_Chrome_Naukri_WindowsHandler {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> naukri = driver.getWindowHandles();
		Iterator<String> it = naukri.iterator();
		
		String parentWD = it.next();
		System.out.println("ParentWD - " + parentWD);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("***************************************");
		
		String window1 = it.next();
		System.out.println("Window1 - " + window1);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("***************************************");
		
		String window2 = it.next();
		System.out.println("Window2 - " + window2);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("***************************************");
		
		String window3 = it.next();
		System.out.println("Window3 - " + window3);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("***************************************");
		
		driver.switchTo().window(window3);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		
		driver.switchTo().window(window2);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		
		driver.switchTo().window(window1);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		
		driver.switchTo().window(parentWD);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebElement later = driver.findElement(By.id("block"));
		later.click();
		
		
		driver.quit();

	}

}
