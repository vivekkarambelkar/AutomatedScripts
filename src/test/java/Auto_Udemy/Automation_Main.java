package Auto_Udemy;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Automation_Main {

	public static void main(String[] args) throws InterruptedException {

		Browser_Util br_launch = new Browser_Util();
		WebDriver driver = br_launch.browserLuanch("Chrome");

		driver.get("https://www.udemy.com/");

		// ************ Elements ************//

		// Login
		By login = By.xpath("//span[contains(text(),'Log in')]");
		By email = By.id("email--1");
		By password = By.id("id_password");
		By login_button = By.id("submit-id-submit");

		// Invalid credentials validation
		By login_Fail = By.xpath(
				"//div[contains(text(),'There was a problem logging in. Check your email and password or create an account.')]");

		// Search
		By search = By.xpath("//input[@placeholder='Search for anything']");

		// Search options
		By searchOptions = By.xpath(
				"//ul[@class='unstyled-list udlite-block-list js-suggestions udlite-search-form-autocomplete-suggestions']//div[@class='udlite-block-list-item-content']");

		// Searched result text
		By result_Header = By
				.xpath("//h1[@class='udlite-heading-xxl' and contains(text(),'aws certified advanced networking')]");

		// Image element
		By topCatagories = By
				.xpath("//div[@class='top-categories--category-card--3gl2q category-card--category-card--3x2z6']/a");

		// Headers
		By categories = By.xpath(
				"//span[@class='udlite-text-sm header--dropdown-button-text--2jtIM' and contains(text(),'Categories')]");
		By sm_Development = By
				.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'Development')]");
		By sm_sm_WebDevelopment = By
				.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'Web Development')]");
		By sm_3_JavaScript = By
				.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'JavaScript')]");

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Element_Util elmnt_util = new Element_Util(driver);

		Thread.sleep(1000);

		elmnt_util.findTextandClick(topCatagories, "href", "https://www.udemy.com/courses/it-and-software/");

		// Login into application

		Thread.sleep(3000);
		elmnt_util.doClick(login);
		elmnt_util.doSendKeys(email, "vivek.uk777@gmail.com");
		elmnt_util.doSendKeys(password, "Protect@12");
		elmnt_util.doClick(login_button);

		// Warning message validation
		// elmnt_util.doGetText(login_Fail);

		Thread.sleep(1000);

		elmnt_util.Level_3_MenuSelect(categories, sm_Development, sm_sm_WebDevelopment, sm_3_JavaScript);

		Thread.sleep(1000);

		// Search keyword and select
		elmnt_util.doSendKeys(search, "networking");

		Thread.sleep(1000);

		elmnt_util.searchAndSelect(searchOptions, "aws certified advanced networking");

		Thread.sleep(2000);

		elmnt_util.searchResultVerify(result_Header);

		driver.quit();

	}

}
