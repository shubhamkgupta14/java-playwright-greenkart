package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class CartPage {

	Page page;
	Utils util = new Utils();
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public CartPage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_productName = "div.cart-preview ul.cart-items li p.product-name";
	private String lbl_quantity = "div.cart-preview ul.cart-items li p.quantity";
	private String lbl_unitPrice = "div.cart-preview ul.cart-items li p.product-price";
	private String lbl_sumPrice = "div.cart-preview ul.cart-items li p.amount";
	private String lbl_productNameM = "div.cart-preview ul.cart-items li:nth-child(*) p.product-name";
	private String lbl_quantityM = "div.cart-preview ul.cart-items li:nth-child(*) p.quantity";
	private String lbl_unitPriceM = "div.cart-preview ul.cart-items li:nth-child(*) p.product-price";
	private String lbl_sumPriceM = "div.cart-preview ul.cart-items li:nth-child(*) p.amount";
	private String btn_checkOut = "text=PROCEED TO CHECKOUT";
	private String btn_remove = "div.cart-preview ul.cart-items li:nth-child(*) a.product-remove";

	public void verifyProductDetail() {
		assertEquals(page.textContent(lbl_productName), util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_quantity).contains(util.getProductVariable(Constants.productQuantity)), true);

		String totalPriceCalc = util.getTotalPrice(page.textContent(lbl_quantity), page.textContent(lbl_unitPrice));

		util.setProductVariable(Constants.productTotalPrice, totalPriceCalc);

		assertEquals(page.textContent(lbl_sumPrice).contains(totalPriceCalc), true);

		System.out.println(Constants.productMap);
	}

	public void clickCheckOutButon() {
		page.click(btn_checkOut);
	}

	public void verifyMultipleProducts() {
		int items = Integer.parseInt(util.getProductVariable(Constants.productTotalItems));
		for (int i = 1; i <= items; i++) {
			assertEquals(page.textContent(lbl_productNameM.replace("*", i + "")),
					util.getProductVariable(Constants.productName + "_" + i));

			assertEquals(page.textContent(lbl_quantityM.replace("*", i + ""))
					.contains(util.getProductVariable(Constants.productQuantity + "_" + i)), true);

			String totalPriceCalc = util.getTotalPrice(page.textContent(lbl_quantityM.replace("*", i + "")),
					page.textContent(lbl_unitPriceM.replace("*", i + "")));

			util.setProductVariable(Constants.productTotalPrice + "_" + i, totalPriceCalc);

			assertEquals(page.textContent(lbl_sumPriceM.replace("*", i + "")).contains(totalPriceCalc), true);
		}
		System.out.println(Constants.productMap);
	}

	public void removeFromCart() {
		int removedItem = Integer.parseInt(cfReader.getPropertyValue("removeOrder"));
		int items = Integer.parseInt(cfReader.getPropertyValue("noOfItems")) - 1;
		page.click(btn_remove.replace("*", "" + removedItem));
		page.waitForTimeout(1000);
		Constants.productMap.clear();
		util.setProductVariable(Constants.productTotalItems, items + "");

		for (int i = 1; i <= items; i++) {
			util.setProductVariable(Constants.productName + "_" + i,
					page.textContent(lbl_productNameM.replace("*", i + "")));
			util.setProductVariable(Constants.productUnitPrice + "_" + i,
					page.textContent(lbl_unitPriceM.replace("*", i + "")));
			util.setProductVariable(Constants.productQuantity + "_" + i,
					page.textContent(lbl_quantityM.replace("*", i + "")).split(" ")[0]);

			String totalPriceCalc = util.getTotalPrice(page.textContent(lbl_quantityM.replace("*", i + "")),
					page.textContent(lbl_unitPriceM.replace("*", i + "")));

			util.setProductVariable(Constants.productTotalPrice + "_" + i, totalPriceCalc);

		}

		System.out.println(Constants.productMap);
	}

}
