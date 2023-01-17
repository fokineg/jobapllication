package demoNG;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 *
 * @author Egor
 */
public class Test1 {
    
     static WebDriver driver;
     
    public Test1() {
       
    }

    @Test
    public void firstTest (){
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("testng");
    }
    
    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest () throws IOException{
 //       driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]"))
 //              .click();
          driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 //         String query = driver.findElement(By.xpath("//body/div[@id='searchform']/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"))
 //                 .getText();
 //         if("testng".equals(query))
 //             throw new IOException("Wrong query!");
    }
    
    
    @BeforeSuite
    public static void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", 
                ".//chromedriver100.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().
                pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().
                implicitlyWait(Duration.ofSeconds(10));
        
    }

    @AfterSuite
    public static void tearDownClass() throws Exception {
        driver.quit();
    }
}
