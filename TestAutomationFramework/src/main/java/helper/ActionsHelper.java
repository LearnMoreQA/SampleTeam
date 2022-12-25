package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsHelper {
    private WebDriver webDriver;
    private static ActionsHelper actionsHelper;

    public ActionsHelper(WebDriver driver){
        webDriver = driver;
    }

    public static ActionsHelper getInstance(WebDriver driver){
        actionsHelper = new ActionsHelper(driver);
        return actionsHelper;
    }

    public void clickElement(By locator){
        webDriver.findElement(locator).click();
    }

    public String getTextValue(By locator){
      String textValue = webDriver.findElement(locator).getText();
      return textValue;
    }
}
