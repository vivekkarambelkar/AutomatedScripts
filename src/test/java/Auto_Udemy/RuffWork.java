package Auto_Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RuffWork {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("**********************");
		
		Thread.sleep(3000);
		
		By list = By.xpath("//span[@id='fsl']/a");
		
		List<WebElement> g_footerall = driver.findElements(list);
		

		
		for(int i=0; i<g_footerall.size(); i++)
		{
			String glist = g_footerall.get(i).getText();
			
		}
		

		
		////label[@class='udlite-toggle-input-container udlite-text-sm']/input[@name='courseLabel']
		
		
	}

	

}


//		
//By g_Footer = By.linkText("Advertising");
//By g_Footer1 = By.linkText("Business");
//By g_Footer2 = By.linkText("Business");
//By g_Footer3 = By.linkText("About");

		
//driver.findElement(g_Footer).click();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//System.out.println("**********************");
//
//driver.navigate().back();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//System.out.println("header closed");
//
//System.out.println("**********************");
//
//driver.findElement(g_Footer1).click();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//driver.navigate().back();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//System.out.println("**********************");
//
//driver.findElement(g_Footer2).click();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//driver.navigate().back();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//System.out.println("**********************");
//
//driver.findElement(g_Footer3).click();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//driver.navigate().back();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
//
//System.out.println("**********************");
	
		
		
		
		
