package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> producttitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutle;
	

	public Boolean verifyProductDisplay(String wantedprod ) {
		  
			Boolean match=producttitles.stream().anyMatch(expectedprod->expectedprod.getText().equalsIgnoreCase(wantedprod));
			return match;
	}
	  
	public CheckoutPage goToCheckout() {
		checkoutle.click();
		CheckoutPage coutp=new CheckoutPage (driver);
		return coutp;
	}
	  
	 // driver.findElement(By.cssSelector(".totalRow button")).click();
	   
	   
	   
	   
	  }
