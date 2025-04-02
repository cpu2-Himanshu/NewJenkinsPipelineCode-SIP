package UAT_SIP2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dealer_User_Login implements Interface_SIP{

    public static  WebDriver driver;
    public WebDriverWait wait;

    @SuppressWarnings("deprecation")
	@BeforeClass
    public void setup() {        
    	 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get(UAT_URL);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
  //.......................................................................................... 
  //................................................................................................................
    @Test(priority = 1)
    public void PopuPhandle() throws InterruptedException, AWTException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        Robot robot = new Robot();
        Thread.sleep(2000); // Wait for popup

        // Enter Username
        String username = "pMJTc$5p1@KP&nKU"; // Correct username with $5
        for (char c : username.toCharArray()) {
            // Handle uppercase and lowercase letters
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);  // Press SHIFT for uppercase
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.VK_SHIFT);  // Release SHIFT
            } else if (Character.isLowerCase(c)) {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
            } else {
                // Handle special characters
                switch (c) {
                    case '$':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_4);  // '$' is SHIFT + 4
                        robot.keyRelease(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '5':
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                        break;
                    case '1':
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                        break;
                    case '@':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_2);  // '@' is SHIFT + 2
                        robot.keyRelease(KeyEvent.VK_2);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case 'K':
                        robot.keyPress(KeyEvent.VK_K);
                        robot.keyRelease(KeyEvent.VK_K);
                        break;
                    case 'P':
                        robot.keyPress(KeyEvent.VK_P);
                        robot.keyRelease(KeyEvent.VK_P);
                        break;
                    case '&':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_7);  // '&' is SHIFT + 7
                        robot.keyRelease(KeyEvent.VK_7);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case 'n':
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyRelease(KeyEvent.VK_N);
                        break;
                    case 'U':
                        robot.keyPress(KeyEvent.VK_U);
                        robot.keyRelease(KeyEvent.VK_U);
                        break;
                    case 'C':
                        robot.keyPress(KeyEvent.VK_C);
                        robot.keyRelease(KeyEvent.VK_C);
                        break;
                    case 'T':
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);
                        break;
                    // Add more special characters as needed
                }
            }
            Thread.sleep(100); // Add delay between key presses
        }
        
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        // Enter Password
        String password = "4X0$vX#IKb@8D&0F";
        for (char c : password.toCharArray()) {
            // Handle uppercase and lowercase letters
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);  // Press SHIFT for uppercase
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.VK_SHIFT);  // Release SHIFT
            } else if (Character.isLowerCase(c)) {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
            } else {
                // Handle special characters
                switch (c) {
                    case '$':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_4);  // '$' is SHIFT + 4
                        robot.keyRelease(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '4':
                        robot.keyPress(KeyEvent.VK_4);  // Ensure 4 is typed correctly
                        robot.keyRelease(KeyEvent.VK_4);
                        break;
                    case 'X':
                        robot.keyPress(KeyEvent.VK_X);
                        robot.keyRelease(KeyEvent.VK_X);
                        break;
                    case '0':
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                        break;
                    case 'v':
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        break;
                    case '#':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_3);  // '#' is SHIFT + 3
                        robot.keyRelease(KeyEvent.VK_3);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '@':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_2);  // '@' is SHIFT + 2
                        robot.keyRelease(KeyEvent.VK_2);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case 'I':
                        robot.keyPress(KeyEvent.VK_I);
                        robot.keyRelease(KeyEvent.VK_I);
                        break;
                    case 'K':
                        robot.keyPress(KeyEvent.VK_K);
                        robot.keyRelease(KeyEvent.VK_K);
                        break;
                    case 'b':
                        robot.keyPress(KeyEvent.VK_B);
                        robot.keyRelease(KeyEvent.VK_B);
                        break;
                    case '8':
                        robot.keyPress(KeyEvent.VK_8);
                        robot.keyRelease(KeyEvent.VK_8);
                        break;
                    case 'D':
                        robot.keyPress(KeyEvent.VK_D);
                        robot.keyRelease(KeyEvent.VK_D);
                        break;
                    case '&':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_7);  // '&' is SHIFT + 7
                        robot.keyRelease(KeyEvent.VK_7);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
//                    case '0':
//                        robot.keyPress(KeyEvent.VK_0);
//                        robot.keyRelease(KeyEvent.VK_0);
//                        break;
                    case 'F':
                        robot.keyPress(KeyEvent.VK_F);
                        robot.keyRelease(KeyEvent.VK_F);
                        break;
                    // Add more special characters as needed
                }
            }
            Thread.sleep(100); // Add delay between key presses
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    //.......................................................................................... 
    @Test(priority = 2)
    public void Dealer_User_Login1() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement MSPIN = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='MSPIN']")));
        MSPIN.sendKeys(ValidMSPIN);

        WebElement SendOTP = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Send OTP ']")));
        SendOTP.click();

//        WebElement TestMSPIN = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='TEST MSPIN']")));
//        TestMSPIN.sendKeys("28857");

        WebElement Captcha = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Enter Captcha']")));
        Captcha.sendKeys(UAT_CAPTCHA);

        WebElement VerifyCaptcha = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Verify Captcha ']")));
        VerifyCaptcha.click();   
       
        ErrorMessage();   //  check for the validation message is display     
       
        WebElement OTP = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='OTP']")));
        OTP.sendKeys(ValidOTP);

        WebElement click_On_Login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Login ']")));
        click_On_Login.click();
    }
    
    @Test(priority =3)
    public void Click_On_SIP() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement SIP = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@alt='SIP']")));
            Actions actions = new Actions(driver);
            actions.doubleClick(SIP).perform();

            boolean urlChanged = wait1.until(ExpectedConditions.urlToBe(UAT_Validation_URL));
            if (urlChanged) {
                System.out.println("Test Passed: Navigated to the expected URL");
            } else {
                Assert.fail("Test Failed: Wrong Booking list Url");
            }
        } catch (Exception e) {
            Assert.fail("Test Failed: Wrong Booking list Url");
        }
    }
    //...................................................................................    
        
  //..............................Helper Method........................................................		
    public void ErrorMessage() {	
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            WebElement Errormessage = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" Enter valid MSPIN \"]")));
            if (Errormessage.isDisplayed()) {
                Assert.fail("Test Failed: Validation message 'Enter valid MSPIN' is displayed.");
                driver.quit();
            }
        } catch (TimeoutException e) {
            // If error message is not found, continue with next test case
            System.out.println("No validation message displayed, proceeding to the next test case.");
        }
    }
  
 
}