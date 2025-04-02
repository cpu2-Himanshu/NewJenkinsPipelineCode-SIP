package UAT_SIP2;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Check_Offer   {
	 public static WebDriver driver;
	    public WebDriverWait wait;
	    
	    String MODEL;
	    String VARIENT;	
	   
	    String MODEL2;
	    String VARIENT2;	
	    //..................................................................................................
	    @SuppressWarnings("static-access")
	    @BeforeClass
	    public void sip() throws InterruptedException {
	        this.driver = SVOC.driver;	    
	        }

	  //...................................................................    
	    @Test(priority = 7)
	      public void Vehicle_Details() throws InterruptedException {	       	    
	    	try {
	    		VEHICLE_Detail();
	    	}catch(Exception e){
	    		Assert.fail("TEST FAILED :: \n Vehicle Details is NULL");
	    	}
  	  }
	    
	    //...................................................................    
	    @Test(priority = 8)
	      public void CHECK_Offer_TAB() throws InterruptedException {	       	    
	    	try {
	    		Check_Offer();
	    	}catch(Exception e){
	    		Assert.fail("TEST FAILLED :: Model/Varient is not  is not showing in Check offer TAB ");
	    	}
  	  }
	    
	    
	    //...................................................................    
	    @Test(priority =9)
	      public void Verify_Check_Offer_TAB() throws InterruptedException {	       	    
	    	List<String> failedAssertions = new ArrayList<>();

	          if (!MODEL.equals(MODEL2)) {
	              failedAssertions.add("Model names are different in Check Offer TAB");
	          }
	          if (!VARIENT.equals(VARIENT2)) {
	              failedAssertions.add("Model names are different in Check Offer TAB");
	         
	          if (!failedAssertions.isEmpty()) {
	              Assert.fail(String.join("\n", failedAssertions));
	          }
	      }	    	}
	  //..............................................................................
	  //..........................................................................  
	    public void VEHICLE_Detail() {
	    try {
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));	   
	    	WebElement Model3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//app-vehicle-status//h6)[2]")));
	    	WebElement Varient3 = driver.findElement(By.xpath("(//app-vehicle-status//h6)[3]"));
	    
	    	 MODEL = Model3.getText();
	    	 VARIENT = Varient3.getText();
	    	 
	    	System.out.println("Vehicle_Details_Model :: "   +  MODEL );
	    	System.out.println("Vehicle_Details_Varient  ::"   +  VARIENT );
	    }catch(Exception e){
	    	Assert.fail("TEST FAILLED :: Vehicle Details is not diplay ");
	    }
	    }
	    
	    //..........................................................................  
	    public void Check_Offer() {
	    try {
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));	   
	    	WebElement Offer = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Check Offers \"]")));
	    	Offer.click();
	    	Thread.sleep(1000);
	    	
	    	WebElement Model3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-dialog-content//form//section//div[1]/div[1]/p")));
	    	WebElement Varient3 = driver.findElement(By.xpath("//mat-dialog-content//form//section//div[1]/div[2]/p"));
	    
	    	 MODEL2 = Model3.getText();
	    	 VARIENT2 = Varient3.getText();
	    	 
	    	System.out.println("Check_Offer_Model :: "   +  MODEL2 );
	    	System.out.println("Check_Offer_Varient  ::"   +  VARIENT2 );
	    	
	    	WebElement Cancell = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Close\"]")));
	    	clickElementUsingJS(driver,Cancell);
	    	
	    }catch(Exception e){
	    	Assert.fail("TEST FAILLED :: Model/Varient is not  is not showing in Check offer TAB ");
	    }
	    }
	    //.....................................................................
		public void clickElementUsingJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		

}
