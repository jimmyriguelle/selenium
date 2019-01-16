package Model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Common<LoginPage> {

	// FindBy's
	@FindBy(name = "userName") private WebElement usernameTextField;
	@FindBy(name = "password") private WebElement passwordTextfield;
	@FindBy(name = "login")	private WebElement submitBtn; 
	@FindBy(xpath="//img[@src='/images/masts/mast_signon.gif']") private WebElement login_page_img;
	

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void check_current_page(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(login_page_img));
		MatcherAssert.assertThat(login_page_img.getAttribute("src").toString().equals("http://newtours.demoaut.com/images/masts/mast_signon.gif"), Matchers. equalTo(true));
	}

	public FlightFinderPage loginWith(String email, String password) {
		usernameTextField.sendKeys(email);
		passwordTextfield.sendKeys(password);
		submitBtn.click();
		return new FlightFinderPage(driver);
	}
	
	public FlightFinderPage login_with_basic_user(){
		return loginWith("yosua","yosua");
	}
	
}
