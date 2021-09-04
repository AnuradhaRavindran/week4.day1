package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//clicking first contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandlesset = driver.getWindowHandles();
		List<String> windowhandleList = new ArrayList<String>(windowHandlesset);
		driver.switchTo().window(windowhandleList.get(1));
		driver.findElement(By.name("firstName")).sendKeys("Ram");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		WebElement contactId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		String text = contactId.getText();
		System.out.println("Clicked Contact id is : "+text);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.switchTo().window(windowhandleList.get(0));
		//clicking to contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesset1 = driver.getWindowHandles();
		List<String> windowhandleList1 = new ArrayList<String>(windowHandlesset1);
		driver.switchTo().window(windowhandleList1.get(1));
		driver.findElement(By.name("lastName")).sendKeys("Ravi");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		WebElement lastname = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String text2 = lastname.getText();
		System.out.println("Last Name id is : " +text2);
		lastname.click();
		driver.switchTo().window(windowhandleList1.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		String text3 = alert.getText();
		System.out.println("The alert message is : " +text3);
		alert.accept();
		
		String actualTitle = "View Conatct|opentaps CRM";
		String title4 = driver.getTitle();
		if(actualTitle.equals(title4))
		{
			System.out.println("Title Matched");
		}
		else
		{
			System.out.println("Title Matched");
		}
	    
	    
	    driver.close();
	    
	 		
	}

}
