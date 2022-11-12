package Day7_102222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;


public class In_Class_Action_Item2 {
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            ChromeOptions options= new ChromeOptions();
            options.addArguments("incognito,start-maximized");
            JavascriptExecutor jsExec= (JavascriptExecutor) driver;

            //declare array list
            ArrayList<String> State = new ArrayList<>();
            ArrayList<String> Adult = new ArrayList<>();
            State.add("California");
            State.add("Florida");
            State.add("Texas");
            // Adult arraylist
            Adult.add("2");
            Adult.add("3");
            Adult.add("4");
            // declare for loop

            for (int i = 0; i < State.size(); i++) {


                // navigate to Hotels.com
                try {
                    driver.navigate().to("https://www.hotels.com/");
                } catch (Exception e) {
                    System.out.println(" unable to navigate to Hotels.com" + e);
                }// end of exception

                Thread.sleep(1000);
                //Click on destination
                driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
                //type your destination
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(State.get(i));
                //click on search result
                driver.findElements(By.xpath("//*[@class='truncate']")).get(0).click();
                //click on traveler
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
                //pass adult arraylist

                Thread.sleep(1000);

                //children set to one
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
                Thread.sleep(1000);

                try {
                    //age
                    driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']")).click();
                    WebElement ChildAge = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                    Select ChildAge_Dropdown = new Select(ChildAge);
                    ChildAge_Dropdown.selectByVisibleText("2");
                } catch (Exception e) {
                    System.out.println(" ChildAge doesn't run " + e);
                }// end of exception

                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                //Submit
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();

                //describe arraylist
                ArrayList<WebElement>links=new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
                //click hotel link
                if (i==0){
                    links.get(1).click();
                } else if (i==1){
                    links.get(2).click();
                } else if (i==2){
                    links.get(0).click();
                } // end of if else condition

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

