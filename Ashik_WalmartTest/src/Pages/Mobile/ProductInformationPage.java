package Pages.Mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * ProductInformationPage represents the details about the product. 
 * This page is rendered when the user selects a product.
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */
public class ProductInformationPage {
	WebDriver driver;

	public ProductInformationPage(WebDriver d) {
		this.driver = d;
	}

	By addToCartButtonLocator = By
			.xpath("//div[@class='js-product-add-to-cart-row']/button");
	By productTitleLocator = By.xpath("//div[contains(@class,'prod-title-section')]");

	//Find the add button on page and click
	public CheckOutDetailsPage addItemToCart() {
		driver.findElement(addToCartButtonLocator).click();
		return new CheckOutDetailsPage(driver);
	}
	
	public String getProductTitle(){
		return driver.findElement(productTitleLocator).getText();
	}

	public void waitForPageLoad() {
		// Wait until add-to-cart button appears
		WebDriverWait waitCheckOut = new WebDriverWait(driver, 25);
		waitCheckOut.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[@class='js-product-add-to-cart-row']/button")));
	}

	public void doImplicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
