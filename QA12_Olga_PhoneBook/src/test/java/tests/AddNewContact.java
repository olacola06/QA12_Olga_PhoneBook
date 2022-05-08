package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void preCondition(){

    }

    int i = (int) (System.currentTimeMillis()/1000)%3600;

    @Test
    public void contactAddSuccess(){

    }
}
