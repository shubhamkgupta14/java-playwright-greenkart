package services;


import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.Utils;

public class InitFactory {

	static Browser browser;
	static String baseURL = "https://demo.opencart.com/";
	static Page page;
	static BrowserContext browserContext;
	static ConfigReader cfReader;
	static Utils util = new Utils();

	/**
	 * Initialization of Browser, Browser context, and Page BrowserContexts -
	 * provide a way to operate multiple independent browser sessions. Page -
	 * provides methods to interact with a single tab in a Browser.
	 * 
	 * Here considered browsers - Chrome, Chromium, Firefox, Edge, Webkit
	 * browserName location = src/test/resources/config.properties
	 * 
	 * @author shubham_k
	 * @return Page
	 */
	public static Page SetUp() {
		String browserName = null;
		browserName = new ConfigReader().getPropertyValue("browser");
		System.out.println("Openning " + browserName + "...");

		switch (browserName.toUpperCase()) {
		case "CHROMIUM":
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		case "FIREFOX":
			browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		case "WEBKIT":
			browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

		case "MSEDGE":
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));

		case "CHROME":
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		}

//		browserContext = browser.newContext();

		/**
		 * @Note For generating the video
		 */
		browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"+browserName+"/")));

		page = browserContext.newPage();
		return page;
	}

	/**
	 * Launching the provided browser and launch the base url
	 * base-url location = src/test/resources/config.properties
	 * 
	 * @author shubham_k
	 * @return void
	 */
	public static void launch() {
		page.navigate(new ConfigReader().getPropertyValue("base_url"));
	}

	/**
	 * Closing the current browser
	 * 
	 * @author shubham_k
	 * @return void
	 */
	public static void closeContext() {
		browserContext.close();
	}

}
