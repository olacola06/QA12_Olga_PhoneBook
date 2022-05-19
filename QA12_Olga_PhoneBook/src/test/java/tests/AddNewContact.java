package tests;


import lombok.ToString;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Test(invocationCount = 4)
    public void contactAddSuccess(){
        Contact contact = Contact.builder().name("Olala"+i).lastName("Ben").phone("+123333"+i).
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
        int countStart =app.contact().contactCount();
        logger.info( "Test'Add new contact' starts with count of contacts--->" +countStart);

        Contact contact = Contact.builder().name("Ivan"+i).lastName("John").phone("+123355"+i).
                email("Ivan"+i+"@gmail.com").address("Haifa").description("Work contact").build();

        app.contact().clickAdd();
        app.contact().fillContactForm(contact);
        app.contact().clickSave();
        app.contact().pause(2000);

        int countEnd = app.contact().contactCount();
        logger.info( "Test'Add new contact' ends with count of contacts--->" +countEnd);

        Assert.assertEquals(countEnd-countStart,1);

    }
//    @Test
//    public void oneContactRemove(){
//        int countBefore = app.contact().contactCount();
//
//        app.contact().clickContacts();//selenium will choose the first contact in the list of contacts
//        app.contact().clickRemove();
//
//        int countAfter = app.contact().contactCount();
//
//        Assert.assertEquals(countBefore-countAfter,1);
//
//    }
//    @Test
//    public void removeOneContactWithDetails(){
//        int countBefore = app.contact().contactCount();
//
//        app.contact().clickContactsWithDetails();
//        app.contact().clickRemove();
//
//        int countAfter = app.contact().contactCount();
//
//        Assert.assertEquals(countBefore-countAfter,1);
//
//    }
    @Test
    public void removeContactByName(){
        app.contact().removeByName(Contact.builder().name("Ivan2894").build());

        //Assert.assertEquals("","");
        Assert.assertTrue(app.contact().contactDeleted());

    }

//    @Test
//    public void removeAllContacts(){
//        app.contact().removeContactsList();
//
//       Assert.assertTrue(app.contact().noContacts());
//
//    }
//    @Test
//    public void removeAllContact(){
//        app.contact().removeAll();
//        app.contact().pause(2000);
//
//        Assert.assertTrue(app.contact().noContacts2());
//
//    }
}
