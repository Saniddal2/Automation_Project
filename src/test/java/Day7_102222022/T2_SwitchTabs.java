package Day7_102222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {
        //define webdrivermanager set up for chrome driver
        WebDriverManager.chromedriver().setup();
        //define chrome options
        ChromeOptions options = new ChromeOptions();
        //add options to maximizing and incognito
        options.addArguments("start-maximized", "incognito");
        //defining variable and storing it in webdriver
        WebDriver driver = new ChromeDriver(options);


        driver.navigate().to("https://www.fideliscare.org/");
        //wait two seconds for page to load
        Thread.sleep(2000);
        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class='btn btn-outline-primary btn-external btn-show link-external']")).click();
        //store tabs in array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Parent tab is" + tabs.get(0));
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);
        //close the current doctor tab
        //driver.close();
        //switch to the initial tab (parent tab)
        driver.switchTo().window(tabs.get(0));
        //go to home page
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);
        //click on coverage , first match is index 0
        driver.findElement(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).click();
        //driver.findElements(By.xpath("//*[@class = 'btn ng-binding btn-primary']"))get(0).click();
        Thread.sleep(2000);



    }//end of main
}//end of class
