package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	  // WebElement username= driver.findElement(By.id("userEmail"));
	   
	   @FindBy(id="userEmail")
	   WebElement username;
	   
	   @FindBy(id="userPassword")
	   WebElement password;
	   
	   @FindBy(id="login")
	   WebElement loginbtn;
	   
	   @FindBy(css="[class*='flyInOut']")
	   WebElement errormsg;
	   
	   
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		
		waitForWebElementToAppear(errormsg);
		return errormsg.getText();
	}
	   
	public ProductCatalog LoginApp(String email,String pwd) {
		
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginbtn.click();
		ProductCatalog pc=new ProductCatalog(driver);
		return pc;
		
		}
	   
	   
	   
	   
	  }
