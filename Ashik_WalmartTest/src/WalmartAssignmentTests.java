import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.Mobile.CheckOutDetailsPage;
import Pages.Mobile.HomePage;
import Pages.Mobile.MyAccountPage;
import Pages.Mobile.ProductInformationPage;
import Pages.Mobile.SearchResultPage;
import Pages.Mobile.SignInPage;


/*
 * WalmartAssignmentTests automates end-to-end user transaction flow.
 * A user searches for an item on the home page. 
 * The user then selects an item from the home page and adds the item to the cart.
 * The user signs in and should find his product in the cart and is the only product in the cart.
 * @author	Ashik K H
 * @Version 1.0
 * @since	08/14/2015
 * 
 */

public class WalmartAssignmentTests {

	private static WebDriver wDriver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ProductInformationPage productInformationPage;
	private SignInPage signInPage;
	private CheckOutDetailsPage checkOutDetailsPage;
	private MyAccountPage myAccountPage;
	private static String MOBILE_URL = "http://mobile.walmart.com";
	private String USER_ID = "ashik.kuthyarhariprasad@sjsu.edu";
	private String PASSWORD = "password@15";
	private String productTitle;

	@BeforeClass
	public static void setUp() {
		wDriver = new RemoteWebDriver(DesiredCapabilities.android());
		wDriver.get(MOBILE_URL);
	}

	@AfterClass
	public static void tearDown() {
		wDriver.quit();
	}

	@Test
	public void runAssignmentTest() {

		System.out.println("Starting Test Case");
		
		String searchTerm = "tv";

		// Enter search term in home page
		homePage = new HomePage(wDriver);
		searchResultPage = homePage.doSearchOf(searchTerm);

		// Get the first item from result and click it
		productInformationPage = searchResultPage.clickOnItem(searchResultPage
				.getItemFromList(0));

		// Wait for AddToCart Button to appear
		productInformationPage.waitForPageLoad();
		
		//Get item name
		productTitle = productInformationPage.getProductTitle();
		System.out.println(productTitle);

		// Add item to cart
		checkOutDetailsPage = productInformationPage.addItemToCart();
		checkOutDetailsPage.waitForPageLoad();

		// Go Back to home page
		wDriver.get(MOBILE_URL);
		homePage = new HomePage(wDriver);

		// Sign in to account page
		signInPage = homePage.goToSignInPage();
		signInPage.waitForPageLoad();

		myAccountPage = signInPage.doSignIn(USER_ID,PASSWORD);

		// Wait for the cart to appear
		myAccountPage.waitForPageLoad();

		// Check the number of items in the cart
		Assert.assertEquals(1, myAccountPage.itemsCount());
		
		//Check the name of the item in the cart
		//Could be done against product id if available
		Assert.assertTrue(productTitle.equals(myAccountPage.getCartItemName()));

		System.out.println("Ending Test Case");

	}
}
