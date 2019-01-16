package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookFlightPage extends Common<BookFlightPage> {

	// FindBy's
  
	//Create elements for fill_in_billing_data - Activity 1
      
	// Constructor
	public BookFlightPage(WebDriver driver) {
		super(driver);
	}
 
    public FlightConfirmationPage fill_in_billing_data(){
    	
    	//Use the elements created in the Activity 1 to fill in all the billing data - activity 2
    	
    	
    }
	
	public static void ddlSelector(int index, WebElement ddl) {
	      //create the dropdown and select by index - Activity 3
	}	
}