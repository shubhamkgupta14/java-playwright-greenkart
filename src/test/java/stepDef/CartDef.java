package stepDef;

import io.cucumber.java.en.Then;
import pages.CartPage;
import services.PageObjectManager;

public class CartDef {

	CartPage cartPage = PageObjectManager.getCartPage();

	@Then("verify cart product detail")
	public void verify_cart_product_detail() {
		cartPage.verifyProductDetail();
	}
	
	@Then("verify multiple cart product detail")
	public void verify_multiple_cart_product_detail() {
		cartPage.verifyMultipleProducts();
	}

	@Then("click on checkout button")
	public void click_on_checkout_button() {
		cartPage.clickCheckOutButon();
	}
	
	@Then("remove one product from cart")
	public void remove_one_product_from_cart() {
		cartPage.removeFromCart();
	}
}
