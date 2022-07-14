package utils;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class Utils {

	/**
	 * put the key-value in LinkedHashMap
	 * 
	 * @author shubham_k
	 * @param String String
	 * @return void
	 */
	public void setProductVariable(String key, String val) {
		Constants.productMap.put(key, val);
	}

	/**
	 * get the key-value from LinkedHashMap
	 * 
	 * @author shubham_k
	 * @param String
	 * @return String
	 */
	public String getProductVariable(String key) {
		return Constants.productMap.get(key);
	}

	/**
	 * scrolling to the top
	 * 
	 * @author shubham_k
	 * @param Page int
	 * @return void
	 */
	public void scrollToUp(Page page, int axis) {
		page.mouse().wheel(0, -axis);
	}

	/**
	 * scrolling to the down
	 * 
	 * @author shubham_k
	 * @param Page int
	 * @return void
	 */
	public void scrollToDown(Page page, int axis) {
		page.mouse().wheel(0, axis);
	}
	
	/**
	 * verify the title
	 * 
	 * @author shubham_k
	 * @param Page String
	 * @return void
	 */
	public void verifyTitle(Page page, String pageType) {
		assertEquals(page.title(), pageType);
	}

	/**
	 * calculting the total price
	 * 
	 * @author shubham_k
	 * @param String String
	 * @return String
	 */
	public String getTotalPrice(String qty, String unitPrice) {
		int quantity = Integer.parseInt(qty.substring(0, qty.indexOf(" N")));
		int price = Integer.parseInt(unitPrice);

		return (quantity * price) + "";
	}

	/**
	 * get the data property file name
	 * 
	 * @author shubham_k
	 * @return String
	 */
	public String getPropertyFileName() {
		return "data/data.properties";
	}
	
	/**
	 * snap full page screenshot
	 * 
	 * @author shubham_k
	 * @param Page
	 * @return void
	 */
	public void takeFullPageScreenshot(Page page) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("fullPage.png")).setFullPage(true));
	}

}
