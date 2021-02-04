package Auto_Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Element_Util {
	
	WebDriver driver;
	
	public Element_Util(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Udemy Elements
	By login = By.xpath("//span[contains(text(),'Log in')]");
	By email = By.id("email--1");
	By password = By.id("id_password");
	By login_button = By.id("submit-id-submit");
	
	//Warning Messages
	By login_Fail = By.xpath("//div[contains(text(),'There was a problem logging in. Check your email and password or create an account.')]");
	
	By categories = By.xpath("//span[@class='udlite-text-sm header--dropdown-button-text--2jtIM' and contains(text(),'Categories')]");
	By sm_Development = By.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'Development')]");
	By sm_sm_WebDevelopment = By.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'Web Development')]");
	By sm_3_JavaScript = By.xpath("//div[@class='udlite-block-list-item-content' and contains(text(),'JavaScript')]");
	
	//Search 
	By search = By.xpath("//input[@placeholder='Search for anything']");
	
	//Search options
	By searchOptions = By.xpath("//ul[@class='unstyled-list udlite-block-list js-suggestions udlite-search-form-autocomplete-suggestions']//div[@class='udlite-block-list-item-content']");
	By result_Header = By.xpath("//h1[@class='udlite-heading-xxl' and contains(text(),'computer networking')]");
	
	//Image element
	By topCatagories = By.xpath("//div[@class='top-categories--category-card--3gl2q category-card--category-card--3x2z6']/a");
	
	//**************** Common Methods ****************************************************************************************
	
	//Web Element
	public WebElement doFindElement(By locator)
	{
		return driver.findElement(locator);
	}
	// List of Web Elements
	public List<WebElement> doFindElementS(By locator)
	{
		return driver.findElements(locator);
	}
	// Send key method
	public void doSendKeys(By locator, String value)
	{
		doFindElement(locator).sendKeys(value);
	}
	//click method
	public void doClick(By locator)
	{
		doFindElement(locator).click();
	}
	//Get text method
	public String doGetText(By locator)
	{
		String warningMsg = doFindElement(locator).getText();
		if(warningMsg.equals("There was a problem logging in. Check your email and password or create an account."))
		{
			System.err.println("**ERROR MESSAGE** --> " + "There was a problem logging in. Check your email and password or create an account.");
		}
		return warningMsg;
	}
	//Find the text using attributes
	public void findTextandClick(By locator, String Attrbt, String value)
	{
		List<WebElement> find_Click = doFindElementS(locator);
		System.out.println("Top catogories options are - " + find_Click.size());
		
		for(WebElement cat : find_Click)
		{
			
			String app_Element = cat.getAttribute(Attrbt);
			//String elmentText = cat.getText();
			System.out.println("--> " + app_Element);
			
			if(app_Element.equals(value))
			{
				cat.click();
				break;
			}
		}
	}
	//Action class with 3 level sub-menu option
	public void Level_3_MenuSelect(By locator, By locator1, By locator2, By locator3)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(doFindElement(locator)).perform();
		act.moveToElement(doFindElement(locator1)).perform();	
		act.moveToElement(doFindElement(locator2)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		act.moveToElement(doFindElement(locator3)).click().build().perform();
	}
	//Search keyword and select
	public void searchAndSelect(By locator, String value)
	{
		List<WebElement> Search_Options = doFindElementS(locator);

		for (WebElement e : Search_Options) 
		{
			String search_Opt = e.getText();
			System.out.println(search_Opt);

			if (search_Opt.equals(value)) 
			{
				e.click();
				break;
			}
		}	
	}
	//Verify Search results
	public void searchResultVerify(By locator)
	{
		if (doFindElement(locator).isDisplayed()) {
			System.out.println(
					"Message displayed after search result is -> " + doFindElement(locator).getText());
		} else {
			System.err.println("Incorrect Text Displayed");
		}
	}
	
	//******** Drop down Utilities ****************************
	
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(doFindElement(locator));
		select.selectByValue(value);

	}

	public void doSelectByIndex(By locator, int indexNo) {
		Select select = new Select(doFindElement(locator));
		select.selectByIndex(indexNo);

	}

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(doFindElement(locator));
		select.selectByVisibleText(text);

	}
	
	// Select drop down option without using select class
	public List<WebElement> selectDDWithoutSelect(By locator, String text) {
		List<WebElement> dropdownList = doFindElementS(locator);
		System.out.println("Options under Industry dropdown are - " + dropdownList.size());
		for (WebElement e : dropdownList) {
			if (e.getText().equals(text)) {
				e.click();
				break;
			}
		}
		return dropdownList;
	}
	
	//Select drop down using select class
	public void doSelectDropDown(By locator, String text)
	{
		Select select = new Select(doFindElement(locator));
		List<WebElement> list = select.getOptions();
		
		System.out.println(list.size());
		
		for(WebElement e : list)
		{
			if(e.getText().equals(text))
			{
				e.click();
				break;
			}
		}
	}

	
//	public void selectSearchOptions()
//	{
//		doFindElement(searchOptions).getText()
//	}

}


















