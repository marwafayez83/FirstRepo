package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public JavascriptExecutor jse;
	public Actions actions;
	public static WebDriverWait wait;
	protected WebDriver driver;

	//Super constructor
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Methods to be used in page objects

	protected static void clickButton(WebElement button) {
		try {
			System.out.println("Click on " + button.getText());

			if (button.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(button));
				button.click();
			}
		} catch (Exception e) {
			System.out.println("Failed to Click on " + button.getText() + ".");
			e.printStackTrace();
		}
	}

	protected static void sendTextIntoFields(WebElement textElement, String value) {
		try {
			System.out.println("Enter " + value + " in field");
			if (textElement.isDisplayed()) {
				textElement.clear();
				textElement.sendKeys(value);
				System.out.println( value + " entered in field Successfully.");
			}
		} catch(Exception e){
			System.out.println("Failed to enter " + value + " in field.");
			e.printStackTrace();
		}
	}
}
