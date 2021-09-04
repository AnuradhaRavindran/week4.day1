package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcFlights {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']")).click();
		driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
		Set<String> windowHandlesset1 = driver.getWindowHandles();
		List<String> windowhandleList1 = new ArrayList<String>(windowHandlesset1);
		driver.switchTo().window(windowhandleList1.get(1));
		String text = driver.findElement(By.xpath("(//div[@class='block-nav-right d-none d-md-block'])[2]")).getText();
		System.out.println(text);
		driver.close();
		driver.switchTo().window(windowhandleList1.get(0));
		String title = driver.getTitle();
		System.out.println(title);

	}

}
