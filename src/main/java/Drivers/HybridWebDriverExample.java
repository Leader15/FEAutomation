package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HybridWebDriverExample {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static WebDriver sharedDriver;
    private Properties properties;
    private boolean runInParallel;
    private String browserType;
    private static HybridWebDriverExample instance;

    private HybridWebDriverExample() {
        loadConfig();
        initializeDriver();

        
    }

    public static synchronized HybridWebDriverExample getInstance() {
        if (instance == null) {
            instance = new HybridWebDriverExample();
        }
        return instance;
    }

    private void loadConfig() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
                String parallelTests = properties.getProperty("parallel.tests");
                browserType = properties.getProperty("browserType");
                // Parse the values from the properties file
                runInParallel = Boolean.parseBoolean(parallelTests);

                System.out.println("parallel.tests property value: " + runInParallel);
                System.out.println("browser.type property value: " + browserType);
            } else {
                System.err.println("Failed to load config.properties. Make sure it exists in the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeDriver() {
        if (runInParallel) {
            WebDriver driver = null;
            if ("chrome".equalsIgnoreCase(browserType)) {
                System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else if ("firefox".equalsIgnoreCase(browserType)) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
            } else {
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
            driverThreadLocal.set(driver);
        } else {
            if (sharedDriver == null) {
                WebDriver driver = null;
                if ("chrome".equalsIgnoreCase(browserType)) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                } else if ("firefox".equalsIgnoreCase(browserType)) {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new FirefoxDriver(options);
                } else {
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
                }
                sharedDriver = driver;
            }
            driverThreadLocal.set(sharedDriver);
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
    }
}
