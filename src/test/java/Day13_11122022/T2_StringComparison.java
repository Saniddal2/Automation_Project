package Day13_11122022;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Day11_11042022.T3_reusableannotation_yahooCheckbox.driver;

public class T2_StringComparison {
    import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Day11_11042022.T3_reusableannotation_yahooCheckbox.driver;

    public class T1_screenshot_Yahoo extends ReusableLibrary.Reusable_Annotations {
        @Test(priority = 1)
        public void tc001_verifyYahooPageTitle() {
            //first navigate to yahoo homepage
            driver.navigate().to("https://www.yahoo.com/");
            //define our expected string variable
            String expectedTitle = "Yahoo..";
            //get page title
            String actualTitle = driver.getTitle();
           // System.out.println("My actual title is:" + actualTitle);
            //System.out.println("My expected title is:" + expectedTitle);

            if (actualTitle.equals(expectedTitle)){
                logger.log(LogStatus.PASS, "Expected Result matches Actual Result");

            }
            else {
                logger.log(LogStatus.FAIL, "Expected REsult does not match Actual Result");
            }

        }// end of test 1

        @Test(priority = 1)
        public void tc001_verifyYahooSignInText(){
            //first navigate to yahoo.com
            driver.navigate().to("https://www.yahoo.com/");
            //define our expected string variable
            String expectedYahooSignInButtonText = "Sign In";
            ReusableLibrary.ReusableAction_Loggers.compareExpectedAndActualText(expectedYahooSignInButtonText, actualYahooSignInButtonText,logger);
        }
    }
}
