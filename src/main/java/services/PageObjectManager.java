package services;

import com.microsoft.playwright.Page;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

/**
 * Class to create objects of each Page classes
 * 
 * @author shubham_k
 * 
 */
public class PageObjectManager extends InitFactory {

	static Page page = SetUp();

	private static HomePage homePage;
	private static CartPage cartPage;
	private static CheckoutPage checkoutPage;

	private PageObjectManager() {
	}

	public static HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(page) : homePage;
	}

	public static CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(page) : cartPage;
	}

	public static CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(page) : checkoutPage;
	}

}
