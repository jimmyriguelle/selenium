package Model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Common<HomePage> {

	// FindBy's
	@FindBy(name = "userName") private WebElement usernameTextField;
	@FindBy(name = "password") private WebElement passwordTextfield;
	@FindBy(name = "login")	private WebElement submitBtn; 
	@FindBy(xpath= "//a[.='SIGN-ON']") private WebElement loginLink;
	@FindBy(xpath= "//a[.='REGISTER']") private WebElement registerLink;
	@FindBy(xpath= "//img[@src='/images/featured_destination.gif']")  private WebElement home_page_lnk;
	

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage(){
		registerLink.click();
		return new RegisterPage(driver);
	}
	
	public HomePage check_current_page(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(home_page_lnk));
		MatcherAssert.assertThat(home_page_lnk.getAttribute("src").toString().equals("http://newtours.demoaut.com/images/featured_destination.gif"), Matchers. equalTo(true));
		return new HomePage(driver);
	}

	public LoginPage loginWith(String email, String password) {
		usernameTextField.sendKeys(email);
		passwordTextfield.sendKeys(password);
		submitBtn.click();
		return new LoginPage(driver);
	}
	
}
