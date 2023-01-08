import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class maventest {
    public String baseUrl = "http://localhost:8084";
    String driverPath = "C:\\Users\\avina\\OneDrive\\Desktop\\chrome-driver\\chromedriver.exe";
    public WebDriver driver ;

    @Test
    public void test() throws InterruptedException {
// set the system property for Chrome driver      
        System.setProperty("webdriver.chrome.driver", driverPath);
// Create driver object for CHROME browser  
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
// get the current URL of the page  
        String URL= driver.getCurrentUrl();
        System.out.print(URL);
//get the title of the page  
        String title = driver.getTitle();
        System.out.println(title);
        WebElement email=driver.findElement(By.id("formEmail"));
        email.sendKeys("test@test.com");
        WebElement password=driver.findElement(By.id("formPassword"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/form/div[3]/input"));
        button.submit();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8084/loginuser.htm");
        var wait=new WebDriverWait(driver,20);
        WebElement newGame=driver.findElement(By.id("gameName"));
        wait.until(ExpectedConditions.visibilityOf(newGame));
        newGame.sendKeys("NEW GAME");
        Select isPremiumDropDown=new Select(driver.findElement(By.id("gamePremium")));
        isPremiumDropDown.selectByVisibleText("False");
       driver.findElement(By.id("gamePrice")).sendKeys("11");
        driver.findElement(By.id("gamePrice")).clear();

        driver.findElement(By.id("gamePrice")).sendKeys("13");

        driver.findElement(By.id("gameQuantity")).sendKeys("10");
        WebElement upload_file = driver.findElement(By.id("gamePhoto"));

        upload_file.sendKeys("C:\\Users\\avina\\OneDrive\\Desktop\\coding.png");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/input")).click();

    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test");
    }
}  