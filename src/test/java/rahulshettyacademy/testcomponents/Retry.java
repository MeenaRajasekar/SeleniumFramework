package rahulshettyacademy.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//IRetryAnalyzer to rerun the flaky failed tests 

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		
		int count=0;
		int maxtry=1;
		if(count<maxtry) {
			count++;
			return true;  //returns true if the test method has to be retried, false otherwise
		}
		
		
		
		return false;
	}

}
