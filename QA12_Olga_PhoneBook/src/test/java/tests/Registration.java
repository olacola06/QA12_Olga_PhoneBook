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

<<<<<<< Updated upstream
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String password = "OlaMar345$";

    @Test(enabled = true)
    public void RegistrationPos() {
        String email = "UserM" + i + "@gmail.com";
=======
    @Test
    public void RegistrationPos() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis() / 1000);
        String email = "UserM" + i + "@gmail.com";
        String password = "OlaMar345$";
>>>>>>> Stashed changes
        System.out.println("Email: "+email);

        app.regist().clickLoginBtn();
        app.regist().fillRegisForm(email,password);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

<<<<<<< Updated upstream
    @Test(enabled = true)
    public void RegistrationPosModels() {
        User user = new User().withEmail("UserO" + i + "@gmail.com").withPassword(password);
        System.out.println("Email: "+user.email());
=======
    @Test
    public void RegistrationPosModelsFS() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "UserO" + i + "@gmail.com";
        String password = "OlaMar345$";
        System.out.println("Email: "+email);

        User user = new User().withEmail(email).withPassword(password);
>>>>>>> Stashed changes

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();

        Assert.assertTrue(app.regist().elementExist());
    }

    @Test
    public void RegistrationFailEmail() {

        User user = new User().withEmail("UserM" + i + "gmail.com").withPassword(password);
        System.out.println("Email: "+user.email());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().pause(2000);
        app.regist().clickAlert();
        app.regist().failCode();

        Assert.assertFalse(app.regist().elementExist());

   }

    @Test
    public void RegistrationFailPassword() {
        User user = new User().withEmail("UserM" + i + "@gmail.com").withPassword("OlaMar345");
        System.out.println("Email: "+user.email());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().pause(2000);
        app.regist().clickAlertObject();
        app.regist().failCode();

        Assert.assertFalse(app.regist().elementExist());

    }

    @Test
    public void RegistrationFailExistUser() {
        User user = new User().withEmail("UserM624@gmail.com").withPassword("OlaMar345$");
        System.out.println("Email: "+user.email());

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();
        //app.regist().pause(2000);
        app.regist().clickAlertObject();
        app.regist().failCode();

        Assert.assertFalse(app.regist().elementExist());

    }

}
