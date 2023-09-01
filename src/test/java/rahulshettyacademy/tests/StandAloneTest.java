package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		//Wrapping up end to end automation script on purchasing order in ecommerce website
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("Udemyrahul@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rakshan@2018");
		driver.findElement(By.id("login")).click();
		
		String wantedprod="Zara coat 3";
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement deisredproduct=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(wantedprod)).findFirst().orElse(null);
		
		deisredproduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));---->slows down the execution time
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));		
		
		
		driver.findElement(By.xpath("//i[contains(@class,'cart')]")).click();
		
		List<WebElement> expectedprods=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=expectedprods.stream().anyMatch(expectedprod->expectedprod.getText().equalsIgnoreCase(wantedprod));
		
		Assert.assertTrue(match);
		
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
		List<WebElement> checkoutprods=driver.findElements(By.xpath("//section[contains(@class,'ta-results')]/button"));
		
		for(int i=0;i<checkoutprods.size();i++) {
			if(checkoutprods.get(i).getText().equalsIgnoreCase("india")) {
				driver.findElements(By.xpath("//section[contains(@class,'ta-results')]/button")).get(i).click();
			}
		}
		
		//Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String expectedmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		String actualmsg="THANKYOU FOR THE ORDER";
		
		Assert.assertEquals(actualmsg, expectedmsg);
		
		driver.close();
		
		
		
		

	}

}
