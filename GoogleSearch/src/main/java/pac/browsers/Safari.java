package pac.browsers;

import org.openqa.selenium.safari.SafariDriver;

public class Safari  extends WebDriverGeneral {

    public Safari(){
        this.setDriver( new SafariDriver());
    }
}