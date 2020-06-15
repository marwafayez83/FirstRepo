package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;


public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
		actions= new Actions(driver);
	}

	@FindBy(linkText="Sign in")
	WebElement signintBtn;

	@FindBy(id="email")
	WebElement emailTxt ;

	@FindBy(id="passwd")
	WebElement passwordTxt ;

	@FindBy(id="SubmitLogin")
	WebElement submitBtn ;

	@FindBy(id="search_query_top")
	WebElement searchBar ;

	@FindBy(xpath="//*[contains(@class,'btn btn-default button-search')]")
	WebElement submitSearchBtn;

	@FindBy(xpath="(//img[contains(@itemprop,'image')])[1]")
	public WebElement firstYelloDress;

	//@FindBy(xpath="(//*[contains(@class,'product-image-container')])[3]")
	@FindBy(xpath="(//img[contains(@itemprop,'image')])[2]")
	public WebElement seconedYelloDress;

	@FindBy(xpath="(//img[contains(@itemprop,'image')])[3]")
	public WebElement thirdYelloDress;


	@FindBy(xpath="//a[contains(@title,'Add to cart')]")
	WebElement firstAddToCartBtn;

	@FindBy(xpath="(//a[contains(@title,'Add to cart')])[2]")
	WebElement secondAddToCartBtn;

	@FindBy(xpath="(//a[contains(@title,'Add to cart')])[3]")
	WebElement thirdAddToCartBtn;

	@FindBy(xpath="//span[contains(@title,'Continue shopping')]")
	WebElement continueShoppingBtn;

	@FindBy(xpath="//a[contains(@title,'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;



	@FindBy(xpath="(//span[contains(@class,'ajax_cart_quantity')])[2]")
	public WebElement quantityAssertion;

	@FindBy(id="fileUpload")
	public WebElement uploadBtn;


	public void login (String email, String password) throws InterruptedException
	{
		clickButton(signintBtn);
		sendTextIntoFields(emailTxt,email );
		sendTextIntoFields(passwordTxt, password);
		clickButton(submitBtn);

	}

	public void searchForProduct(String SearchWord) {
		wait.until(ExpectedConditions.visibilityOf(searchBar));

		sendTextIntoFields(searchBar, SearchWord);

		clickButton(submitSearchBtn);

	}

	public void addDressToCart() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(firstYelloDress));
		actions.moveToElement(firstYelloDress).moveToElement(firstAddToCartBtn).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
		Thread.sleep(500);
		clickButton(continueShoppingBtn);

		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(seconedYelloDress));
		actions.moveToElement(seconedYelloDress).moveToElement(secondAddToCartBtn).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
		Thread.sleep(500);
		clickButton(continueShoppingBtn);
		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(thirdYelloDress));
		actions.moveToElement(thirdYelloDress).moveToElement(thirdAddToCartBtn).click().build().perform();

		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutBtn));
		Thread.sleep(500);
		clickButton(proceedToCheckOutBtn);

		//String filePath = System.getProperty("user.dir") + "\\uploads\\download.jpg";
		//sendTextIntoFields(uploadBtn, filePath);

	}

	public void continueShopping() throws InterruptedException {

		Thread.sleep(1000);
		clickButton(continueShoppingBtn);
	}

	public void proceedToCheckOut() throws InterruptedException {

		Thread.sleep(1000);
		clickButton(proceedToCheckOutBtn);
	}

}
