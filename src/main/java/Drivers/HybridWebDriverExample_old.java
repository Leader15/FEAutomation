/*
package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class HybridWebDriverExample_old {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static WebDriver sharedDriver;
    private Properties properties;

    public HybridWebDriverExample_old(boolean runInParallel, String browserType) {
        loadConfig();
        if (runInParallel) {
            initializeDriver(browserType);
        } else {
            if (sharedDriver == null) {
                initializeDriver(browserType);
                sharedDriver = driverThreadLocal.get();
            } else {
                driverThreadLocal.set(sharedDriver);
            }
        }
    }


    private void loadConfig() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
                String parallelTests = properties.getProperty("parallel.tests");
                System.out.println("parallel.tests property value: " + parallelTests);
            } else {
                System.err.println("Failed to load config.properties. Make sure it exists in the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initializeDriver(String browserType) {
        WebDriver driver = null;
        if ("chrome".equalsIgnoreCase(browserType)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        driverThreadLocal.set(driver);
    }


    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
    }
}
*/
