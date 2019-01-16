package Lineair;

import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mercury_tours  {
    public static void main(String[] args) throws InterruptedException {

    	System.setProperty("webdriver.chrome.driver", "D:\\Users\\AMARQUEZ\\Documents\\masterclass\\drivers\\chromedriver.exe");
    	
    	registreer();	
    	login();
    	update_profile();
    	book_flight();
    	check_flight();
    	
    	Thread.sleep(1000);                 //1000 milliseconds is one second.
    	
    	
    	}
    	
    	public static void registreer() {
    	    	WebElement btn_submit;
				String lbl_confirmation_msg;
    	    	String username= "janjanssens@gmail.com";
    	    	String actualusername = "Note: Your user name is " + username + ".";
    	    	
    	    	System.out.println("Start driver for Registreer");
    		    WebDriver driver = new ChromeDriver();
    		    driver.get("http://newtours.demoaut.com");
    		    
    		    
    		   driver.findElement(By.xpath("//a[.='REGISTER']")).click();
    		   
    		   //wait for form to be available 	(Explicit!!!)    
    	        btn_submit = (new WebDriverWait(driver, 10))
    	        		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='register']")));
    	        
    	        System.out.println("Fill in registation form");
    	        //fill in form
    	        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Jan");
    		    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("Janssens"); 
    		    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("0496999999");   
    		    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Pastoor Verlinderstraat 125");
    		    driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("//");  
    		    driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Berendrecht"); 
    		    driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Antwerpen"); 
    		    driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("2040"); 
    			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username); 
    		    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tester123");  
    		    driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("tester123"); 
    		    new Select (driver.findElement(By.name("country"))).selectByVisibleText("BELGIUM");

    		    //submit the form
    		    btn_submit.click();
    		    
    		    //assert
    		    lbl_confirmation_msg = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
    		    System.out.println(lbl_confirmation_msg);
    		    
    		    System.out.println("Fnish driver for registration");
    		    driver.quit();
    		 }
    	
    	public static void login() throws InterruptedException {
   
    		System.out.println("Start driver for login");
    	    WebDriver driver = new ChromeDriver();
    	    
    	    //go to mtours
    	    driver.get("http://newtours.demoaut.com");
    	    
    	    //define elements
    	    WebElement fld_username = driver.findElement(By.name("userName"));
    	    WebElement fld_pwd      = driver.findElement(By.name("password"));
    	    WebElement btn_submit   = driver.findElement(By.name("login"));
    	    
            //fill in credentials and submit authentication
    	    System.out.println("Authenticate");
    	    fld_username.sendKeys("yosua");
    	    fld_pwd.sendKeys("yosua");
    	    btn_submit.click();
            
    	    //waiting for redirect
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	     
    	    //To assert we are on the correct page find an unique element to this page
    	    WebElement btn_logout =  driver.findElement(By.xpath("//a[@href='mercurysignoff.php']"));
    	    //assert
    	    //MatcherAssert.assertThat(btn_logout.getText().equals("SIGN-OFF"), Matchers.equalTo(true));
    	    System.out.println(btn_logout.getText());
    	    
    	    //clean up driver
    	    driver.quit();
    	    System.out.println("Finish driver for login");
    	  }
    	 
    	public static void update_profile() throws InterruptedException {
    		
    	    //setup driver
    		//System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
    		System.out.println("Start driver for update_profile");
    		WebDriver driver = new ChromeDriver();
    		
    		//go to mtours
    		driver.get("http://newtours.demoaut.com");
    		
    		//authenticate
    		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("yosua");
    		driver.findElement(By.name("password")).sendKeys("yosua");
    		driver.findElement(By.name("login")).click();
    		    
    		//go to update profile page
    		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/a")).click();
    		 
    		System.out.println("Start editting fields");
    		 //fil in form
    		 driver.findElement(By.name("firstName")).sendKeys("Jan");
    		 driver.findElement(By.name("lastName")).sendKeys("Janssens");
    		 driver.findElement(By.name("phone")).sendKeys("0466/66.66.66");
    		 driver.findElement(By.name("address1")).sendKeys("Van Couwervenstraat 66");
    		 driver.findElement(By.name("city")).sendKeys("Berendrecht");
    		 driver.findElement(By.name("state")).sendKeys("Antwerpen");
    		 driver.findElement(By.name("postalCode")).sendKeys("2040");
    		 driver.findElement(By.name("firstName")).sendKeys("Jan");
    		 new Select (driver.findElement(By.name("country"))).selectByVisibleText("NETHERLANDS");
    		 
    		 //assert
    		 driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr[14]/td/a/img")).click();
    		 
    		 System.out.println("Finish driver for update profile");
    		 //clean up driver
    		 driver.quit();
         }

        public static void book_flight() throws InterruptedException {
    		//setup variables
    	    String total_Amount, actual_total_amount;
    	    //setup driver
    		//System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
    	    System.out.println("Start driver for book_flight");
    		ChromeDriver driver = new ChromeDriver();
    		
    	    //go to mtours app
    	    driver.get("http://newtours.demoaut.com");

    	    //authenticate
    	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("yosua");
    	    driver.findElement(By.name("password")).sendKeys("yosua");
    	    driver.findElement(By.name("login")).click();
    		    
    	    //select options for trip
    	    driver.findElement(By.xpath("//input[@value='oneway']")).click();
    	    Select ddl_amnt_passengers = new Select(driver.findElement(By.name("passCount")));
    	    ddl_amnt_passengers.selectByIndex(2);
    	    new Select (driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
    	    new Select (driver.findElement(By.name("fromMonth"))).selectByValue("8");
    	    new Select (driver.findElement(By.name("fromDay"))).selectByValue("8");
    	    new Select (driver.findElement(By.name("toPort"))).selectByVisibleText("Zurich");
    	    new Select (driver.findElement(By.name("toMonth"))).selectByIndex(9);
    	    new Select (driver.findElement(By.name("toDay"))).selectByIndex(8);
    	    new Select (driver.findElement(By.name("airline"))).selectByVisibleText("Pangea Airlines");
    	    driver.findElement(By.xpath("//input[@value='Business']")).click();
    	    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
    	    
    	    //select departure and return flight
    	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input")).click();
    	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")).click();
    	    driver.findElement(By.name("reserveFlights")).click();
    		    
    	    //storing total price for later verification
    	    total_Amount = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b")).getText();
    	   //filling in everything
    	    driver.findElement(By.name("passFirst0")).sendKeys("Jan");
    	    driver.findElement(By.name("passLast0")).sendKeys("Janssens");
    	    driver.findElement(By.name("creditnumber")).sendKeys("123456789");
    	    driver.findElement(By.name("cc_frst_name")).sendKeys("Jan");
    	    driver.findElement(By.name("cc_mid_name")).sendKeys(" ");
    	    driver.findElement(By.name("cc_last_name")).sendKeys("Janssens");
    	    driver.findElement(By.name("billAddress1")).clear();
    	    driver.findElement(By.name("billAddress1")).sendKeys("Pastoor Verlindenstraat");
    	    driver.findElement(By.name("billCity")).clear();
    	    driver.findElement(By.name("billCity")).sendKeys("Berendrecht");
    	    driver.findElement(By.name("billState")).clear();
    	    driver.findElement(By.name("billState")).sendKeys("Antwerpen - Centrum van het Universum");
    	    driver.findElement(By.name("billZip")).clear();
    	    driver.findElement(By.name("billZip")).sendKeys("2000");
    	    driver.findElement(By.name("ticketLess")).click();
    	    driver.findElement(By.name("delAddress1")).clear();
    	    driver.findElement(By.name("delCity")).clear();
    	    driver.findElement(By.name("delState")).clear();
    	    driver.findElement(By.name("delZip")).clear();
    		    
    	    //select values from dropdownlists
    	    new Select (driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Diabetic");
    	    new Select (driver.findElement(By.name("creditCard"))).selectByValue("BA");
    	    new Select (driver.findElement(By.name("billCountry"))).selectByVisibleText("BELGIUM"); 
    		   
    	    //submit
    	    driver.findElement(By.name("buyFlights")).click();
    		    
    	    //assert final price
    	    actual_total_amount = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[12]/td/table/tbody/tr[2]/td[2]/font/b/font/font/b/font")).getText();
    	    total_Amount +=  " USD";
    	    //MatcherAssert.assertThat(total_Amount.equals(actual_total_amount),  Matchers.equalTo(true));
    	    
    	    //clean up driver
    	    System.out.println("Finish driver for book_flight");
    	    driver.quit();
    		}
    	
        public static void check_flight() throws InterruptedException {
    		//setup driver
    		//System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        	System.out.println("start driver for check flight");
    		WebDriver driver = new ChromeDriver();
    		
    		//setup variables
    	    String src_atr;
    	    String expected_result = "http://newtours.demoaut.com/images/itinerary.gif";
    	    
    	    //go to mtours app
    		 driver.get("http://newtours.demoaut.com");
    		 
    		 //authenticate
    		 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("yosua");
    		 driver.findElement(By.name("password")).sendKeys("yosua");
    		 driver.findElement(By.name("login")).click();
    		    
    		 //go to update profile page
    		 driver.findElement(By.xpath("//a[.='ITINERARY']")).click();
    		 
    		 //assert based on atr
    		 src_atr = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).getAttribute("src");
    		 //MatcherAssert.assertThat(src_atr.equals(expected_result+"vxfdf"), Matchers.equalTo(true) );
    		 System.out.println(src_atr + " equals? " + expected_result);

    		 if (src_atr.equals(expected_result)) {
    			 System.out.println("Test case Passed");
    		 }else {
    			 System.out.println("Test case Fail!!!");
    		 }
    		 
    		 //cleanup driver
    		 driver.quit();
    		 System.out.print("finish driver for check flight");
    		}	
    }