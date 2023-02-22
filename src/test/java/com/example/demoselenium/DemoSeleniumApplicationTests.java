package com.example.demoselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.Duration;


@SpringBootTest
class DemoSeleniumApplicationTests {

    @Test
    public void InitialDemo(){
        //Invoking CHROME Browser
        System.setProperty("webdriver.chrome.driver", "C:\\DiversA\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
    }
    /*
    @Parameters({ "URL" })
    @Test
    public void WebloginHomeLoan(String uname)
    {
        //selenium
        System.out.println("webloginhomePersonalLoan");
        System.out.println(uname);

    }


    @Test(groups={"Smoke"})
    public void MobileLoginHomeLoan()
    {
        //Appium
        System.out.println("MobileloginHome");
    }

    @Test
    public void LoginAPIHomeLoan()
    {
        //Rest API automation
        System.out.println("APIloginHome");
    }
    @Test
    void contextLoads() {
    }
    */

}
