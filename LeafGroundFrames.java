package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		int size = frame.size();
		System.out.println(size);
		WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]/iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		File srcl= driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./frame/frampic.png");
		FileUtils.copyFile(srcl, dst);
		driver.switchTo().defaultContent();
		
		
			
		}
		 
		
		
		

	}


