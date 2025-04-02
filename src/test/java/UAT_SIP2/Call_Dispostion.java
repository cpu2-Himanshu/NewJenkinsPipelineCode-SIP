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

public class Call_Dispostion extends Dealer_User_Login  {
	 public static WebDriver driver;
	    public WebDriverWait wait;
	    	    
	    //..................................................................................................
	    @SuppressWarnings("static-access")
	    @BeforeClass
	    public void sip() throws InterruptedException {
	        this.driver = Dealer_User_Login.driver;	    
	        }

	    //..................................................................................................
	    @Test(priority = 4)
	    public void Click_On_Additional_Fillter_To_Clear_Data() throws InterruptedException {
	       	    
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // We have to check that Additional fillter is clikable or not	
	    	try {    	
	    	 WebElement Additional_Fillter_Button = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"filter-span\"]")));
	    	   	    	
	    	 if (Additional_Fillter_Button.isDisplayed() && Additional_Fillter_Button.isEnabled()) {
	    		 Additional_Fillter_Button.click();
		           // System.out.println("Additional Fillter_Button clicked successfully.");
		        } else {
		            System.out.println("Additional Fillter_Button  is not clickable. Test Failed!");
		            throw new RuntimeException("Additional Fillter_Button is not clickable.");
		        }
		    } catch (Exception e) {
		    	Assert.fail("Additional Fillter_Button could not be clickable.");
		        throw new RuntimeException("Additional Fillter_Button could not be clickable.");
		    }	    	
	    	// click on clear button to clear the data 	    		    
		      WebElement Clear = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Clear\"]")));
	 	  clickElementUsingJS(driver, Clear);
	 	  
	 	  WebElement Close_Button = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"close-btn\"]")));
		  clickElementUsingJS(driver, Close_Button);
		 
	   // wait for some Time 
		  Thread.sleep(5000);   	   
	       }  	  
	  //...................................................................    
	    @Test(priority = 6)
	      public void Click_On_Customer_Page() throws InterruptedException {	       	    
	  	  try {
	  	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
	      WebElement Click_On_Customer = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-booking-table//table/tbody//td[3]")));
		    clickElementUsingJS(driver, Click_On_Customer);
		    
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-vehicle-status//div[contains(@class, 'vehicle-status')]//div[position()=7]/h6")));
	  	  } catch (Exception e) {
		          Assert.fail("Test FAILED  ::In (Pending Booking),Customer Details is not showing " );
		      }
	    }
	    
	    //...................................................................    
	    @Test(priority = 7)
	      public void Click_On_Call_Dispostion() throws InterruptedException {	       	    
	  	  try {
	  	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
	      WebElement Call_Dispostion = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()=\"Call Disposition\"])[1]")));
		   clickElementUsingJS(driver, Call_Dispostion);
		    
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Vehicle Delivery Visit \"]")));
	  	  } catch (Exception e) {
		          Assert.fail("Test FAILED  :: \n In (Pending Booking), In  Call Dispostion ,Vehicle Delivery Visit is not showing ::" );
		      }
	    }
	  //...................................................................    
	    @Test(priority = 8)
	      public void Verify_Booking_Feedback() throws InterruptedException {	       	    	  	  	  	 
	  	  Select_Option_Booking_Feedback();
	  	 
	    }
	  //...................................................................    
	    @Test(priority = 9)
	      public void Booking_Feedback_SuccessMessage() throws InterruptedException {	       	    	  	  	  	 
	    	 try {
	    	SuccesMessage();
	    }catch(Exception e){
    		Assert.fail("After Punching Booking_Feedback, success message is not Display ");
    	}
    }
	  //...................................................................    
	    @Test(priority = 10)
	      public void Click_On_Customer1() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
 //...................................................................    
	    @Test(priority =11)
	      public void Verify_Call_Me_Later() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	CallMeLater();
	    }
