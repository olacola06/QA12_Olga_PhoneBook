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

//    public boolean contactAdded() {
//        List<WebElement> list = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//        return list.size() > 0;
//
//    }

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
        System.out.println(list.size());
        return list.size();
    }

    public void clickContacts() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
    }

    public void clickRemove() {
        click(By.xpath("//*[text()='Remove']"));
    }

    public void clickContactsWithDetails() {

        String phoneNum = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        if(!contactListIsEmpty()){
            clickContacts();
            System.out.println("Deleted contact has phone number = " + phoneNum);
        }
    }

    private boolean contactListIsEmpty() {

        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();

    }
}

