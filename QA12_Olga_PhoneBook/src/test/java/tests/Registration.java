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

//    @Test
//    public void RegistrationPos() {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
////        System.out.println(System.currentTimeMillis());
////        System.out.println(System.currentTimeMillis() / 1000);
//        String email = "UserM" + i + "@gmail.com";
//        String password = "OlaMar345$";
//        System.out.println("Email: "+email);
//
//        app.regist().clickLoginBtn();
//        app.regist().fillRegisForm(email,password);
//        app.regist().submitRegisBtn();
//
//        Assert.assertTrue(app.regist().elementExist());
//    }
//
//    @Test
//    public void RegistrationPosModelsFS() {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        String email = "UserO" + i + "@gmail.com";
//        String password = "OlaMar345$";
//        System.out.println("Email: "+email);
//
//        User user = new User().withEmail(email).withPassword(password);
//
//        app.regist().clickLoginBtn();
//        app.regist().fillRegisFormModels(user);
//        app.regist().submitRegisBtn();
//
//        Assert.assertTrue(app.regist().elementExist());
//    }

    @Test
    public void RegistrationFailEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "UserO" + i + "gmail.com";
        String password = "OlaMar345$";
        System.out.println("Email: "+email);

        User user = new User().withEmail(email).withPassword(password);

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();

        Assert.assertEquals(app.regist().checkMessage(),"Wrong email or password format");

    }

    @Test
    public void RegistrationFailPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "UserO" + i + "@gmail.com";
        String password = "OlaMar345";
        System.out.println("Email: "+email);

        User user = new User().withEmail(email).withPassword(password);

        app.regist().clickLoginBtn();
        app.regist().fillRegisFormModels(user);
        app.regist().submitRegisBtn();

        Assert.assertFalse(app.regist().elementExist());

    }


}
