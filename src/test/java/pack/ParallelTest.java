package pack;

/**
 * Created by prashanth_sams on 04/03/15.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

    private WebDriver driver;
    String baseUrl = "http://www.google.com/";

    @Parameters({ "browser" })
    @BeforeTest
    public void openBrowser(String browser) {
        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver",
                        "C:/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void Test01() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("q")).sendKeys("Prashanth Sams");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Selenium Essentials");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Seleniumworks.com");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("ByPassHacker");
        System.out.println("I am one");
    }

    @Test
    public void Test02() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("q")).sendKeys("Prashanth Sams");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Selenium Essentials");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Seleniumworks.com");
        driver.findElement(By.name("q")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("ByPassHacker");
        System.out.println("I am two");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}