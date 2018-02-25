package pac.browsers;

import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.opera.OperaDriver;

public class Opera extends WebDriverGeneral {

    public Opera() {
        OperaDriverManager.getInstance().setup();
        this.setDriver(new OperaDriver());
    }
}