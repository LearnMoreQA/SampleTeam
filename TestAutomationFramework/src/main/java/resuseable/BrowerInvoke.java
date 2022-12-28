package resuseable;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BrowerInvoke {
    protected static RemoteWebDriver driver;

    protected static RemoteWebDriver openBrowser() throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources/utility.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String browser = prop.getProperty("Browser");
        if(browser.equalsIgnoreCase("Chrome")) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browser);
            URL url = new URL(prop.getProperty("Grid_URL"));
            driver = new RemoteWebDriver(url,dc);
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", path + "/src/main/resources/driver/msedgedriver.exe");
            driver = new EdgeDriver();
        }else{
            System.out.println("Please Provide Correct Browser..!");
        }
        driver.get(prop.getProperty("Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }


}
