package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {
public static  WebDriver driver;
    @BeforeMethod
    public void SetUpBrowser(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closebrowser(){
        driver.quit();
    }

    @Test(groups ="regression")
    public void loginFunctionlity(){
      WebElement username  =driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("admin");
        WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("admin");
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id = 'btnLogin']"));
        loginBtn.click();
    }
    @Test
    public void passwordTextBoxVerification(){

        WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        System.out.println(password.isDisplayed());
    }
}
