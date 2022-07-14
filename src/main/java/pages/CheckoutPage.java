package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class CheckoutPage {

	Page page;
	Utils util = new Utils();
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public CheckoutPage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_prodName = "tbody td:nth-child(2) p";
	private String lbl_prodQty = "tbody td:nth-child(3) p";
	private String lbl_unitPrice = "tbody td:nth-child(4) p";
	private String lbl_totalPrice = "tbody td:nth-child(5) p";
	private String lbl_prodNameM = "tbody tr:nth-child(*) td:nth-child(2) p";
	private String lbl_prodQtyM = "tbody tr:nth-child(*) td:nth-child(3) p";
	private String lbl_unitPriceM = "tbody tr:nth-child(*) td:nth-child(4) p";
	private String lbl_totalPriceM = "tbody tr:nth-child(*) td:nth-child(5) p";
	private String btn_placeOrder = "text=Place Order";
	public String lbl_successPlaced = "#content h1";
	public String dropdown_country = "select";
	public String check_conditions = "input.chkAgree";
	private String btn_proceed = "text=Proceed";
	private String lbl_success = ".products span";

	public void verifyConfirmOrder() {
		assertEquals(page.textContent(lbl_prodName), util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_prodQty), util.getProductVariable(Constants.productQuantity));
		assertEquals(page.textContent(lbl_unitPrice).contains(util.getProductVariable(Constants.productUnitPrice)),
				true);
		assertEquals(page.textContent(lbl_totalPrice).contains(util.getProductVariable(Constants.productTotalPrice)),
				true);
	}

	public void verifyConfirmMultipleOrder() {
		int items = Integer.parseInt(util.getProductVariable(Constants.productTotalItems));
		for (int i = 1; i <= items; i++) {
			assertEquals(page.textContent(lbl_prodNameM.replace("*", "" + i)),
					util.getProductVariable(Constants.productName + "_" + i));
			assertEquals(page.textContent(lbl_prodQtyM.replace("*", "" + i)),
					util.getProductVariable(Constants.productQuantity + "_" + i));
			assertEquals(page.textContent(lbl_unitPriceM.replace("*", "" + i))
					.contains(util.getProductVariable(Constants.productUnitPrice + "_" + i)), true);
			assertEquals(page.textContent(lbl_totalPriceM.replace("*", "" + i))
					.contains(util.getProductVariable(Constants.productTotalPrice + "_" + i)), true);
		}
	}

	public void clickConfirmOrderButton() {
		page.click(btn_placeOrder);
	}

	public void selectCountryAndAccept() {
		String country = cfReader.getPropertyValue("country");
		page.selectOption(dropdown_country, country);
		page.check(check_conditions);
	}

	public void clickProceed() {
		page.click(btn_proceed);
	}

	public void verifySuccessMessage() {
		assertEquals(page.textContent(lbl_success).contains(Constants.placedSuccess), true);
	}
}
