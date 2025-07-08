package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.java.BaseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierVal){

       switch (identifierType) {
        case "ID":
        return BaseTest.driver.findElement(By.id(identifierVal));
        case "NAME":
        return BaseTest.driver.findElement(By.name(identifierVal));
        case "XPATH":
        return BaseTest.driver.findElement(By.xpath(identifierVal));
        default:
            return null;
       }


    }
public List<WebElement> getListWebElements(String identifierType, String idtVal){
switch (identifierType){

    case "ID":
    return BaseTest.driver.findElements(By.id(idtVal));
    case "css":
    return BaseTest.driver.findElements(By.cssSelector(idtVal));
    case "XPATH":
     return BaseTest.driver.findElements(By.xpath(idtVal));
    case "TAGNAME" :
     return BaseTest.driver.findElements(By.tagName(idtVal));
    default:
        return null;
}

}

}
