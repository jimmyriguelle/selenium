package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Common<T> {
	// Fields
	protected WebDriver driver;
	@FindBy(xpath= "//a[.='SIGN-ON']") private WebElement loginLink;

	// Constructor
	public Common(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage navigateToLoginPage() {
		loginLink.click();
		return new LoginPage(driver);
	}
}
