package Auto_Udemy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_FireFox_Naukri_WindowsHandler {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		
//		FirefoxOptions firefox = new FirefoxOptions();
//		firefox.addArguments("--headless");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(3000);
		
		Set<String> naukri = driver.getWindowHandles();
		Iterator<String> it = naukri.iterator();
		
		String parentWD = it.next();
		driver.manage().window().maximize();
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
