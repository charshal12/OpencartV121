package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import javax.activation.DataSource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter; //UI of the Report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; //creating test case entries in the report and update status of the test methods
    String reportName;

    @Override
    public void onStart(ITestContext testContext) {
        /*** SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Date dt = new Date();
            String currentdatetimestamp=df.format(dt);***/

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp to embed in reportName
        reportName = "Test-Report" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);//Specify the location of the report
        sparkReporter.config().setDocumentTitle("Opencart Automation report");//Title of report
        sparkReporter.config().setReportName("Opencart Functional Testing");//Name of report
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter); // connecting the UI and information classes

        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("Usr Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        //Details we need to capture from xml file
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System",os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()){
            extent.setSystemInfo("Groups",includedGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); //create new entry in report
        test.assignCategory(result.getMethod().getGroups()); //To display groups in reports
        test.log(Status.PASS, result.getName() + " got successfully executed"); //Update status p/f/s
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); //create new entry in report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,result.getName()+ " got Failed"); //Update status p/f/s
        test.log(Status.INFO, result.getThrowable().getMessage());

        //Screenshot
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
//        try {
//            new BaseClass().captureScreen(result.getName());
//            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
//                    MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
//                            .build());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); //create new entry in report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName()+ " got skipped"); //Update status p/f/s
        test.log(Status.INFO,result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        //Automatically the Report will open im browser
        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().open(extentReport);
        }catch (IOException e){
            e.printStackTrace();
        }

//        try {
//            URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+reportName);
//
//            //Create Email message
//            ImageHtmlEmail email = new ImageHtmlEmail();
//            email.setDataSourceResolver(new DataSourceUrlResolver(url));
//            email.setHostName("smtp.googlemail.com");
//            email.setSmtpPort(465);
//            email.setAuthenticator(new DefaultAuthenticator("harshaltestautomation@gmail.com","Test@123"));
//            email.setSSLOnConnect(true);
//
//            //Sender
//            email.setFrom("harshaltestautomation@gmail.com");
//
//            email.setSubject("Test Results");
//            email.setMsg("Please find Attached Report...");
//            //Reciever
//            email.addTo("chaudhari.harshal300@gmail.com");
//            email.attach(url,"extent report","Please check report...");
//            email.send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
