package pac.browsers;//package main.java.pac.browsers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pac.Driver.BrowserType;

public class Chrome extends WebDriverGeneral{

    public Chrome(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(BrowserType.findByName(BrowserType.CHROME.getName()).getOptions());
        this.setDriver(new ChromeDriver(options));
    }
}
