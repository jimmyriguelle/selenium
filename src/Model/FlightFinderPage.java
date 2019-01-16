package Model;

import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderPage extends Common<FlightFinderPage> {

	// FindBy's
	@FindBy(xpath ="//a[@href='mercurysignoff.php']") private WebElement btn_logout;
    @FindBy(xpath = "//input[@value='oneway']") private WebElement oneWayRadioButton;
	@FindBy(xpath = "//input[@value='Business']") private WebElement buisnessRadioButton;
	@FindBy(xpath = "//input[@name='findFlights']") private WebElement findFLightsButton;
	@FindBy(xpath= "//img[@src='/images/masts/mast_flightfinder.gif']") private WebElement FlightFinderImg; 
	@FindBy(name ="passCount") private WebElement passCountDDL;
	@FindBy(name ="fromPort") private WebElement fromPortDDL;
	@FindBy(name ="fromMonth") private WebElement fromMonthDDL;
	@FindBy(name ="fromDay") private WebElement fromDayDDL;
	@FindBy(name ="toPort") private WebElement toPortDDL;
	@FindBy(name ="toMonth") private WebElement toMonthDDL;
	@FindBy(name ="toDay") private WebElement toDayDDL;
	@FindBy(name ="airline") private WebElement airlineDDL;
	@FindBy(name = "lastName") private WebElement lastNameTextField;	
	
	// Constructor
	public FlightFinderPage(WebDriver driver) {
		super(driver);
	}
	
	public SelectFlightPage fill_in_details(){
		this.oneWayRadioButton.click();
		this.buisnessRadioButton.click();
		this.ddlSelectorByIndex(this.passCountDDL, 2);
		this.ddlSelectorByIndex(fromPortDDL, 2);
		this.ddlSelectorByIndex(fromMonthDDL, 2);
		this.ddlSelectorByIndex(fromDayDDL, 2);
		this.ddlSelectorByIndex(toPortDDL, 2);
		this.ddlSelectorByIndex(toMonthDDL, 2);
		this.ddlSelectorByIndex(toDayDDL, 2);
		this.ddlSelectorByIndex(airlineDDL, 2);
		this.findFLightsButton.click();
		return new SelectFlightPage(driver);
	}
		
	public static void ddlSelectorByIndex( WebElement ddl, int index) {
	      Select drop = new Select(ddl);
	      drop.selectByIndex(index);  
	}
	
	public FlightFinderPage check_page() throws InterruptedException{
		//To assert we are on the correct page find an unique element to this page
	    //wait
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(FlightFinderImg));
		//assert
	    MatcherAssert.assertThat(FlightFinderImg.getAttribute("src").toString().equals("http://newtours.demoaut.com/images/masts/mast_flightfinder.gif"), Matchers. equalTo(true));
		return new FlightFinderPage(driver);
	}
	
}