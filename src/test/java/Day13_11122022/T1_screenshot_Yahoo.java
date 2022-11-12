package Day13_11122022;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Day11_11042022.T3_reusableannotation_yahooCheckbox.driver;

public class T1_screenshot_Yahoo extends ReusableLibrary.Reusable_Annotation {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        //this will fail because the xpath is incorrect
        ReusableLibrary.ReusableAction_Loggers.clickAction(driver,"//*[@class = '_yb_1933eyyyy']", logger, "Sign in");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is:" + isSignInChecked);
        logger.log(LogStatus.INFO, "The checkbox check condition is:" + isSignInChecked);
    }// end of test 1
    @Test(priority = 2)
    public void tc002_verifyYahooSignInText() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String actualYahooSignInButtonText = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class = '_yb_18vjf']", logger, "Sign In");
        //define expected string text
        String expectedYahooSignInButtonText = "Sign In";
        Reusable_Actions_Loggers.compareExpectedAndActualText(expectedYahooSignInButtonText, actualYahooSignInButtonText,logger);
    }//end of test 2

}
