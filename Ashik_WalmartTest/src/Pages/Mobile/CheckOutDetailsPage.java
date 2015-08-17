package Pages.Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * CheckOutDetailsPage represents the check out page which is rendered after adding items to cart.
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */
public class CheckOutDetailsPage {
	private WebDriver driver;
	
	public CheckOutDetailsPage(WebDriver d){
		this.driver = d;
	}
	
	public void waitForPageLoad(){
		//Wait until add-to-cart button appears
		WebDriverWait waitCheckOut = new WebDriverWait(driver,35);
		waitCheckOut.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/checkout/']")));
	}
	
}
