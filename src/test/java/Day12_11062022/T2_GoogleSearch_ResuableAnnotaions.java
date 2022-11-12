package Day12_11062022;

import Reusable_Library.ReusableActionslogger;
import Reusable_Library.ReusableAnnotations;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ResuableAnnotaions extends ReusableAnnotations {

    @Test
    public void searchForBmw(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        ReusableActionslogger.sendkeysaction(driver,"//*[name='q']","BMW",logger,"searchFiel")
    }
}
