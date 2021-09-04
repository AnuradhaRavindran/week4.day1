package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(1000);
		alert.dismiss();
		String text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(text);
		if(text.contains("You pressed Cancel!"))
		{
			System.out.println("you clicked cancel");
		}
		else
			System.out.println("You clicked ok");
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		alert.sendKeys("Edu");
		//Thread.sleep(1000);
		//String text2 = alert.getText();
		//System.out.println(text2);
		//String text3 = driver.findElement(By.xpath("//p[@id='result1']")).getText();
		//System.out.println(text3);
		alert.accept();
		String text3 = driver.findElement(By.xpath("//p[@id='result1']")).getText();
		System.out.println(text3);
		
		

	}

}
