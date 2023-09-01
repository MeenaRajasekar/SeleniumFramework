package rahulshettyacademy.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"Error Handling"},retryAnalyzer=Retry.class)  //since I have doubt whether this test may fail so I provide retryAnalyzer over here
	public void loginErrorValidation() throws IOException {
		
		lp.LoginApp("Udemyrahul@gmail.com", "Rakshan@2018");
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());

	}
	
	@Test
	public void productErrorValidation() throws IOException {
		
		String wantedprod="Zara coat 3";
		ProductCatalog pc=lp.LoginApp("Udemyrahul@gmail.com", "Rakshan@2018");
		List<WebElement> products=pc.getProductList();
		pc.addProductToCart(wantedprod);
		CartPage cp=pc.goToCart();
		
	
		Boolean match=cp.verifyProductDisplay("Zara coat 35");
		Assert.assertFalse(match);
	}
	

}