//...................................................................    
	    @Test(priority =12)
	      public void Call_Me_Later_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching callMelater success message is not Display ");
	    	}
	    }
	    
	  //...................................................................    
	    @Test(priority = 13)
	      public void Click_On_Customer2() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	//...................................................................    
	    @Test(priority =14)
	      public void Verify_WrongNumber() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	WrongNUMBER();
	    	}
	  //...................................................................    
	    @Test(priority =15)
	      public void WrongNumber_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching WrongNumber success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 16)
	      public void Click_On_Customer3() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	  //...................................................................    
	    @Test(priority =17)
	      public void Verify_VehicleDelivery_Visit() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	VehicleDelivery_Visit();
	    	}
	  //...................................................................    
	    @Test(priority =18)
	      public void VehicleDelivery_Visit_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching VehicleDelivery_Visit success message is not Display ");
	    	}
	    }
	  //...................................................................    
	    @Test(priority = 19)
	      public void Click_On_Customer4() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	  //...................................................................    
	    @Test(priority =20)
	      public void ClickOn_NotPickedUp() throws InterruptedException {	
	    	Thread.sleep(1000);
	    	NOtPickedUp();
	    }
	    
	  //...................................................................    
	    @Test(priority =21)
	      public void Verify_NotPickedUp() throws InterruptedException {	 
	    	Thread.sleep(300);
	        NO("Not PickedUp");
	    	}
	  //...................................................................    
	    @Test(priority =22)
	      public void NotPickedUp_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching NotPickedUp success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 23)
	      public void Click_On_Customer5() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	  //...................................................................    
	    @Test(priority =24)
	      public void ClickOn_NumberBusy() throws InterruptedException {	
	    	Thread.sleep(1000);
	    	NumberBusy();
	    }
	    //...................................................................    
	    @Test(priority =25)
	      public void Verify_NumberBusy() throws InterruptedException {	 
	    	Thread.sleep(300);
	        NO("NumberBusy");
	    	}
	  //...................................................................    
	    @Test(priority =26)
	      public void NumberBusy_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching NumberBusy success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 27)
	      public void Click_On_Customer6() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	    //...................................................................    
	    @Test(priority =28)
	      public void ClickOn_NotRechable() throws InterruptedException {	
	    	Thread.sleep(1000);
	    	NotRechable();
	    }
	    //...................................................................    
	    @Test(priority =29)
	      public void Verify_NotRechable() throws InterruptedException {	 
	    	Thread.sleep(300);
	        NO("NotRechable");
	    	}
	  //...................................................................    
	    @Test(priority =30)
	      public void NotRechable_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching NotRechable success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 31)
	      public void Click_On_Customer7() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	  //...................................................................    
	    @Test(priority =32)
	      public void ClickOn_SwitchedOff() throws InterruptedException {	
	    	Thread.sleep(1000);
	    	SwitchedOff();
	    }
	    //...................................................................    
	    @Test(priority =33)
	      public void Verify_SwitchedOff() throws InterruptedException {	 
	    	Thread.sleep(300);
	        NO("SwitchedOff");
	    	}
	  //...................................................................    
	    @Test(priority =34)
	      public void SwitchedOff_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching SwitchedOff success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 35)
	      public void Click_On_Customer8() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	    
	    //...................................................................    
	    @Test(priority =36)
	      public void ClickOn_Invalid_Numbers() throws InterruptedException {	
	    	Thread.sleep(1000);
	    	InvalidNumbers();
	    }
	    //...................................................................    
	    @Test(priority =37)
	      public void Verify_Invalid_Numbers() throws InterruptedException {	 
	    	Thread.sleep(300);
	    	InvalidNUMBERS();
	    	}
	  //...................................................................    
	    @Test(priority =38)
	      public void Invalid_Numbers_SuccessMessage() throws InterruptedException {	 
	    	try {
	    	SuccesMessage();
	    	}catch(Exception e){
	    		Assert.fail("After Punching Invalid_Numbers success message is not Display ");
	    	}
	    }
	    //...................................................................    
	    @Test(priority = 39)
	      public void Click_On_Customer9() throws InterruptedException {	 
	    	Thread.sleep(1000);
	    	Click_On_CustomerPage_And_FillterButton();
	    }
	    
	  //.................................................................................................	  
	    public void InvalidNumbers() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement No = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"No\"]")));		    
		      clickElementUsingJS(driver, No);		      		    
		      Thread.sleep(400);
		      WebElement InvalidNumber = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Invalid number \"]")));		    
		      clickElementUsingJS(driver, InvalidNumber);
		      
	    }
	  //.................................................................................................	  
	    public void SwitchedOff() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement No = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"No\"]")));		    
		      clickElementUsingJS(driver, No);		      		    
		      Thread.sleep(400);
		      WebElement SwitchOff = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Switched off \"]")));		    
		      clickElementUsingJS(driver, SwitchOff);
		      
	    }
	    
	  //.................................................................................................	  
	    public void NotRechable() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement No = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"No\"]")));		    
		      clickElementUsingJS(driver, No);		      		    
		      Thread.sleep(400);
		      WebElement NotRechable = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Not reachable \"]")));		    
		      clickElementUsingJS(driver, NotRechable);
		      
	    }
	  //.................................................................................................	  
	    public void NumberBusy() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement No = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"No\"]")));		    
		      clickElementUsingJS(driver, No);		      		    
		      Thread.sleep(400);
		      WebElement Number_busy = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Number busy \"]")));		    
		      clickElementUsingJS(driver, Number_busy);
		      
	    }
	  //.................................................................................................	  
	    public void InvalidNUMBERS() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement EnterNumbers = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[starts-with(@id, 'mat-input-')])[1]")));		    
		      EnterNumbers.sendKeys("9934202469");   
		      Thread.sleep(400);
		      
		      WebElement QCE_Remarks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[starts-with(@id, 'mat-input-')])[2]")));		    
		      QCE_Remarks.sendKeys("Invalid Numbers");   
		      Thread.sleep(400);
		      
		      WebElement Mark_Unrelaible = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\" Mark Unreliable \"]")));		    
		      Mark_Unrelaible.click();
	    }
	    
	    //.................................................................................................	  
	    public void NOtPickedUp() throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement No = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"No\"]")));		    
		      clickElementUsingJS(driver, No);		      		    
		      Thread.sleep(400);
	    }
	    //.................................................................................................	  
	    public void NO(String Text) throws InterruptedException {	     	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	  Thread.sleep(400);	    	
		      WebElement NextCallDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a date\"]")));		    
		      clickElementUsingJS(driver, NextCallDate);
		      Thread.sleep(500);
		      WebElement selectTodayDate = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today\"]")));		    
		      clickElementUsingJS(driver, selectTodayDate);
		    
		      Thread.sleep(400);
		      WebElement NextCallTime = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a time\"]")));
              clickElementUsingJS(driver, NextCallTime);           
              Thread.sleep(400);		      
		      WebElement Select_Minute = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[2]")));
		      clickElementUsingJS(driver, Select_Minute);
		      Thread.sleep(400);
		      WebElement Select_Second = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[4]")));
		      clickElementUsingJS(driver, Select_Second);
		      Thread.sleep(400);
		      WebElement Select_OK = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"OK \"]")));
		      clickElementUsingJS(driver, Select_OK);
		    
		      Thread.sleep(400);
		      WebElement QCERemarks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[1]")));
		      QCERemarks.sendKeys(Text);
		      
		      Thread.sleep(400);
		      WebElement Submit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Submit \"]")));
		      clickElementUsingJS(driver, Submit);
	    }
