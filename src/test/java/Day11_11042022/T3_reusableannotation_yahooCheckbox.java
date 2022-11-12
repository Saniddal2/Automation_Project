package Day11_11042022;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_reusableannotation_yahooCheckbox extends ReusableActions{
    /*
    WebDriver variable needs to get inherited to your test class but in order to do that
    it must be public static
     */
    public static WebDriver driver;
    @BeforeSuite
    public void setTheDriver(){
        driver = ReusableActions.setUpDriver();
    }//end of beforesuite

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of aftersuite

    extends Reusable_Annotations {
        @Test(priority = 1)
        public void tc001_verifySignedInOptionIsChecked() {
            //first navigate to yahoo homepage
            driver.navigate().to("https://www.yahoo.com/");
            //next we need to click on sign in button
            ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "Sign in button");
            //we need to verify that signed in option is checked
            boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
            System.out.println("The checkbox check condition is: " + isSignInChecked);
        }//end of test 1
        @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")

    }//end of test 2

}
