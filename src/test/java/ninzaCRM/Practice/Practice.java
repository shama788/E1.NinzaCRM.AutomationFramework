package ninzaCRM.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Practice {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
 		 driver.manage().window().maximize(); 
 		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 		 driver.get("http://49.249.28.218:8098/");
 		driver.findElement(By.id("username")).sendKeys("rmgyantra");
 		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
 		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
 		 driver.findElement(By.linkText("Contacts")).click();
 		/*driver.findElement(By.id("password")).sendKeys("secret_sauce");
 		driver.findElement(By.id("login-button")).click();
 		driver.findElement(By.xpath("//div[@class='inventory_item_label']/..//button[text()='Add to cart']")).click();
 		driver.findElement(By.id("shopping_cart_container")).click();
 		 Thread.sleep(5000);
		 driver.navigate().back();
 		driver.findElement(By.id("react-burger-menu-btn")).click();
 		driver.findElement(By.linkText("Logout")).click();
 		driver.close();*/

	}

}
