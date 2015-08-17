package Pages.Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * SignInPage represents the page with sign in form
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */
public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver d){
		this.driver = d;
	}
	
	
	public MyAccountPage doSignIn(String email, String password){
		By emailLocator = By.name("email");
		By passwordLocator = By.name("password");
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(passwordLocator).submit();
		return new MyAccountPage(driver);
	}
	
	public void waitForPageLoad(){
		WebDriverWait waitLoginForm = new WebDriverWait(driver,20);
		waitLoginForm.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	}

}
