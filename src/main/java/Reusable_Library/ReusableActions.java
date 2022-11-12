package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActions {
    static int timeout = 10;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-maximized", "incognito");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to click for: " + elementName + "for reason:" + e);

        }
    }//

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to click by index for: " + elementName + "for reason:" + e);
        }
    }//

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hovered mouse" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to hover mouse" + elementName + "for reason:" + e);
        }
    }//

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submitted" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to submit for: " + elementName + "for reason:" + e);
        }
    }//end of submit action


    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully sent keys" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to send keys for: " + elementName + "for reason:" + e);
        }
    }//

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully got text" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to get text for: " + elementName + "for reason:" + e);
        }
        return textOutput;

    }//


    public static void selectByValue(WebDriver driver, String xpath, String userData, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByValue(userData);
            logger.log(LogStatus.PASS, "Successfully selected by value: " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select by value " + elementName + "for reason:" + e);
        }//End of catch

    }//end of select by value

    public static void selectByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(index);
            logger.log(LogStatus.PASS, "Successfully selected by index: " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to select by index: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select by index" + elementName + "for reason:" + e);
        }//end of catch

    }//End of select by visible text

    public static void switchToTabByIndex(WebDriver driver, int index) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //store the tabs in arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab
            driver.switchTo().window(tabs.get(index));


        } catch (Exception e) {
            System.out.println("Unable to switch tab by index: " + " for reason: " + e);
        }
    }//

    public static void selectByText(WebDriver driver, String xpath, String userData, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userData);
            logger.log(LogStatus.PASS, "Successfully selected by text: " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to select visible text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "unable to select by text " + elementName + "for reason:" + e);
        }//end of catch

    }//End of select by visible text


    public static void scrollByView(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully scrolled into view: " + elementName);
        } catch (Exception e) {
            System.out.println("unable to scroll : " + elementName + "for reason" + e);
            logger.log(LogStatus.FAIL, "unable to scroll into view " + elementName + "for reason:" + e);
        }//end of catch
    }//end of scrollByView
}
