package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	 WebElement country;
	   
	@FindBy(css=".action__submit")
	 WebElement sub;
	   
	@FindBy(xpath="//section[contains(@class,'ta-results')]/button")
	List<WebElement> countries;
	
	
	public void selectCountry(String countryname) {
		
		country.sendKeys(countryname);
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getText().equalsIgnoreCase("india")) {
				countries.get(i).click();
			}
	  }
   }
	
	public ConfirmationPage submitOrder() {
		sub.click();
		ConfirmationPage confirmp=new ConfirmationPage(driver);
		return confirmp;
	}

}
