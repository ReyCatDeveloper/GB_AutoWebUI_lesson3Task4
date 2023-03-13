package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.ProjectOperation.*;
import static org.example.WebDriver.ProjectWebDriver.getChromeDriver;
import static org.example.WebDriver.ProjectWebDriver.webDriverStart;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //запуск
        webDriverStart("https://www.russianfood.com");
        //авторизация
        authorization();

        //перейти в пищеБлог (нажать на ник)
        WebElement myFoodBlog = getChromeDriver().findElement(By.xpath("//a[contains(@title, \"пищеБлог пользователя\")]"));
        myFoodBlog.click();
        Thread.sleep(2000);

        //выбрать первый рецепт
        WebElement myRecipeListFirstItem = getChromeDriver().findElement(By.xpath("//td[@class=\"center_block\"]//div[@class=\"annonce annonce_orange\"][1]//a[@class=\"title\"]"));
        myRecipeListFirstItem.click();
        Thread.sleep(2000);

        WebElement editRecipe = getChromeDriver().findElement(By.xpath("//b[text()=\"ИСПРАВИТЬ\"]/ancestor::a"));
        editRecipe.click();
        Thread.sleep(2000);

        //Название блюда
        String locatorInputName = "//input[@name=\"recipe_title\"]";
        WebElement inputName = getChromeDriver().findElement(By.xpath(locatorInputName));

        clearInputField(locatorInputName);
        inputName.sendKeys("УДАЛИТЬ");

        //Краткое описание блюда
        String  locatorTextareaSummary = "//textarea[@name=\"recipe_announce\"]";
        WebElement textareaSummary = getChromeDriver().findElement(By.xpath(locatorTextareaSummary));
        clearTextField(locatorTextareaSummary);
        textareaSummary.sendKeys("УДАЛИТЬ");

        //Ингридиенты
        String locatorTextareaIngrid = "//textarea[@name=\"ingrid_text\"]";
        WebElement textareaIngrid = getChromeDriver().findElement(By.xpath(locatorTextareaIngrid));
        clearTextField(locatorTextareaIngrid);
        textareaIngrid.sendKeys("УДАЛИТЬ");

        //типы блюд
        WebElement deleteMealType = getChromeDriver().findElement(By.xpath("//span[contains(text(), \"Хреновина\")]/following-sibling::a"));
        deleteMealType.click();
        Thread.sleep(2000);

        //сохранить
        WebElement buttonSave = getChromeDriver().findElement(By.xpath("//input[@name=\"save\"]"));
        buttonSave.click();

        Thread.sleep(3000);
        logOut();
    }
}