//.................................................................................................	  
	    public void WrongNUMBER() throws InterruptedException {	 
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	 
	    	
			WebElement ClickWrongNumber = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Wrong Number \"]")));
			clickElementUsingJS(driver, ClickWrongNumber);
			Thread.sleep(400);
	    	WebElement QCERemarks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[1]")));
		    QCERemarks.sendKeys("WrongNumber");		   
		    Thread.sleep(400);
		    WebElement Submit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Submit \"]")));
		    clickElementUsingJS(driver, Submit);
	    }
	  //.......................................................................................
	    public void VehicleDelivery_Visit() throws InterruptedException {
	    	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
	    	  WebElement VehicleDelivery = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Vehicle Delivery Visit \"]")));		    
		      clickElementUsingJS(driver, VehicleDelivery);
		      Thread.sleep(400);
	    	
		      WebElement PreferdDateVisit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a date\"]")));		    
		      clickElementUsingJS(driver, PreferdDateVisit);
		      Thread.sleep(500);
		      WebElement selectTodayDate = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today\"]")));		    
		      clickElementUsingJS(driver, selectTodayDate);
		    
		      Thread.sleep(400);
		      WebElement PreferdShiftTime = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a time\"]")));
              clickElementUsingJS(driver, PreferdShiftTime);           
              Thread.sleep(400);		      
		      WebElement Select_Minute = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[2]")));
		      clickElementUsingJS(driver, Select_Minute);
		      Thread.sleep(400);
		      WebElement Select_Second = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[4]")));
		      clickElementUsingJS(driver, Select_Second);
		      Thread.sleep(400);
		      WebElement Select_OK = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"OK \"]")));
		      clickElementUsingJS(driver, Select_OK);
		            		     		      
		      Thread.sleep(400);
		      WebElement CustomerVOC = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[1]")));
		      CustomerVOC.sendKeys("VehicleDelivery");
		      Thread.sleep(400);
		      WebElement QCERemarks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[2]")));
		      QCERemarks.sendKeys("VehicleDelivery");
		      
		      Thread.sleep(400);
		      WebElement Submit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Submit \"]")));
		      clickElementUsingJS(driver, Submit);
	    }
