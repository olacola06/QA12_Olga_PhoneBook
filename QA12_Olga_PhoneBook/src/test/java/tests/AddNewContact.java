package tests;


import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void preCondition(){
        if (!app.contact().elementExist()){
            app.contact().login(new User().withEmail("UserM624@gmail.com").withPassword("OlaMar345$"));
        }

    }

    @BeforeMethod(alwaysRun = true)
    public void contactAmount(){
        if(app.contact().contactCount()<3){
            contactAddSuccess();
        }
    }
    int i = (int) (System.currentTimeMillis()/1000)%3600;

    @Test(invocationCount = 3)
    public void contactAddSuccess(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder().name("Olala"+i).lastName("Ben").phone("+123333"+i).
                email("Rff"+i+"@gmail.com").address("Tel Aviv").description("Work contact").build();
        logger.info("Test starts with contact--->"+contact.toString());
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
    @Test
    public void oneContactRemove(){
        int countBefore = app.contact().contactCount();
        logger.info("Contact's list start with "+countBefore+"contacts");

        app.contact().clickContacts();//selenium will choose the first contact in the list of contacts
        app.contact().clickRemove();

        int countAfter = app.contact().contactCount();

        Assert.assertEquals(countBefore-countAfter,1);
        logger.info("Contact's list ends with "+countAfter+"contacts");

    }
    @Test
    public void removeOneContactWithDetails(){
        int countBefore = app.contact().contactCount();
        logger.info("Contact's list starts with "+countBefore+"contacts");

        app.contact().clickContactsWithDetails();

        int countAfter = app.contact().contactCount();

        Assert.assertEquals(countBefore-countAfter,1);
        logger.info("Contact's list ends with "+countAfter+"contacts");

    }
    @Test
    public void removeContactByName(){

        Contact contact = Contact.builder().name("Ivan"+i).build();
        logger.info("Contact to be deleted has name--->"+contact.getName());
        app.contact().removeByName(contact);

        Assert.assertTrue(app.contact().contactDeleted(contact));

    }

    @Test(enabled = true)
    public void removeAllContacts(){
        app.contact().removeContactsList();

       Assert.assertTrue(app.contact().noContacts());

    }
//    @Test
//    public void removeAllContact(){
//        app.contact().removeAll();
//        app.contact().pause(2000);
//
//        Assert.assertTrue(app.contact().noContacts2());
//
//    }
}
