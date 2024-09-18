package testBase;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
    //All reusable methods to be kept here
    public static WebDriver driver;
    public Logger logger; //log4j
    public Properties p;

    @BeforeClass(groups = {"Sanity","Regression","Master","DataDriven"})
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {
        //Loading config.properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        p=new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass()); //this-> will get name of any class, because we are going to use logger in all the classes
                                                        //dynamically we are getting class
                                                        //log4j2.xml will be automatically be fetched in logger variable

       //Selenium Grid Setup
       if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
       {
           DesiredCapabilities capabilities = new DesiredCapabilities();
           ChromeOptions options = new ChromeOptions();

           //os from XML file
           if (os.equalsIgnoreCase("windows")){
               capabilities.setPlatform(Platform.WIN11);
           } else if (os.equalsIgnoreCase("mac"))
           {
               capabilities.setPlatform(Platform.MAC);
           }  else if (os.equalsIgnoreCase("linux"))
           {
               capabilities.setPlatform(Platform.LINUX);
           } else {
               System.out.println("No matching os found");
               return;
           }

           //br from XML file
            switch (br.toLowerCase())
            {
                case "chrome" :
                    capabilities.setBrowserName("chrome");
//                    capabilities.setVersion("128.0.6613.86");
                  //  System.setProperty("webdriver.chrome.driver", "D:\\Study\\Interview\\workspace\\OpencartV121\\Drivers\\chromedriver128.exe");

           //         WebDriverManager.chromedriver().clearDriverCache().setup();
             //       WebDriverManager.chromedriver().driverVersion("120").setup();
                                break;
                case "edge" :  capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox" :  capabilities.setBrowserName("firefox");
                capabilities.setVersion("130.0");
                break;
                default :
                    System.out.println("No Matching browser name"); return;
            }

           WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
       }

       //Setup for Local System
        if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser Name");
                    return;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

    }

    @AfterClass(groups = {"Sanity","Regression","Master","DataDriven"})
    public void tearDown(){
        driver.close();
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomHumber(){
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomAlphanumeric(){
        String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
        return alphanumeric;

        /**
         * Sol2
         * String generatedString = RandomStringUtils.randomAlphabetic(3);
         * String generatedNumber = RandomStringUtils.randomNumeric(3);
         *  return(generatedString+@+generatedNumber)
         * **/
    }

    public String captureScreen(String tname) throws IOException{
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
