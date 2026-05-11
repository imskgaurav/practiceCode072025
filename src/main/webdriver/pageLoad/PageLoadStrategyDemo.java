package main.webdriver.pageLoad;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.devtools.DevTools;

public class PageLoadStrategyDemo {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        //Confirm the CDP version using selenium code//
        DevTools devTools= driver.getDevTools();
        System.out.println("DevTools: "+devTools.getDomains().log());
        driver.quit();
    }
}
