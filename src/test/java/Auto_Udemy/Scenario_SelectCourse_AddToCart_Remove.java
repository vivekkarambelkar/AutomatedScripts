package Auto_Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_SelectCourse_AddToCart_Remove {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Select Network Security course, add to cart and remove from cart
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.udemy.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		By close_header = By.xpath("//div[@data-purpose='smart-bar-container']/descendant::button[@type='button']//*[1]");
		driver.findElement(close_header).click();
		
		By catogories = By.xpath("//span[contains(text(),'Categories')]");
		WebElement categoriesAll = driver.findElement(catogories);
		
		Actions act = new Actions(driver);
		act.moveToElement(categoriesAll).perform();
		
		By first_menu = By.xpath("//div[contains(text(),'IT & Software')]");
		WebElement firstMenu = driver.findElement(first_menu);
		act.moveToElement(firstMenu).perform();
		
		By second_menu = By.xpath("//a[@data-id='134']/div[contains(text(),'Network & Security')]");
		WebElement secondMenu = driver.findElement(second_menu);
		act.moveToElement(secondMenu).perform();
		Thread.sleep(4000);
		By third_menu = By.xpath("//a[@data-id='6906']/div[contains(text(),'Network Security')]");
		WebElement thirdMenu = driver.findElement(third_menu);
		act.moveToElement(thirdMenu).click().build().perform();
		
		By resultHeaderValidation = By.xpath("//h1[contains(text(),'Network Security Courses')]");
		WebElement headerValidation = driver.findElement(resultHeaderValidation);
		if(headerValidation.getText()=="Network Security Courses")
		{
			System.out.println("Header " + "\"" + headerValidation + "\"" + " verified" );
		}
		
		//div[@data-index='1']//*[contains(text(),'Learn Network Hacking From Scratch (WiFi & Wired)')]
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
