package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.name("filter")).sendKeys("Filter Navigator");
		driver.findElement(By.id("nav_filter_controls")).click();
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("(//span[@class=\"icon icon-search\"])[1]")).click();
		Set<String> windowHandlesset = driver.getWindowHandles();
		List<String> windowhandleList = new ArrayList<String>(windowHandlesset);
		driver.switchTo().window(windowhandleList.get(1));
		WebElement celler = driver.findElement(By.xpath("//a[text()='Abel Tuter']"));
	   // celler.click();
		String text = celler.getText();
		System.out.println(text);
		celler.click();
		driver.switchTo().window(windowhandleList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.name("incident.short_description")).sendKeys("issue with webpage");
		String number = driver.findElement(By.name("sys_original.incident.number")). getAttribute("value");
		System.out.println("The incident record number is : " +number);
		driver.findElement(By.name("not_important")).click();
		driver.findElement(By.xpath("//span[@class='sr-only']/following-sibling::input")).sendKeys(number ,Keys.ENTER);
		String verifyNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(verifyNumber);
		if(number.equals(verifyNumber))
		{
			System.out.println("Number matching");
		}
		else
		{
			System.out.println("Number not matching");
		}
			
		
		File srcl= driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/servicenow.png");
		FileUtils.copyFile(srcl, dst);
		
				
	}

}
