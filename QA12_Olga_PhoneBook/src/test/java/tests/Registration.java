package tests;

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

    @Test
    public void RegistrationPos() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "UserM" + i + "@gmail.com";
        String password = "OlaMar345$";
        System.out.println("Email: "+email);

        app.regist().clickLoginBtn();
        app.regist().fillRegisLoginForm(email,password);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }


}
