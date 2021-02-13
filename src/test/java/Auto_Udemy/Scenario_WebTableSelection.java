package Auto_Udemy;

import java.awt.Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_WebTableSelection {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://classic.freecrm.com/index.cfm?CFID=1715520&CFTOKEN=22810398&jsessionid=4830a618eabb1a965ea06f221252335514d6");
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.xpath("//div[@class='input-group']/input[@name='username']"));
		username.sendKeys("batchautomation");
		
		WebElement password = driver.findElement(By.xpath("//div[@class='input-group']/input[@name='password']"));
		password.sendKeys("Test@12345");
		
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='input-group-btn']/input[@value='Login']"));
		loginButton.click();
		
		driver.switchTo().frame("mainpanel");
		
		WebElement contacts = driver.findElement(By.xpath("//div[@id='navmenu']//li/a[contains(text(),'Contacts')]"));
		contacts.click();
		
		WebElement search_Name = driver.findElement(By.name("cs_name"));
		search_Name.sendKeys("chitra");
		
		WebElement search_button = driver.findElement(By.xpath("//input[@type='submit' and @name='cs_submit']"));
		search_button.click();
		
		selectCheckBox("Chitra Automation");
		//selectCheckBox("Harry ");
		
		////td/child::a[@_name='Chitra Automation']/following::td/following::td/span[contains(text(),'998788889')]
		//By phone = By.xpath("//td/child::a[@_name='Chitra Automation']/following::td/following::td/span");
	}
	
	public static void selectCheckBox(String name)
	{
		By checkBox = By.xpath("//a[@_name='"+name+"']/parent::td/preceding-sibling::td");
		WebElement CheckBox_button = driver.findElement(checkBox);
		CheckBox_button.click();
	}

}



































