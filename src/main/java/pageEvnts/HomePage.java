package main.java.pageEvnts;

import main.java.pageObjects.HomePageElm;
import main.java.utils.ElementFetch;

public class HomePage {
    ElementFetch elm = new ElementFetch();
    public  void clickOnSignInBtn(){
        elm.getWebElement("XPATH", HomePageElm.signInBtn).click();
    }
}
