package tests;


import lombok.ToString;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (!app.contact().elementExist()){
            app.contact().login(new User().withEmail("UserM624@gmail.com").withPassword("OlaMar345$"));
        }

    }

    int i = (int) (System.currentTimeMillis()/1000)%3600;

    @Test
    public void contactAddSuccess(){
        Contact contact = Contact.builder().name("Oll"+i).lastName("Ben").phone("+123333"+i).
                email("Rff"+i+"@gmail.com").address("Tel Aviv").description("Work contact").build();
        app.contact().clickAdd();
        app.contact().fillContactForm(contact);
        app.contact().clickSave();
        //app.contact().pause(2000);
        app.contact().waitUntil(5000);

        Assert.assertTrue(app.contact().contactCreatedByName(contact.getName()));
        Assert.assertTrue(app.contact().contactCreatedByPhone(contact.getPhone()));
        System.out.println("New contact created with Name - "+contact.getName()+" and with phone -"+contact.getPhone());
    }

    @Test
    public void oneContactAdd(){
        Contact contact = Contact.builder().name("Ivan"+i).lastName("John").phone("+123355"+i).
                email("Ivan"+i+"@gmail.com").address("Haifa").description("Work contact").build();

        int countStart =app.contact().contactCount();

        app.contact().clickAdd();
        app.contact().fillContactForm(contact);
        app.contact().clickSave();
        app.contact().pause(2000);

        int countEnd = app.contact().contactCount();

        Assert.assertEquals(countEnd-countStart,1);

    }
    @Test
    public void oneContactRemove(){
        int countBefore = app.contact().contactCount();
        app.contact().clickContacts();//selenium will choose the first contact in the list of contacts
        app.contact().clickRemove();
        app.contact().pause(2000);
        int countAfter = app.contact().contactCount();

        Assert.assertEquals(countBefore-countAfter,1);

    }
    @Test
    public void removeOneContactCount(){

    }

    @Test
    public void removeAllContacts(){
        
    }
}
