package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {
	
	
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsby=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmsg=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		//waitForElementToAppear(productsby);
		return products;
		
	}
	
	public WebElement getProductByName(String wantedprod) {
		
		WebElement deisredproduct=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(wantedprod)).findFirst().orElse(null);
		return deisredproduct;
	}
	   
	public void addProductToCart(String wantedprod) {
		
		WebElement deisredproduct= getProductByName(wantedprod);
		deisredproduct.findElement(addToCart).click();
		waitForElementToAppear(toastmsg);
		waitForElementToDisappear(spinner);
		
	}
	   
	   
	   
	  }
