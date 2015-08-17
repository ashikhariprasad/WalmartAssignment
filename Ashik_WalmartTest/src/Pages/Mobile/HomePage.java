package Pages.Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * HomePage represents the Home page of http://www.walmart.com
 * This class holds all the functionalities that can be performed on this page.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 */

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver d){
		this.driver = d;
	}

	By searchBarLocator = By.name("query");
	By submitLocator = By.name("query");
	By sideNavLocator = By.xpath("//div[@class='arrange-fit']/button[contains(@class,'header-nav-toggle')]");
	By signInLocator = By.xpath("//a[@href='/account/login']");
	
	public SearchResultPage doSearchOf(String searchItem){
		
		driver.findElement(searchBarLocator).sendKeys(searchItem);
		driver.findElement(submitLocator).submit();
		return new SearchResultPage(driver);
		
	}
	
	public SignInPage goToSignInPage(){
		driver.findElement(sideNavLocator).click();
		driver.findElement(signInLocator).click();
		return new SignInPage(driver);
	}
}
