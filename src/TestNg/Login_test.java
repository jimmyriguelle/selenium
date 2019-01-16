package TestNg;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Login_test {
  @Test
  public void test_login() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Users\\AMARQUEZ\\Documents\\masterclass\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Go to demo app");
	    driver.get("http://newtours.demoaut.com");
	    
	    //define elements
	    WebElement userNameInput = driver.findElement(By.cssSelector("[name = 'userName']"));
	    WebElement passwordInput      = driver.findElement(By.name("password"));
	    WebElement loginButton   = driver.findElement(By.name("login"));
	   
	    
	  //fill in credentials and submit authentication
	    System.out.println("Authenticate");
	    userNameInput.sendKeys("yosua");
	    passwordInput.sendKeys("yosua");
	    loginButton.click();
	  
	    //waiting for redirect
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //To assert we are on the correct page find an unique element to this page
	    
	    //assert
	    WebElement btn_logout =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
	    System.out.println(btn_logout.getText());
	    
	    //org.testng.Assert.fail("I failed this TEST case on porpuse");
	    
	    //clean up driver
	    driver.quit();
	    System.out.println("Finish driver for login");    
  }
}
