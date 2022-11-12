package Day11_11042022;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;

        @BeforeSuite
        public void SetChromeDriver() {
            driver = Reusable_Library.ReusableActions.ReusableActions.setUpDriver();

        }//end of set driver method
        @AfterSuite
        public void quitTheSession() {
            driver.quit();
        }//end of after suite

    //verify that by default signed in option should be checked
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
            //navigate to yahoo.com home page
            driver.navigate().to("https://www.yahoo.com/");
    //next we meed to click on sign in button
            Reusable_Library.ReusableActions.ReusableActions.clickAction(driver,"//*@class = '_yb_1933e']","Sign in button");
            //we need to verify that signed in option is checked
    boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
    System.out.println("The checkbox check condition is: " + isSignInChecked);
        }//End of test 1

        @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
        public void tc002_verifySignedInOptionIsUnchecked(){
        //click on check box to uncheck it
        ReusableActions.ReusableActions.clickAction(driver,"//*[@class= 'stay-signed-in checkbox-container']","SignedInCheckBox");
        //we need to verify that signed in option is checked
            boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent'")).isSelected();
            System.out.println("The checkbox check condition is" + isSignInChecked);

        }//End of test 2
}//end of main class

