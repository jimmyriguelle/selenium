package Model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterConfirmationPage extends Common<RegisterConfirmationPage> {

	// FindBy's
	@FindBy(xpath = "//img[@src='/images/masts/mast_register.gif']") private WebElement register_conf_img;

	
	// Constructor
	public RegisterConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public void check_current_page(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(register_conf_img));
		MatcherAssert.assertThat(register_conf_img.getAttribute("src").toString().equals("http://newtours.demoaut.com/images/masts/mast_register.gif"), Matchers. equalTo(true));
	}

	
}
