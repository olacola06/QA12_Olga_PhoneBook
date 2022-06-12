package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HelperAddContact extends HelperBase {

    public HelperAddContact(WebDriver wd) {
        super(wd);
    }

    public void login(User user) {
        clickLoginBtn();
        type(By.xpath("//*[@placeholder='Email']"), user.email());
        type(By.xpath("//*[@placeholder='Password']"), user.password());
        click(By.xpath("//button[text()=' Login']"));

    }

    public void clickAdd() {
        click(By.xpath("//*[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder ='Name']"), contact.getName());
        type(By.cssSelector("input[placeholder ='Last Name']"), contact.getLastName());
        type(By.cssSelector("input[placeholder ='Phone']"), contact.getPhone());
        type(By.cssSelector("input[placeholder ='email']"), contact.getEmail());
        type(By.cssSelector("input[placeholder ='Address']"), contact.getAddress());
        type(By.cssSelector("input[placeholder ='description']"), contact.getDescription());
    }

    public void clickSave() {
        //click(By.xpath("//b[text()='Save']"));
        click(By.cssSelector("div.add_form__2rsm2 :last-child"));

    }

    public boolean contactCreatedByName(String name) {
        List<WebElement> list = wd.findElements(By.tagName("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean contactCreatedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.tagName("h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phone)){
                return true;
            }

        }
        return false;
    }
     public void waitUntil(int millis) {

        new WebDriverWait (wd,5000).until(ExpectedConditions.
                visibilityOf(wd.findElement(By.cssSelector(".contact-item_card__2SOIM"))));
    }

    public int contactCount() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        System.out.println("Total amount of contacts--->"+list.size());
        return list.size();
    }
    public void totalContacts(){
        List<WebElement> contactsCount = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        if (contactsCount.size()<3){
            for(int i=0; i<3;i++){

            }
        }
    }

    public void clickContacts() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
    }

    public void clickRemove() {
        click(By.xpath("//*[text()='Remove']"));
        pause(1000);
    }

    public void clickContactsWithDetails() {//will be deleted the first contact in the contact list

        String phoneNum = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        if(phoneNum.length()>0){
            clickContacts();
            logger.info("Deleted contact has phone number = " + phoneNum);
            clickRemove();
        }
    }

    public boolean contactListIsEmpty() {

        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();

    }

    public void removeContactsList() {

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0)
        {clickContacts();
            clickRemove();

        }

 }
    public boolean noContacts2(){
        WebElement el = wd.findElement(By.cssSelector(".contact-page_message__2qafk h1"));
        String message = el.getText();
        return message.contains("No Contacts here!");

    }
    public boolean noContacts(){
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void removeAll() {
        while(!wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty())
        {
        clickContacts();
        clickRemove();
        }
    }

    public void removeByName(Contact contact) {
        List<WebElement> listOfContacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM h2"));
        for (WebElement el:listOfContacts) {
            if(el.getText().equals(contact.getName())){
                clickContacts();
                clickRemove();
            }
        }

    }

    public boolean contactDeleted(Contact contact) {
        List<WebElement> listOfContacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM h2"));
        for (WebElement el:listOfContacts){
            if(!el.getText().equals(contact.getName())){
                logger.info("Contact was deleted");
                return true;
            }
        }
        return false;
    }
}
