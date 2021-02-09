package Auto_Udemy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_OrganceHR_WindowsHandler {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		List<WebElement> social_list = driver.findElements(By.xpath("//div[@id='social-icons']/a"));

		for (int i = 0; i < social_list.size(); i++) {
			social_list.get(i).getAttribute("href");
			social_list.get(i).click();
			Thread.sleep(2000);
		}
		
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> it = windowID.iterator();

		String OrangeWD = it.next();
		System.out.println("OrangeHR window ID is - " + OrangeWD);// CDwindow-C98C78547A18E0A342D07BDAB8CA62A0

		String youtubeWD = it.next();
		System.out.println("LinkedIN window ID is - " + youtubeWD);// CDwindow-A6968E2AE08C45781BBCFA74989D42E5

		String twitterWD = it.next();
		System.out.println("Twitter window ID is - " + twitterWD);// CDwindow-DFBC1E85B7BF1D6CEDEF4DD67118A736

		String facebookWD = it.next();
		System.out.println("Facebook window ID is - " + facebookWD);// CDwindow-FC32D702E53FD9FD3E9928511EB88B3E

		String linkedInWD = it.next();
		System.out.println("Youtube window ID is - " + linkedInWD);// CDwindow-D2057F80FAB4DA69B58900A5B7D20D7E

		driver.switchTo().window(OrangeWD);
		System.out.println(driver.getTitle());
		
		driver.close();

		driver.switchTo().window(facebookWD);
		System.out.println(driver.getTitle());
		
		driver.close();

		driver.switchTo().window(twitterWD);
		System.out.println(driver.getTitle());
		
		driver.close();

		driver.switchTo().window(linkedInWD);
		System.out.println(driver.getTitle());
		
		driver.close();
		

	}

}
