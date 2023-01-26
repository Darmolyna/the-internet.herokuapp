import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\darmolyn\\project\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]"))
		.click();
		
		driver.findElement(By.xpath("//input[@id='username']"))
		.sendKeys("tomsmith");
		
		driver.findElement(By.xpath("//input[@id='password']"))
		.sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@id='flash']")).getText(), 
				//"You logged into a secure area!");
		System.out.print(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		
		String ActualTitle = (driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String[] ActualTitlearray = ActualTitle.split("×");
		
		String ExpectedTitle = ActualTitlearray[0].trim();
		Assert.assertEquals(ExpectedTitle, "You logged into a secure area!");
	}

}
