package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String wantedprod="Zara coat 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap <String,String> input) throws IOException {
		
		ProductCatalog pc=lp.LoginApp(input.get("email"), input.get("password"));
		
		//ProductCatalog
		List<WebElement> products=pc.getProductList();
		pc.addProductToCart(input.get(wantedprod));
		CartPage cp=pc.goToCart();
		
		//CartPage
		Boolean match=cp.verifyProductDisplay(input.get(wantedprod));
		Assert.assertTrue(match);
		
		//checkout
		CheckoutPage coutp=cp.goToCheckout();
	
		coutp.selectCountry("ind");
		ConfirmationPage confirmp=coutp.submitOrder();

		//validating confirmation msg
		String expectedmsg=confirmp.orderConfirmationCheck();
		String actualmsg="THANKYOU FOR THE ORDER.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
		
		}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHisoryTest() {
		ProductCatalog pc=lp.LoginApp("Udemyrahul@gmail.com", "Rakshan@2018");
		OrderPage op=pc.goToOrderPage();
		Assert.assertTrue(op.verifyOrderDisplay(wantedprod));
	}
	
	@DataProvider 
	public Object[][] getData() throws IOException {
		
		 List<HashMap<String,String>> data = getJasonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"); 
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}
		

		
	/*
	 * @DataProvider 
	 * public Object[][] getData() {
	 * 
	 * HashMap <String,String> map =new HashMap<String,String>(); 
	 * map.put("email","Udemyrahul@gmail.com");
	 * map.put("password", "Rakshan@2018");
	 * map.put("wantedprod", "Zara coat 3");
	 * 
	 * HashMap <String,String> map1 =new HashMap<String,String>(); 
	 * map1.put("email", "shettyudemy@gmail.com"); 
	 * map1.put("password", "Rakshan@2018");
	 * map1.put("wantedprod", "ADIDAS ORIGINAL");
	 * 
	 * return new Object[][] { {map}, {map1} };
	 * 
	 * }
	 */
	
	/*@DataProvider
	public Object[][] getData() {
	   return new Object[][] { {"Udemyrahul@gmail.com","Rakshan@2018","Zara coat 3"},{"shettyudemy@gmail.com",} };

	}*/
}
