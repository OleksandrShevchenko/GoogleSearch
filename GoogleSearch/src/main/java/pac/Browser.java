package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Browser {

    public static void open(String url) {
        WebDriver webDriver = Driver.getWebDriver();
        webDriver.manage().window().maximize();
        Log.info(String.format("Open browser with %s url adress", url));
        webDriver.get(url);
    }
	
	public static WebElement getElement (By webElement) {
        return Driver.getWebDriver().findElement(webElement);
	}
	
    public static String getTitle(){
        Log.info("Get title from browser");
        return Driver.getWebDriver().getTitle();
    }

    public static void quit(){
        if (Driver.getWebDriver(false) != null){
            Log.info("Closing Browser");
            Driver.getWebDriver().quit();
            Driver.setWebDriver(null);
        }
    }
}
