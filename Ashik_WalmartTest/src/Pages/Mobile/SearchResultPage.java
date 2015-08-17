package Pages.Mobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * SearchResultPage represents the page that renders the search results
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver d){
		this.driver = d;
	}

	
	By resultListLocator = By.xpath("//div[@class='mobile-result-items']/*");
	By itemSelectLocator = By.xpath(".//div[@class='product-details']/a");
	
	public List<WebElement> getAllItems(){
		return driver.findElements(resultListLocator);
	}
	
	public WebElement getItemFromList(int row){
		return this.getAllItems().get(row);
	}
	
	public ProductInformationPage clickOnItem(WebElement itemElement){
		itemElement.findElement(itemSelectLocator).click();
		return new ProductInformationPage(driver);
	}
	
}
