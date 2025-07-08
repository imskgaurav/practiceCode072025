package main.java.pageEvnts;

import main.java.pageObjects.LoginPageElm;
import main.java.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import  java.util.List;

public class LoginPage {

    ElementFetch elm = new ElementFetch();
    public void verifyLoginPageOpen(){

     List<WebElement> login=   elm.getListWebElements("XPATH", LoginPageElm.loginTxt);
        Assert.assertTrue(login.size()>0, "");
    }
}
