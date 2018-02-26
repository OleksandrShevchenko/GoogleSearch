package pac;

import org.openqa.selenium.WebDriver;
import pac.browsers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Driver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final String propFileName = "src/main/resources/config.properties";

    public enum BrowserType {
        CHROME("Chrome", new String[]{"--disable-extensions", "--allow-running-insecure-content",
                "--ignore-certificate-errors", "--disable-print-preview", "--test-type", "--disable-web-security", "--disk-cache-size=1",
                "--media-cache-size=1", "--disable-infobars"}),
        OPERA("Opera"),
        FIREFOX("FireFox"),
        IE("InternetExplorer"),
        SAFARI("Safari"),
        EDGE("Edge");
        private final Object[] values;

        BrowserType(Object... vals) {
            values = vals;
        }

        public String getName() {
            return (String) values[0];
        }

        public String[] getOptions() {
            return (String[]) values[1];
        }

        public static BrowserType findByName(String name) {
            for (BrowserType v : values()) {
                if (v.getName().equals(name)) {
                    return v;
                }
            }
            return BrowserType.CHROME;
        }

    }

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            BrowserType type = BrowserType.findByName(Prop.get("browser"));
            switch (type) {
                case CHROME:
                    setChromeDriver();
                    break;
                case OPERA:
                    setOperaDriver();
                    break;
                case FIREFOX:
                    setFireFoxDriver();
                    break;
                case IE:
                    setIExplorerDriver();
                    break;
                case SAFARI:
                    setSafariDriver();
                    break;
                case EDGE:
                    setEdgeDriver();
                    break;
            }
            webDriver.get().manage().timeouts().implicitlyWait(Long.parseLong(Prop.get("defaultImplicitWait")), TimeUnit.SECONDS);
            webDriver.get().manage().timeouts().pageLoadTimeout(Long.parseLong(Prop.get("pageLoadTimeout")), TimeUnit.SECONDS);
        }
        return webDriver.get();
    }

    public static WebDriver getWebDriver(boolean createNewDriver) {
        if (!createNewDriver) {
            return webDriver.get();
        }
        return getWebDriver();
    }

    public static class Prop {
        public static String get(String property) {
            String out = "";
            Properties prop = new Properties();
            try (InputStream file = new FileInputStream(new File(propFileName).getAbsolutePath())) {
                prop.load(file);
                out = prop.getProperty(property);
            } catch (Exception e) {
                System.err.println("Exception: " + e);
            }
            return out;

        }
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    private static void setChromeDriver() {
        setWebDriver(new Chrome().getDriver());
    }

    private static void setFireFoxDriver() {
        setWebDriver(new FireFox().getDriver());
    }

    private static void setOperaDriver() {
        setWebDriver(new Opera().getDriver());
    }

    private static void setIExplorerDriver() {
        setWebDriver(new InternetExplorer().getDriver());
    }

    private static void setSafariDriver() {
        setWebDriver(new Safari().getDriver());
    }

    private static void setEdgeDriver() {
        setWebDriver(new Edge().getDriver());
    }
}
