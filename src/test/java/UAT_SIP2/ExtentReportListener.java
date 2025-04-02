package UAT_SIP2;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getExtentReports();
    private static ExtentTest test;

    // Store start times for each test method
    private Map<String, Long> startTimeMap = new HashMap<>();

    @Override
    public void onStart(ITestContext context) {
        // No initialization needed here
    }

    @Override
    public void onTestStart(ITestResult result) {
        String moduleName = result.getTestClass().getName();
        test = extent.createTest(result.getMethod().getMethodName())
                     .assignCategory(moduleName); // Assign module as category
        
        // Store the start time of the test
        startTimeMap.put(result.getMethod().getMethodName(), System.currentTimeMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	long executionTimeMillis = System.currentTimeMillis() - startTimeMap.get(result.getMethod().getMethodName());
    	long minutes = (executionTimeMillis / 1000) / 60;
    	long seconds = (executionTimeMillis / 1000) % 60;

    	String formattedTime = minutes + " min " + seconds + " sec";
    	System.out.println("Execution Time: " + formattedTime);
        test.pass(result.getMethod().getMethodName() + " TEST PASSED 🟢");
        test.info("Execution Time: " + formattedTime + "  ⏱️");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	long executionTimeMillis = System.currentTimeMillis() - startTimeMap.get(result.getMethod().getMethodName());
    	long minutes = (executionTimeMillis / 1000) / 60;
    	long seconds = (executionTimeMillis / 1000) % 60;

    	String formattedTime = minutes + " min " + seconds + " sec";
    	System.out.println("Execution Time: " + formattedTime);      //  String moduleName = result.getTestClass().getName();   
        String failureReason = result.getThrowable() != null ? result.getThrowable().getMessage() : "No specific error message";

        test.fail(result.getMethod().getMethodName() + " - TEST FAILED 🔴");
        test.fail("Failure Reason: " + failureReason);
        test.info("Execution Time: " + formattedTime + "  ⏱️");
              
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	long executionTimeMillis = System.currentTimeMillis() - startTimeMap.get(result.getMethod().getMethodName());
    	long minutes = (executionTimeMillis / 1000) / 60;
    	long seconds = (executionTimeMillis / 1000) % 60;

    	String formattedTime = minutes + " min " + seconds + " sec";
    	System.out.println("Execution Time: " + formattedTime);      //  String moduleName = result.getTestClass().getName();   
        String moduleName = result.getTestClass().getName();
    
        test.skip(result.getMethod().getMethodName() + " TEST SKIPPED 🟡");
        test.skip("Test Skipped in Module: " + moduleName);
        test.info("Execution Time: " + formattedTime + "  ⏱️");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}