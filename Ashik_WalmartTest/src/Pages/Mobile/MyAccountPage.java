package Pages.Mobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * MyAccountPage represents the user account page.
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */
public class MyAccountPage {
	private WebDriver driver;
	
	public MyAccountPage(WebDriver d){
		this.driver = d;
	}
	
	By cartItemsLocator = By.xpath("//div[@class='cart-item-row']");
	By cartItemName = By.xpath("//div[contains(@class,'cart-item-name')]/a/span");
	
	public List<WebElement> itemsInCart(){
		return driver.findElements(cartItemsLocator);
	}
	
	public int itemsCount(){
		return this.itemsInCart().size();
	}
	
	public String getCartItemName(){
		System.out.println(driver.findElement(cartItemName).getText());
		return driver.findElement(cartItemName).getText();
	}
	
	public void waitForPageLoad(){
		WebDriverWait waitLogin = new WebDriverWait(driver,25);
		waitLogin.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-item-row")));	
	}
}
