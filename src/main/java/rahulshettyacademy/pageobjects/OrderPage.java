package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child[3]")
	List<WebElement> productnames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutle;
	

	public Boolean verifyOrderDisplay(String wantedprod ) {
		  
			Boolean match=productnames.stream().anyMatch(expectedprod->expectedprod.getText().equalsIgnoreCase(wantedprod));
			return match;
	}
	
  }
