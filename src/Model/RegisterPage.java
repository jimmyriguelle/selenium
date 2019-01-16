package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Common<RegisterPage> {

	// FindBy's
	@FindBy(name = "firstName") private WebElement firstNameTextField;
	@FindBy(name = "lastName") private WebElement lastNameTextField;	
	@FindBy(name = "phone")	private WebElement phoneTextField;	
	@FindBy(name = "userName")	private WebElement emailTextField;	
	@FindBy(name = "address1")	private WebElement address1TextField;
	@FindBy(name = "city")	private WebElement cityTextField;
	@FindBy(name = "state")	private WebElement stateTextField;
	@FindBy(name = "postalCode")	private WebElement postalCodeTextField;
	@FindBy(name = "email")	private WebElement userNameTextField;
	@FindBy(name ="password")	private WebElement passwordTextField;
	@FindBy(name = "confirmPassword")	private WebElement confirmPasswordTextField;
	@FindBy(name = "register")	private WebElement submitBtn;
	@FindBy(name ="country")	private static WebElement countryDDL;
	
	// Constructor
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public RegisterConfirmationPage fill_in_standard() {
		firstNameTextField.sendKeys("jan");
		lastNameTextField.sendKeys("janssens");
		phoneTextField.sendKeys("0496/99.99.99");
		emailTextField.sendKeys("jan.janssens@gmail.com");
		address1TextField.sendKeys("PastoorVerlindenstraat 102 ");
		cityTextField.sendKeys("Burcht");
		postalCodeTextField.sendKeys("2040");
		userNameTextField.sendKeys("Aatrox");
		passwordTextField.sendKeys("Aatrox");
		confirmPasswordTextField.sendKeys("Aatrox");
		RegisterPage.countryViaDropDown(1);
		submitBtn.click();
		return new RegisterConfirmationPage(driver);
	}
	
	public static  void countryViaDropDown(int index) {
	      Select drop = new Select(countryDDL);
	      drop.selectByIndex(index);  
	}
	
}
