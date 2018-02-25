package pac.browsers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox extends WebDriverGeneral {
    public FireFox() {
        FirefoxDriverManager.getInstance().setup();
        this.setDriver(new FirefoxDriver());
    }
}
