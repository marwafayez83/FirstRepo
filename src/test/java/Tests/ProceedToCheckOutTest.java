package Tests;


import org.testng.annotations.Test;

import Base.TestBase;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class ProceedToCheckOutTest extends TestBase {

	MyAccountPage  myAccountObject;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	public void authenticateUser() throws InterruptedException
	{

		myAccountObject= new MyAccountPage(driver);
		myAccountObject.login("m.fayez@gmail.com", "12345");

		myAccountObject.searchForProduct("Yellow Dresses");

		myAccountObject.addDressToCart();


		//myAccountObject.proceedToCheckOut();*/


	}
}

