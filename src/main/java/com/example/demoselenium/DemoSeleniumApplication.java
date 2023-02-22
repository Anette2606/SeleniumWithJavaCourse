package com.example.demoselenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.demoselenium.DemoSeleniumApplication;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import java.util.List;
import java.util.Arrays;
import java.net.HttpURLConnection;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;




@SpringBootApplication
public class DemoSeleniumApplication {
     static ExtentReports extent;

    public static void main(String[] args) throws InterruptedException, IOException {

       // SpringApplication.run(DemoSeleniumApplication.class, args);

        System.out.printf("La clase se ejecuta");
        System.out.printf("EL PATH ES:");
        System.out.println(config());
        /*
        //Invoking CHROME Browser
        System.setProperty("webdriver.chrome.driver", "C:\\DiversA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        Invoking EDGE Browser
        System.setProperty("webdriver.edge.driver", "C:\\DiversA\\edgedriver_win64\\msedgedriver.exe");WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        System.out.println(SignIn(driver));
        driver.close();
        driver.quit();
        */



    }
    @BeforeTest
    public static String config(){
        String Path = System.getProperty("user.dir")+ "\\reports\\index.xml";
        ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");




        extent.createTest("TestName").pass("Test Passed");

        extent.flush();
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Anette Avila");


        String res;
        res=Path;
        return res;

    }
    @Test
    public void InitialDemo(){
        extent.createTest("Initial Demo");
        //Invoking CHROME Browser
        System.setProperty("webdriver.chrome.driver", "C:\\DiversA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());

        driver.close();
        driver.quit();

    }

    public static String SignIn(WebDriver driver) throws InterruptedException {

        //TO SIGN IN IN LOCATORSPRACTICE PAGE
        String name = "rahul";
        //Wr get the password
        String password = getPassword(driver);
        //Sign in
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();



        String res = "Sign in success";
        return res;
    }


    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText =driver.findElement(By.cssSelector("form p")).getText();

//Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");

// String[] passwordArray2 = passwordArray[1].split("'");

// passwordArray2[0]
        String password = passwordArray[1].split("'")[0];
        return password;


    }

    public static String Dropdowns(WebDriver driver) throws InterruptedException{
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // We get all options and save them

        for(WebElement option :options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }


    String res = "Dropdowns success";
        return res;
    }

/*    public static String AddtoCard (WebDriver driver) throws InterruptedException{


        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
        //WebDriverWait w =new WebDriverWait(driver,time);
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

//explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        String res = "AddtoCard success";
        return res;

    }*/

    public static  void addItems(WebDriver driver,String[] itemsNeeded)

    {

        int j=0;

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)

        {
            String[] name=products.get(i).getText().split("-");
            String formattedName=name[0].trim();
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsNeeded.length)
                {
                    break;

                }

            }

        }
    }

    public static String WIndowHandles (WebDriver driver) throws InterruptedException{
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String>it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        driver.findElement(By.cssSelector(".im-para.red")).getText();
        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);
        String res = "WIndowHandles success";
        return res;
    }

    public static String calendario (WebDriver driver) throws InterruptedException{

        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //URL launch
        driver.get("https://jqueryui.com/datepicker/#date%E2%88%92range");
        //identify and switch to frame
        WebElement r = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(r);
        //identify element
        WebElement e = driver.findElement(By.id("datepicker"));
        e.click();
        //identify elements with td tag in list
        List<WebElement> d =driver.findElements(By.xpath("//table/tbody/tr/td"));
        //iterate list
        for (int i = 0; i<d.size(); i++) {
            //check expected data
            String s = d.get(i).getText();
            if (s.equals("2")) {
                d.get(i).click();
                break;
            }
        }
        //get data selected
        String m = e.getAttribute("value");
        System.out.print("Date selected in calendar is: "+ m);
        //close browser
        driver.quit();

        String res = "Calendar success";
        return res;
    }
/*
    public static String BrokenLinks (WebDriver driver) throws InterruptedException, IOException {

        //broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        //  Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url is broken
        //a[href*="soapui"]'
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a =new SoftAssert();
        for(WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);
        }
        a.assertAll();
        String res = "BrokenLinks success";
        return res;*/
    }



