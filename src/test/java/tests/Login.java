package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.login().elementExist()){
            app.login().logout();
        }
    }

    @Test
    public void LoginPos(){
        String emailLogin = "UserM624@gmail.com";
        String password = "OlaMar345$";
        logger.info("Login with data: -->"+emailLogin+"; "+password);
        app.login().clickLoginBtn();
        app.login().fillLoginForm(emailLogin,password);
        app.login().submitLoginBtn();

        Assert.assertTrue(app.login().elementExist());
        logger.info("Test finished --> Success");
    }

    @Test(groups = {"forSmoke","forFast"})
    public void LoginPosModels(){
        User user = new User().withEmail("UserM624@gmail.com").withPassword("OlaMar345$");
        app.login().clickLoginBtn();
        app.login().fillLoginFormModels(user);
        app.login().submitLoginBtn();

        Assert.assertTrue(app.login().elementExist());
    }

    @Test
    public void LoginNegEmail(){
        User user = new User().withEmail("UserM624@gmailcom").withPassword("OlaMar345$");
        app.login().clickLoginBtn();
        app.login().fillLoginFormModels(user);
        app.login().submitLoginBtn();
        //app.login().pause(2000);
        app.login().clickAlert();

        Assert.assertFalse(app.login().elementExist());
    }

    @Test(groups = {"forSmoke"})
    public void LoginNegPass(){
        User user = new User().withEmail("UserM624@gmailcom").withPassword("olamar345$");
        app.login().clickLoginBtn();
        app.login().fillLoginFormModels(user);
        app.login().submitLoginBtn();
        Assert.assertTrue(app.login().alertMessage());

    }
}
