package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.regist().elementExist()){
            app.regist().logout();
        }
    }

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String email = "UserM" + i + "@gmail.com";
    String password = "OlaMar345$";

    @Test
    public void RegistrationPos1() {
        System.out.println("Email: "+email);

        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginForm(email,password);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

    @Test
    public void RegistrationPos2() {
        System.out.println("Email: "+email);

        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginForm("userm" + i + "@gmail.com",password);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

    @Test
    public void RegistrationNegExistUser() {
        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginForm("UserM624@gmail.com","OlaMar345$");
        app.regist().submitRegisBtn();

        Assert.assertFalse(app.regist().elementExist());
    }
    @Test
    public void registrationNegativeEmail(){
        User user = new User().withEmail("UserM" + i + "gmail.com").withPassword(password);

        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginFormFS(user);
        app.regist().submitRegisBtn();

        Assert.assertFalse(app.regist().elementExist());

    }

    @Test
    public void registrationNegativePass(){
        User user = new User().withEmail("UserM" + i + "@gmail.com").withPassword("OlaMar345");

        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginFormFS(user);
        app.regist().submitRegisBtn();

        Assert.assertFalse(app.regist().elementExist());

    }

}
