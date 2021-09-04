package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium");
		//driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		WebElement source = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dropdwn = new Select(source);
		dropdwn.selectByIndex(2);
		
	}

}