//.......................................................................................
	    public void CallMeLater() throws InterruptedException {
	    	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
	    	  WebElement Click_On_CallmeLater = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Call me later \"]")));		    
		      clickElementUsingJS(driver, Click_On_CallmeLater);
		      Thread.sleep(400);
	    	
		      WebElement NextCallDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a date\"]")));		    
		      clickElementUsingJS(driver, NextCallDate);
		      Thread.sleep(500);
		      WebElement selectTodayDate = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today\"]")));		    
		      clickElementUsingJS(driver, selectTodayDate);
		    
		      Thread.sleep(400);
		      WebElement Select_NextCAllTime = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Choose a time\"]")));
              clickElementUsingJS(driver, Select_NextCAllTime);           
              Thread.sleep(400);		      
		      WebElement Select_Minute = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[2]")));
		      clickElementUsingJS(driver, Select_Minute);
		      Thread.sleep(400);
		      WebElement Select_Second = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class, 'clock-face__number')])[4]")));
		      clickElementUsingJS(driver, Select_Second);
		      Thread.sleep(400);
		      WebElement Select_OK = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"OK \"]")));
		      clickElementUsingJS(driver, Select_OK);
		            
		      Thread.sleep(400);
		      WebElement PreferedLanguage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Select an option\"]")));
		      clickElementUsingJS(driver, PreferedLanguage);
		      Thread.sleep(400);
		      WebElement English = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role=\"option\"])[2]")));
		      clickElementUsingJS(driver, English);
		      
		      Thread.sleep(400);
		      WebElement CustomerVOC = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[1]")));
		      CustomerVOC.sendKeys("Later");
		      Thread.sleep(400);
		      WebElement QCERemarks = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@rows=\"1\"])[2]")));
		      QCERemarks.sendKeys("Call me Later");
		      
		      Thread.sleep(400);
		      WebElement Submit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Submit \"]")));
		      clickElementUsingJS(driver, Submit);
	    }
