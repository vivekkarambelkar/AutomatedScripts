package Auto_Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_SelectCourse_AddToCart_Remove {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Select Network Security course, add to cart and remove from cart

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.udemy.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		By close_header = By
				.xpath("//div[@data-purpose='smart-bar-container']/descendant::button[@type='button']//*[1]");
		driver.findElement(close_header).click();

		By catogories = By.xpath("//span[contains(text(),'Categories')]");
		WebElement categoriesAll = driver.findElement(catogories);
		Actions act = new Actions(driver);
		act.moveToElement(categoriesAll).perform();

		By first_menu = By.xpath("//div[contains(text(),'IT & Software')]");
		WebElement firstMenu = driver.findElement(first_menu);
		act.moveToElement(firstMenu).perform();
//		Thread.sleep(1000);
		By second_menu = By.xpath("//a[@data-id='134']/div[contains(text(),'Network & Security')]");
		WebElement secondMenu = driver.findElement(second_menu);
		act.moveToElement(secondMenu).perform();
		Thread.sleep(1000);
		By third_menu = By.xpath("//a[@data-id='6906']/div[contains(text(),'Network Security')]");
		WebElement thirdMenu = driver.findElement(third_menu);
		act.moveToElement(thirdMenu).click().build().perform();
		Thread.sleep(1000);
		By resultHeaderValidation = By.xpath("//h1[contains(text(),'Network Security Courses')]");
		WebElement headerValidation = driver.findElement(resultHeaderValidation);
		Thread.sleep(1000);
		if (headerValidation.getText().equals("Network Security Courses")) {
			System.out.println("Header " + "\"" + headerValidation.getText() + "\"" + " verified");
		}

		By course = By.xpath(
				"//div[@data-index='1']//*[contains(text(),'Learn Network Hacking From Scratch (WiFi & Wired)')]");
		WebElement courseName = driver.findElement(course);
		act.moveToElement(courseName).perform();

		By addToCart = By.xpath("//div[@data-purpose='add-to-cart']/button[contains(text(),'Add to cart')]");
		WebElement addToCart_button = driver.findElement(addToCart);
		act.moveToElement(addToCart_button).click().build().perform();

		Thread.sleep(3000);

		driver.switchTo().activeElement();

		By goToCart = By.xpath(
				"//div[contains(text(),'Added to cart')]/following::div/button/span[contains(text(),'Go to cart')]");
		WebElement goToCart_button = driver.findElement(goToCart);
		goToCart_button.click();

		Thread.sleep(1000);

		By clickOnCourse = By.xpath(
				"//div[@class='main-content']//a/div[contains(text(),'Learn Network Hacking From Scratch (WiFi & Wired)')]");
		WebElement clickCourse = driver.findElement(clickOnCourse);
		act.moveToElement(clickCourse).click().build().perform();

		Thread.sleep(1000);

		WebElement wishlist = driver.findElement(By.xpath("(//span[contains(text(),'Wishlist')])[1]"));
		act.moveToElement(wishlist).click().build().perform();

		By login = By.xpath("//span[contains(text(),'Log in')]");
		By email = By.id("email--1");
		By password = By.id("id_password");
		By login_button = By.id("submit-id-submit");

		WebElement loginIn = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
		loginIn.click();

		WebElement email_Enter = driver.findElement(email);
		email_Enter.sendKeys("vivek.uk777@gmail.com");

		WebElement password_Enter = driver.findElement(password);
		password_Enter.sendKeys("Protect@12");

		WebElement login_click = driver.findElement(login_button);

		login_click.click();

		Thread.sleep(3000);
		driver.quit();

	}

}
