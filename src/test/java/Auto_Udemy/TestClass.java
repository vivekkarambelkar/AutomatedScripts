package Auto_Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By indList = By.xpath("//select[@id='Form_submitForm_Industry']");
		WebElement ind_List = driver.findElement(indList);
		
		//Get the list of drop down options using select class
	}
	
	public static WebElement doFindElement(By locator)
	{
		return driver.findElement(locator);
	}
	


}



















