package Runner;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Utils.BaseClass;

public class Flow extends BaseClass{
	
	private static Logger logger = LogManager.getLogger(Flow.class);
	
	
	@Test
	public static void FunctionalFow() throws IOException {
		
		Pages.HomePage.PageTitle();
		logger.info("page title verified");
		
		Pages.HomePage.SearchFunctional();
		logger.info("Search functionality is verified");
			
		Pages.SearchPage.ProductSelection();
		logger.info("Product selection functionality is verified");
				
		Pages.ProductPage.BuyNowFunctional();
		logger.info("buy Now button functionality is verified");

	}
	

}
