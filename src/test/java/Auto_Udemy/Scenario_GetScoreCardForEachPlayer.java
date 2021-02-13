package Auto_Udemy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_GetScoreCardForEachPlayer {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(
				"https://www.espncricinfo.com/series/pakistan-women-in-zimbabwe-2020-21-1249282/zimbabwe-women-vs-pakistan-women-1st-match-1249285/full-scorecard");


		
		
//		String WckTaker = wicketTakerName("Ayesha Zafar");
//		System.out.println(WckTaker + '\n');
		
//		List<String> score = playerScoreCard("DA Warner");
//		System.out.print(score);
		
		List<WebElement> highScore = driver.findElements(By.xpath("//td[contains(@class,'batsman-cell text-truncate')]/parent::tr"));
		System.out.println(highScore.size());
		
		for(int i=0; i<highScore.size(); i++)
		{
			
			System.out.println(highScore.get(i).getText());
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();
		}
	
		public static String wicketTakerName(String name)
		{
			String xpath = "//a[text()='"+name+"']/parent::td/following-sibling::td[@class='text-left']";
			String wicketTakerName = driver.findElement(By.xpath(xpath)).getText();
			return wicketTakerName;
		}
		
		public static List<String> playerScoreCard(String playerName)
		{
			List<String> scoreCardList = new ArrayList<String>();
			List<WebElement> scorecard = driver.findElements(By.xpath("//a[text()='"+playerName+"']/parent::td/following-sibling::td"));
			
			for(int i=1; i<scorecard.size(); i++)
			{
				scoreCardList.add(scorecard.get(i).getText());
				
			}
			return scoreCardList;
		}
	
}
