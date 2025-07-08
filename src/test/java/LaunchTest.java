package test.java;

import main.java.pageEvnts.HomePage;
import main.java.pageEvnts.LoginPage;
import org.testng.annotations.Test;


public class LaunchTest extends BaseTest {

    @Test
      public void launchAmazon(){
        HomePage hp = new HomePage();
        LoginPage lp = new LoginPage();
        hp.clickOnSignInBtn();
        lp.verifyLoginPageOpen();
    }


}
