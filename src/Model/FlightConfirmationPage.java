package Model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage extends Common<FlightConfirmationPage> {

	// FindBy's
	@FindBy(xpath ="//a[@href='mercurysignoff.php']") private WebElement btn_logout;
	@FindBy(xpath ="//img[@src='/images/masts/mast_confirmation.gif']") private WebElement FlightConfImg;
	@FindBy(xpath ="//img[@src='/images/forms/backtoflights.gif']") private WebElement btn_back_to_flight;
	@FindBy(xpath ="//img[@src='/images/forms/backtoflights.gif']") private WebElement btn_back_to_home;
	@FindBy(xpath ="//img[@src='/images/forms/Logout.gif']") private WebElement btn_log_out;
	@FindBy(xpath = "//img[@src='/images/featured_destination.gif']") private WebElement configrmation_img;
	
  
	// Constructor
	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public FlightFinderPage go_to_flight_finder_page(){
		this.btn_back_to_flight.click();		
		return new FlightFinderPage(driver);
	}
	
	public HomePage go_to_homepage(){
		this.go_to_homepage();
		return new HomePage(driver);
	}
	public LoginPage go_to_login_page(){
		this.go_to_login_page();
		return new LoginPage(driver);
	}
	
	public void check_page(){
		//To assert we are on the correct page find an unique element to this page
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(configrmation_img));
		//assert
	    MatcherAssert.assertThat(configrmation_img.getAttribute("src").toString().equals("http://newtours.demoaut.com/images/featured_destination.gif"), Matchers. equalTo(true));
	}
}