package webHelper;

import model.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {



    public static void initializeDriver(Browser browser){
        WebDriver driver = null;

        switch (browser){
            case CHROME:

                System.setProperty("webdriver.chrome.driver", ContextManager.globalCOntext.getValue(""));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                break;
        }
    }



}
