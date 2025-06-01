package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utilities.ConfigReader;

public class Driver {
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigReader.get("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--incognito");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized");
                    driverPool.set(new EdgeDriver(edgeOptions));
                    break;

                case "headless-chrome":
                    ChromeOptions headlessChrome = new ChromeOptions();
                    headlessChrome.addArguments("--headless=new");
                    headlessChrome.addArguments("--window-size=1920,1080");
                    headlessChrome.addArguments("--disable-gpu");
                    headlessChrome.addArguments("--incognito");
                    driverPool.set(new ChromeDriver(headlessChrome));
                    break;

                default:
                    throw new RuntimeException("Invalid browser name: " + browser);
            }

        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
