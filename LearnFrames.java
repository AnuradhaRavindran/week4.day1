package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement iframe = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		if(text.contains("You pressed OK!"))
		{
			System.out.println("You clicked OK Button");
		}
		
		else
		{
			System.out.println("You clicked Cancel Button");
		}
	}

}
