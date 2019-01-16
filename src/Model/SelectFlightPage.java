package Model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage extends Common<SelectFlightPage> {

	// FindBy's
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input") 
    private WebElement BlueSkiesAirlines361Option;
	
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")
    private WebElement BlueSkiesAirlines631Option;
    
    @FindBy(name= "reserveFlights") private WebElement reserveFlightButton;
	
	// Constructor
	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}
	
	public SelectFlightPage select_basic_flights(){
		this.BlueSkiesAirlines361Option.click();
		this.BlueSkiesAirlines631Option.click();
		return this;
	}
	public BookFlightPage go_to_book_flight_page(){
		this.reserveFlightButton.click();
		return new BookFlightPage(driver);
	}
	
	public static void ddlSelector(int index, WebElement ddl) {
	      Select drop = new Select(ddl);
	      drop.selectByIndex(index);  
	}

	public void check_current_page(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(reserveFlightButton));
		MatcherAssert.assertThat(reserveFlightButton.getAttribute("name").toString().equals("reserveFlights"), Matchers. equalTo(true));
	}
	
}