package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;



public class Action_item08 {
    public static void main(String[] args) throws InterruptedException{
        //define webdrivermanager set up for chrome driver
        WebDriverManager.chromedriver().setup();
        //define chrome options
        ChromeOptions options = new ChromeOptions();
        //add options to maximizing and incognito
        options.addArguments("start-maximized","incognito");
        //defining variable and storing it in webdriver
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipcode;
        zipcode = new ArrayList<>();
        zipcode.add("10701");
        zipcode.add("10467");
        zipcode.add("10461");

        //Java script executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < zipcode.size();i++) {
            // go to weight watchers site
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //sleep statement
            Thread.sleep(3000);
            //click on find workshop
            driver.findElements(By.xpath("//*[contains(@class,'menuItemInnerWrapper')]")).get(4).click();
            //sleep statement
            Thread.sleep(2000);
            //click on in person
            driver.findElements(By.xpath("//*[@class= 'buttonText-3DCCO']")).get(0).click();
            Thread.sleep(1000);
            //save search bar address
            WebElement search = driver.findElement((By.xpath("//*[@id='location-search']")));
            search.clear();
            search.sendKeys(zipcode.get(i));
            //click on the search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //wait 1 sec
            Thread.sleep(1000);
            //scroll to the addresses
            //jse.executeScript("scroll(0,1200");
            jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElements(By.xpath("//*[contains(@class,'filterSegment')]")).get(2));
            //jse.executeScript("arguments[0].scrollIntoView(true;)",driver.findElement(By.xpath("//*[contains@class,'filterSegment']")).get(2))
            //store the addresses of the location address elements inside web element arraylist variable
            ArrayList<WebElement> areaCode = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'wrapperLink')]")));

            if (i == 0) {
                jse.executeScript("scroll(0,1000)");
                //sleep thread
                Thread.sleep(2000);
                areaCode.get(1).click();
                //end
            }

              else if ((i == 1)){
                    // scroll down to 1300 pixels
                    jse.executeScript("scroll(0,1300)");
                    areaCode.get(2).click();
                    //end
                }
               else if (i == 2){
                    areaCode.get(0).click();
                }
                String destination = driver.findElements(By.xpath("//*[contains(@class,'address')]")).get(1).getText();
               //"\n" separating
                String[] splitDestination = destination.split("\n");
                System.out.println(splitDestination[0] + "\n" + splitDestination[1]);
                jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElements(By.xpath("//*[contains(@class,'title')]")).get(1));
                String schedule = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainerMobile')]")).getText();
                System.out.println(schedule);
                System.out.println();



        } // end of loop
       driver.quit();
    } //end of main
}  // end of java class
