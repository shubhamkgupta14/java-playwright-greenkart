package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class HomePage {

	Page page;
	Utils util = new Utils();
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public HomePage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_logo = "div .greenLogo";
	private String input_search = ".search input";
	private String btn_search = ".search button";
	private String lbl_productTitle = "h4.product-name";
	private String lbl_productPrice = "p.product-price";
	private String btn_productIncrease = "a.increment";
	private String btn_productDecrease = "a.decrement";
	private String btn_productNoInput = "input.quantity";
	private String btn_addToCart = "div.product-action button";
	private String btn_goToCart = "a.cart-icon";
	private String lbl_productTitleM = "div.products > div:nth-child(*) h4";
	private String lbl_productPriceM = "div.products > div:nth-child(*) p";
	private String btn_productNoInputM = "div.products > div:nth-child(*) input.quantity";
	private String btn_addToCartM = "div.products > div:nth-child(*) > div.product-action > button";

	public void verifyHomePage() {
		util.verifyTitle(page, Constants.HomePageTitle);
		assertEquals(page.textContent(lbl_logo), Constants.storeLogo);
	}

	public void searchProduct() {
		String productName = cfReader.getPropertyValue("searchProduct");
		page.fill(input_search, productName);
		util.setProductVariable(Constants.productName, productName);
		page.locator(btn_search).click();
	}

	public void searchWrongProduct() {
		String productName = cfReader.getPropertyValue("searchWrongProduct");
		page.fill(input_search, productName);
		util.setProductVariable(Constants.productName, productName);
		page.locator(btn_search).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_searchProduct"));
	}

	public void verifySearchedProduct() {
		page.waitForTimeout(2000);
		String productName = cfReader.getPropertyValue("searchProduct");
		System.out.println(productName);
		System.out.println(page.textContent(lbl_productTitle));
		util.takeFullPageScreenshot(page);
		assertEquals(page.textContent(lbl_productTitle).contains(productName), true);
		util.setProductVariable(Constants.productName, page.textContent(lbl_productTitle));
		util.setProductVariable(Constants.productUnitPrice, page.textContent(lbl_productPrice));
	}

	public void setQuantity() {
		String qty = cfReader.getPropertyValue("quantity");

		// using increase button
		int quantity = Integer.parseInt(qty);
		for (int i = 1; i < quantity; i++) {
			page.locator(btn_productIncrease).click();
		}

		// using input text

		util.setProductVariable(Constants.productQuantity, qty);
	}

	public void clickAddToCart() {
		page.locator(btn_addToCart).click();
	}

	public void gotoCart() {
		page.locator(btn_goToCart).click();
	}

	public void addMultipleProductsIntoCart() {
		int items = Integer.parseInt(cfReader.getPropertyValue("noOfItems"));
		util.setProductVariable(Constants.productTotalItems, cfReader.getPropertyValue("noOfItems"));
		for (int i = 1; i <= items; i++) {
			util.setProductVariable(Constants.productName + "_" + i,
					page.textContent(lbl_productTitleM.replace("*", i + "")));
			util.setProductVariable(Constants.productUnitPrice + "_" + i,
					page.textContent(lbl_productPriceM.replace("*", i + "")));
			util.setProductVariable(Constants.productQuantity + "_" + i,
					page.inputValue(btn_productNoInputM.replace("*", i + "")));
			
			page.locator(btn_addToCartM.replace("*", i + "")).click();
		}
		System.out.println(Constants.productMap);
	}
}
