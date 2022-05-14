package tests;


import models.Contact;
import models.User;
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
        app.contact().pause(2000);

        Assert.assertTrue(app.contact().contactCreatedByName(contact.getName()));
        Assert.assertTrue(app.contact().contactCreatedByPhone(contact.getPhone()));
        System.out.println("New contact created with Name - "+contact.getName()+" and with phone -"+contact.getPhone());
    }
}
