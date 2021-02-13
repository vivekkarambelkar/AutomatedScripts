package Auto_Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_FormFillAndSave {
	
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
		
		Actions action = new Actions(driver);
		
		WebElement contacts = driver.findElement(By.xpath("//div[@id='navmenu']//li/a[contains(text(),'Contacts')]"));
		action.moveToElement(contacts).perform();
		
		WebElement newContact = driver.findElement(By.xpath("//a[@title='New Contact']"));
		newContact.click();
		
		WebElement header = driver.findElement(By.xpath("//fieldset[@class='fieldset']/legend[contains(text(),'Contact Information')]"));
		if(header.getText().equals("Contact Information")) 
		{
			System.out.println("Header " + "\"" + header.getText() + "\"" + " Validated and its correct");
		}
		else
		{
			System.err.println("Header " + "\"" + header.getText() + "\"" + "Validated and its Incorrect");
		}
		
		//Form Fields
		By firstName = By.id("first_name");
		By middleName = By.id("middle_initial");
		By lastName = By.id("surname");
		
		//Title Dropdown
		By title = By.xpath("//select[@name='title']");
		By suffix = By.xpath("//select[@name='suffix']");
		
		Element_Util utility = new Element_Util(driver);
		
		utility.doSelectByVisibleText(title, "Prof.");
		utility.doSendKeys(firstName, "Automation");
		utility.doSendKeys(middleName, "NA");
		utility.doSendKeys(lastName, "World");
		utility.doSelectByVisibleText(suffix, "PhD");
		
		//Image Selection
		WebElement image_select = driver.findElement(By.id("image_file"));
		image_select.sendKeys("D:\\home-library-15.jpg");
		
		
		
		

	}

}


















