package stepDef;

import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import services.PageObjectManager;

public class CheckoutDef {

	CheckoutPage checkoutPage = PageObjectManager.getCheckoutPage();

	@Then("verify the product details on checkout page")
	public void verify_the_product_details_on_checkout_page() {
		checkoutPage.verifyConfirmOrder();
	}
	
	@Then("verify the multiple product details on checkout page")
	public void verify_the_multiple_product_details_on_checkout_page() {
		checkoutPage.verifyConfirmMultipleOrder();
	}

	@Then("click on place order button")
	public void click_on_place_order_button() {
		checkoutPage.clickConfirmOrderButton();
	}

	@Then("select a country")
	public void select_a_country() {
		checkoutPage.selectCountryAndAccept();
	}

	@Then("accept the terms and conditions")
	public void accept_the_terms_and_conditions() {
	}

	@Then("click on proceed button")
	public void click_on_proceed_button() {
		checkoutPage.clickProceed();
	}

	@Then("verify the success message")
	public void verify_the_success_message() {
		checkoutPage.verifySuccessMessage();
	}

}
