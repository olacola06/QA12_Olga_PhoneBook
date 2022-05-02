package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.login().elementExist()){
            app.login().logout();
        }
    }

    @Test
    public void LoginPos(){
        String emailLogin = "UserM624@gmail.com";
        String password = "OlaMar345$";
        app.login().clickLoginBtn();
        app.login().fillRegisLoginForm(emailLogin,password);
        app.login().submitLoginBtn();

        Assert.assertTrue(app.login().elementExist());
    }
}
