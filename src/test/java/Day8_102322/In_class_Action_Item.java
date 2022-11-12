package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class In_class_Action_Item {

        public static void main(String[] args) throws InterruptedException {
            //define the webdriver manager setup for chromedriver
            WebDriverManager.chromedriver().setup();
            //initialize chrome options
            ChromeOptions options = new ChromeOptions();
            // add the options for maximizing the chrome meeting
            // options.addArguments("start-fullscreen") for mac
            options.addArguments("incognito");
            //define the chrome driver to use for your test
            //creating an instance for a chrome driver(browser) to use for automation
            WebDriver driver = new ChromeDriver(options);

            //goes to hotels website
            driver.navigate().to("https://www.hotels.com/");
            //sleep statement
            Thread.sleep(2000);

            ArrayList <Integer> Adult = new ArrayList<>();
            Adult.add(2);
            //Adult.add(3);
            //Adult.add(4);

            ArrayList <String> Destination= new ArrayList<>();
            Destination.add("New York");
            //Destination.add("California");
            //Destination.add("Florida");

            for (int i=0; i<Destination.size(); i++) {
                //goes to hotels website
                driver.navigate().to("https://www.hotels.com/");
                //sleep statement
                Thread.sleep(2000);

                driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
                Thread.sleep(2000);

                WebElement search = driver.findElement(By.xpath("//*[@data-stid='destination_form_field-menu-input']"));
                search.sendKeys(Destination.get(i));
                Thread.sleep(2000);

                driver.findElements(By.xpath("//*[@class='truncate']")).get(0).click();
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']")).click();
                Thread.sleep(2000);

                for (int j = 1; j < Adult.get(0); j++) {
                    driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
                }
                Thread.sleep(2000);

                driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of children in room 1']")).click();
                Thread.sleep(2000);
                try {
                    driver.findElement(By.xpath("//*[@name= 'child-traveler_selector_children_age_selector-0-0']")).click();
                } catch (Exception e) {
                    System.out.println();
                }
                Thread.sleep(3000);

                WebElement childAge = driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
                Select childAgeDropDown = new Select(childAge);
                childAgeDropDown.selectByVisibleText("1");
                Thread.sleep(3000);

                driver.findElement(By.xpath("//*[@id= 'traveler_selector_done_button']")).click();
                Thread.sleep(3000);

                driver.findElement(By.xpath("//*[@id= 'submit_button']")).click();
                Thread.sleep(3000);

                ArrayList<WebElement>links = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
                //setting conditions for each zipcode to get the correct studio link
                if (i==0){

                    links.get(1).click();
                    Thread.sleep(2000);
                }
                if (i==1){

                    links.get(2).click();
                    Thread.sleep(2000);
                }
                if (i==2){

                    links.get(0).click();
                    Thread.sleep(2000);
                }
                // hold all window handles in array list
                ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
                //switch to new tab
                driver.switchTo().window(newTab.get(1));

                Thread.sleep(5000);
                //click on reserve a room button
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();

                Thread.sleep(3000);

                //click on reserve button
                driver.findElement(By.xpath("//*[text()='Reserve']")).click();

                //capture place name
                try {

                    String PlaceName = driver.findElement(By.xpath("//*[@id='hotel-info']")).getText();
                    System.out.println(" the First place is " + PlaceName);
                } catch (Exception e) {
                    System.out.println(" wrong input for PlaceName " + e);

                }// end of exception


                //capture the check in check out date
                try {

                    String CheckIn = driver.findElements(By.xpath("//*[@class= 'col-value va-t ta-r pv-tiny travel-dates-check-in fw-bold']")).get(0).getText();
                    System.out.println(" the check in is " + CheckIn);
                } catch (Exception e) {
                    System.out.println(" wrong input for address result " + e);

                }// end of exception

                //close current tab
                driver.close();

                //Switch to first tab
                driver.switchTo().window(newTab.get(0));

            } //end of for loop

            driver.quit();

        }//end of main class
}//end of public class







