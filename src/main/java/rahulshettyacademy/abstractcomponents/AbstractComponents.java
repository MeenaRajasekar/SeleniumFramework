package rahulshettyacademy.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {
	
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//i[contains(@class,'cart')]")
	WebElement carticon;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;

	public void waitForElementToAppear(By findby) {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	
	}
	
	public void waitForWebElementToAppear(WebElement findby) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
		
		}
	
	public void waitForElementToDisappear(WebElement ele) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage goToCart() {
		
		carticon.click();
		CartPage cp=new CartPage(driver);
		return cp;
	}
	
    public OrderPage goToOrderPage() {
		
    	orderheader.click();
		OrderPage op=new OrderPage(driver);
		return op ;
	}
	
	
}
