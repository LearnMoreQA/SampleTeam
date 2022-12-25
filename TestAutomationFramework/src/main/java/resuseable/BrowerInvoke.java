package resuseable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowerInvoke {
    protected static WebDriver driver;

    protected static WebDriver openBrowser() throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources/utility.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String browser = prop.getProperty("Browser");
        System.out.println(browser);
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
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
