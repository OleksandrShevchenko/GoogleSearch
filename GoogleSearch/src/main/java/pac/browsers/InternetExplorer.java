package pac.browsers;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorer extends WebDriverGeneral {

    public InternetExplorer() {
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        this.setDriver(new InternetExplorerDriver(capabilities));
    }
}