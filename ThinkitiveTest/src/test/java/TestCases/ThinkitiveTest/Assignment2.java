package TestCases.ThinkitiveTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Assignment2 {
	
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	Actions act;
	
	@Test(priority=1)
	public void init() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		prop=new Properties();
		fis=new FileInputStream("C:\\Users\\Vivek\\eclipse-workspace\\ThinkitiveTest\\src\\test\\java\\TestCases\\ThinkitiveTest\\Data.properties");
		prop.load(fis);
		
		act=new Actions(driver);
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority=2)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("searchInput")).sendKeys("jeans ");
		Thread.sleep(10000);
		act.sendKeys(Keys.ENTER);
		act.build().perform();
	}
	@Test(priority=3)
	public void getProductDetails() {
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='_1kMS']/span"));
		//System.out.println(list.size());
		//System.out.println(list);
		ArrayList<Integer> price=new ArrayList<Integer>();
		for(WebElement element:list) {
			String s=element.getText();
			s=s.replace(",", "");
			price.add(Integer.parseInt(s));
		}
		
	//	System.out.println("---------Beforesorting------"+"\n"+price);
		Collections.sort(price);
		System.out.println("---------AfterSorting-------"+price);
		System.out.println("Highest Price of Jeans is = "+price.get(price.size()-1));
	}
	
}
