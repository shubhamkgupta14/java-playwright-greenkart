package stepDef;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import services.PageObjectManager;
import utils.Constants;
import utils.Utils;

public class HomeDef {

	HomePage homePage = PageObjectManager.getHomePage();
	Utils util = new Utils();
	String feature = null;
	String scenario = null;
	String step = null;

	@BeforeStep
	public void beforeS(Scenario s) {
		this.scenario = s.getName();
		this.feature = s.getId().split("/")[1].substring(0, s.getId().split("/")[1].indexOf("."));
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		PageObjectManager.launch();
		homePage.verifyHomePage();
		System.out.println(feature);
		System.out.println(scenario);
		System.out.println(new Throwable().getStackTrace()[0].getMethodName());
	}

	@When("enters product name into searchbox")
	public void enters_product_name_into_searchbox() {
		homePage.searchProduct();
		System.out.println(feature);
		System.out.println(scenario);
	}

	@When("enters wrong product name into searchbox")
	public void enters_wrong_product_name_into_searchbox() {
		homePage.searchWrongProduct();
		System.out.println(feature);
		System.out.println(scenario);
	}

	@Then("verifies the searched product")
	public void verifies_the_searched_product() {
		homePage.verifySearchedProduct();
		System.out.println(feature);
		System.out.println(scenario);
	}

	@Then("set the quantity of product")
	public void set_the_quantity_of_product() {
		homePage.setQuantity();
		System.out.println(feature);
		System.out.println(scenario);
	}

	@Then("click on Add to cart button")
	public void click_on_add_to_cart_button() {
		homePage.clickAddToCart();
		System.out.println(feature);
		System.out.println(scenario);
		System.out.println(Constants.productMap);
	}

	@When("select multiple product and add to cart")
	public void select_multiple_product_and_add_to_cart() {
		homePage.addMultipleProductsIntoCart();
	}

	@Then("go to cart window")
	public void go_to_cart_window() {
		homePage.gotoCart();
		System.out.println(feature);
		System.out.println(scenario);
	}

}
