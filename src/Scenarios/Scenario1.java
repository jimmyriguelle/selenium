package Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Model.BookFlightPage;
import Model.FlightFinderPage;
import Model.HomePage;
import Model.LoginPage;
import Model.SelectFlightPage;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\AMARQUEZ\\Documents\\masterclass\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		new HomePage(driver)
			.navigateToLoginPage()
			.loginWith("yosua", "yosua")
		    .fill_in_details()
        	.select_basic_flights()
        	.go_to_book_flight_page();
        //Create an object for BookFlightPage and call the method fill_in_billing_data  - Exercise 4
        Thread.sleep(1000);
		driver.quit();
	}
}
