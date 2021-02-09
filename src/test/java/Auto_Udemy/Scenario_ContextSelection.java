package Auto_Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_ContextSelection {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		By contClick = By.xpath("//span[contains(text(),'right click me')]");

		By listCont = By.xpath("//ul[@class='context-menu-list context-menu-root']//span");

		Element_Util ele_util = new Element_Util(driver);

		ele_util.selectContextMenu(contClick, listCont, "Copy");

	}

}