//.......................................................................................
	    private void Select_Option_Booking_Feedback() throws InterruptedException {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Helper method to click elements with a short delay
	        String[] optionsToClick = {
	            "(//*[text()=\" Yes \"])[1]",
	            "(//*[text()=\" Yes \"])[2]",
	            "(//*[text()=\" Yes \"])[3]",
	            "(//*[text()=\" Yes \"])[4]",
	            "(//*[text()=\" Yes \"])[5]",
	            "(//*[text()=\" Yes \"])[6]",
	            "(//*[text()=\" Yes \"])[7]",
	            "(//*[text()=\" Yes \"])[8]",
	            "(//*[text()=\"Very Good\"])[1]",	           
	        };

	        for (String xpath : optionsToClick) {
	            clickElementWithDelay(driver, wait, xpath);
	        }

	        // Enter feedback text
	        enterTextWithDelay(wait, "(//*[@rows=\"1\"])[1]", "Booking Feedback");
	        enterTextWithDelay(wait, "(//*[@rows=\"1\"])[2]", "Booking Feedback2");

	        // Click submit
	        clickElementWithDelay(driver, wait, "//*[text()=\" Submit \"]");
	    }
//.......................................................................................................
	    // Reusable method to click element with delay
	    private void clickElementWithDelay(WebDriver driver, WebDriverWait wait, String xpath) throws InterruptedException {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        clickElementUsingJS(driver, element);
	        Thread.sleep(400);
	    }

	    // Reusable method to enter text with delay
	    private void enterTextWithDelay(WebDriverWait wait, String xpath, String text) throws InterruptedException {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        element.sendKeys(text);
	        Thread.sleep(400);
	    }

	    private void SuccesMessage() {
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	    	
	      WebElement Message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"Call disposition submitted successfully!\")]")));
	      if(!Message.isDisplayed()) {
	    	 Assert.fail("In Call -Disposition ,Booking  Feedback not Punched"); 
	      }
	   }
            	               
	 //.....................................................................
		public void clickElementUsingJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	//..................................................................................
	 private void   Click_On_CustomerPage_And_FillterButton() throws InterruptedException {
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		    
		    // We have to check that Additional fillter is clikable or not	
		    	try {    
			    	 WebElement Clcik_On_Total_Booking = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Total Booking\"]")));
			    	 Clcik_On_Total_Booking.click();
			    	 Thread.sleep(1400);
			    	 
		    	 WebElement Additional_Fillter_Button = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"filter-span\"]")));
		    	   	    	
		    	 if (Additional_Fillter_Button.isDisplayed() && Additional_Fillter_Button.isEnabled()) {
		    		 Additional_Fillter_Button.click();
			           // System.out.println("Additional Fillter_Button clicked successfully.");
			        } else {
			            System.out.println("Additional Fillter_Button  is not clickable. Test Failed!");
			            throw new RuntimeException("Additional Fillter_Button is not clickable.");
			        }
			    } catch (Exception e) {
			    	Assert.fail("Additional Fillter_Button could not be clickable.");
			        throw new RuntimeException("Additional Fillter_Button could not be clickable.");
			    }	    	
		    	// click on clear button to clear the data 	    		    
			      WebElement Clear = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Clear\"]")));
		 	  clickElementUsingJS(driver, Clear);
		 	  
		 	  WebElement Close_Button = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"close-btn\"]")));
			  clickElementUsingJS(driver, Close_Button);
			 
		   // wait for some Time 
			  Thread.sleep(5000); 
			  WebElement Click_On_Customer = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-booking-table//table/tbody//td[3]")));
			    clickElementUsingJS(driver, Click_On_Customer);
			    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()=\"Call Disposition\"])[1]")));

			    WebElement Call_Dispostion = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()=\"Call Disposition\"])[1]")));
				clickElementUsingJS(driver, Call_Dispostion);				    
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Vehicle Delivery Visit \"]")));

		       } 
	 
	 
	 }