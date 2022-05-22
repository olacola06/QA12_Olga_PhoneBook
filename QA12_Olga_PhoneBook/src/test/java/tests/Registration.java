package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.regist().elementExist()){
            app.regist().logout();
        }
    }

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String password = "OlaMar345$";

    @Test
    public void RegistrationPos() {
        String email = "UserM" + i + "@gmail.com";
        logger.info("registration with: email-> "+email+" and password-> "+password);

        app.regist().clickLoginBtn();
        app.regist().fillRegisForm(email,password);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

     @Test(enabled = true)
    public void RegistrationPosModels() {
        User user = new User().withEmail("UserO" + i + "@gmail.com").withPassword(password);
         logger.info("registration with: email-> "+user.email()+" and password-> "+user.password());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

    @Test
    public void RegistrationFailEmail() {

        User user = new User().withEmail("UserM" + i + "gmail.com").withPassword(password);
        logger.info("registration with: email-> "+user.email()+" and password-> "+user.password());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().clickAlert();
        Assert.assertTrue(app.regist().isAlertPresent());
        app.regist().failCode();

 }

    @Test
    public void RegistrationFailPassword() {
        User user = new User().withEmail("UserM" + i + "@gmail.com").withPassword("OlaMar345");
        logger.info("registration with: email-> "+user.email()+" and password-> "+user.password());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().pause(2000);
        Assert.assertTrue(app.regist().alertMessage());
        app.regist().failCode();

    }

    @Test
    public void RegistrationFailExistUser() {
        User user = new User().withEmail("UserM624@gmail.com").withPassword("OlaMar345$");
        logger.info("registration with: email-> "+user.email()+" and password-> "+user.password());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().pause(2000);
        Assert.assertEquals(app.regist().alertMessageExistUser(),"User already exist");
        app.regist().failCode();

    }

}
