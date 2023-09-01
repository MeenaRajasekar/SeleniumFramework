package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.testcomponents.BaseTest;

public class StepDefinitionimple extends BaseTest {
	
	public LandingPage lp;
	public ProductCatalog pc;
	public ConfirmationPage confirmp;
	
	@Given("landed on Ecommerce Page")
	public void landed_on_Ecommerce_Page() throws IOException{
		
		lp=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_usrname_and_passowrd(String username,String password) {
		
		 pc=lp.LoginApp( username, password);
	}
	
	@When("^I add product (.+) to the cart$")
	public void add_product_to_cart(String productName) {
		List<WebElement> products=pc.getProductList();
		pc.addProductToCart(productName);
		
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		
        CartPage cp=pc.goToCart();
		
		//CartPage
		Boolean match=cp.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		//checkout
		CheckoutPage coutp=cp.goToCheckout();
	
		coutp.selectCountry("ind");
		confirmp=coutp.submitOrder();

	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_on_confirmatonPage(String string) {
		
		//validating confirmation msg
				String expectedmsg=confirmp.orderConfirmationCheck();
				String actualmsg=string;
				Assert.assertEquals(actualmsg, expectedmsg);
				driver.close();
	}
	
	@Then("{string} message displayed")
	public void incorrect_message_is_displayed(String string) {
		
		Assert.assertEquals(string, lp.getErrorMsg());
		driver.close();
		
	}
	

}
