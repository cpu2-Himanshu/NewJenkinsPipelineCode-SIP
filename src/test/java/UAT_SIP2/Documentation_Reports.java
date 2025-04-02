package UAT_SIP2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Documentation_Reports {
	    public static WebDriver driver;
	    public WebDriverWait wait;
	//..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void sip() throws InterruptedException {
        this.driver = Check_Offer.driver;	    
        }   
    
  //...................................................................    
    @Test(priority = 2)
      public void Click_On_BackButton() throws InterruptedException {	       	    
    	Thread.sleep(500);
  	 
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
        WebElement Back = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"chevron_left\"]")));
	    clickElementUsingJS(driver, Back);
    }
  //...................................................................    
    @Test(priority = 3)
      public void Click_On_Documentation_Reports() throws InterruptedException {	       	    
    	Thread.sleep(1500);
  	 try {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
        WebElement Reports = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"icon-booking icon\"])[2]")));
	    clickElementUsingJS(driver, Reports);
	    Thread.sleep(500);
	    WebElement DocumentationReports = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"toggle-icon\"])[2]")));
		clickElementUsingJS(driver, DocumentationReports);
		Thread.sleep(500);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Select Date \"]")));
  	 }catch(Exception e){
  		 Assert.fail("TEST FAILED :: \n Documentation Reports data is not showing ");
  	 }
    }
    //...........................................................................................
  
    @Test(priority = 4)
    public void Verify_DealerOutlet_TV01() throws InterruptedException {
       try { 
    	verifyDealerOutlet(1, 2);
    }catch(Exception e){
    	Assert.fail("No data found for TV01 ,TEST Failed ");
    }
   }
    //...........................................................................................

    @Test(priority = 5)
    public void Verify_DealerOutlet_BZC1() throws InterruptedException {
       try {
    	verifyDealerOutlet(2, 3);
    }catch(Exception e){
    	Assert.fail("No data found for BZC1 ,TEST Failed ");
    }
}
    //.......................................................................................
    @Test(priority = 6)
    public void Verify_DealerOutlet_BZD1() throws InterruptedException {
     try {
    	verifyDealerOutlet(3, 4);
    }catch(Exception e){
    	Assert.fail("No data found for BZD1,TEST Failed ");
    }
}
  //.......................................................................................
    @Test(priority = 7)
    public void Verify_DealerOutlet_CTQ1() throws InterruptedException {
        try {
    	verifyDealerOutlet(4, 5);
    }catch(Exception e){
    	Assert.fail("No data found for CTQ1 ,TEST Failed ");
    }
}
  //.......................................................................................
    @Test(priority = 8)
    public void Verify_DealerOutlet_SGL1() throws InterruptedException {
        try {
    	verifyDealerOutlet(5, 6);
        }catch(Exception e){
        	Assert.fail("No data found for SGL1 ,TEST Failed ");
        }
    }
  //.......................................................................................
    @Test(priority = 9)
    public void Verify_DealerOutlet_K701() throws InterruptedException {
        try {
    	verifyDealerOutlet(6, 7);
        }catch(Exception e){
        	Assert.fail("No data found for K701 ,TEST Failed ");
        }
    }
  //.......................................................................................
    @Test(priority = 10)
    public void Verify_DealerOutlet_SMD1() throws InterruptedException {
        try {
    	verifyDealerOutlet(7, 1);
        }catch(Exception e){
        	Assert.fail("No data found for SMD1,TEST Failed ");
        }
    }
  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public void verifyDealerOutlet(int removeIndex, int selectIndex) throws InterruptedException {
        Click_On_Dealer_Outlet();
        RemoveTEXT(removeIndex);
        check_Data(selectIndex);
    }
    //...........................................................................................
    public void Click_On_Dealer_Outlet() throws InterruptedException {
        WebElement Click_DEALER_Outlet = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select//div/div[2]/div)[1]")));
        clickElementUsingJS(driver, Click_DEALER_Outlet);
        Thread.sleep(500);
    }
    //...........................................................................................

    public void RemoveTEXT(int OptionIndex) throws InterruptedException {
        WebElement Remove = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@role='option'])[" + OptionIndex + "]")));
        clickElementUsingJS(driver, Remove);
        Thread.sleep(500);
    }
    //...........................................................................................

    public void check_Data(int selectIndex) throws InterruptedException {
        WebElement Select_Dealer = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@role='option'])[" + selectIndex + "]")));
        String selectedDealer = Select_Dealer.getText();
        System.out.println("Selected Dealer: " + selectedDealer);
        clickElementUsingJS(driver, Select_Dealer);
        Thread.sleep(500);

        // Apply Filter
        Actions action = new Actions(driver);
        WebElement ApplyFilter = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Apply Filters ']")));
        action.doubleClick(ApplyFilter).perform();
        Thread.sleep(2100);

        // Extract Dealer Data
        List<WebElement> DealerData = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//app-documentation-report//table/tbody/tr/td[1]")));

        if (DealerData.isEmpty()) {
            Assert.fail("No data found! Dealer Data is empty.");
        }

        List<String> mismatchedData = new ArrayList<>();
        List<Integer> mismatchedIndexes = new ArrayList<>();

        for (int i = 0; i < DealerData.size(); i++) {
            String data = DealerData.get(i).getText();
            System.out.println("Dealer Data at index " + i + " : " + data);
            if (!data.equals(selectedDealer)) {
                mismatchedData.add(data);
                mismatchedIndexes.add(i + 1);
            }
        }

        if (!mismatchedData.isEmpty()) {
            Assert.fail("Mismatch found in Dealer Data!\n" +
                        "Expected: " + selectedDealer + "\n" +
                        "Incorrect Values at indexes: " + mismatchedIndexes + "\n" +
                        "Values: " + mismatchedData);
        }
    }



  //.....................................................................
  		public void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
}
