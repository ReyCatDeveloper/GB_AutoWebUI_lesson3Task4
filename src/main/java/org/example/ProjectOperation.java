package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.example.Project.*;
import static org.example.WebDriver.ProjectWebDriver.getChromeDriver;

public class ProjectOperation {

    public static void authorization() throws InterruptedException {
        enterButton.click();
        Thread.sleep(2000);
        loginInput.sendKeys("Seleniumtester4");
        passwordInput.sendKeys("Selenium12345!");
        rememberUserCheckbox.click();
        loginButton.click();
    }

    public static void logOut(){
        WebElement logoutButton = getChromeDriver().findElement(By.xpath("//div[@class=\"wrapper\"]/table//input[@name=\"logout\"]"));
        logoutButton.click();
    }

    public static void clearTextField(String locator){
        WebElement clearingField = getChromeDriver().findElement(By.xpath(locator));

        String textInField = clearingField.getText();
        int amountSymbol = textInField.length();
        for(int i = 0; i < amountSymbol; i++){
            clearingField.sendKeys(Keys.BACK_SPACE);
        }

    }

    public static void clearInputField(String locator){
        WebElement clearingField = getChromeDriver().findElement(By.xpath(locator));

        String textInField = clearingField.getAttribute("value");
        int amountSymbol = textInField.length();
        for(int i = 0; i < amountSymbol; i++){
            clearingField.sendKeys(Keys.BACK_SPACE);
        }

    }

}
