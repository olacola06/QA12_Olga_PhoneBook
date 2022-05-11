package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HelperAddContact extends HelperBase{

    public HelperAddContact(WebDriver wd) {
        super(wd);
    }

    public void login(User user){
        clickLoginBtn();
        type(By.xpath("//*[@placeholder='Email']"), user.email());
        type(By.xpath("//*[@placeholder='Password']"), user.password());
        click(By.xpath("//button[text()=' Login']"));
    }

    public void clickAdd() {
        click(By.xpath("//*[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder ='Name']"),contact.getName());
        type(By.cssSelector("input[placeholder ='Last Name']"),contact.getLastName());
        type(By.cssSelector("input[placeholder ='Phone']"),contact.getPhone());
        type(By.cssSelector("input[placeholder ='email']"),contact.getEmail());
        type(By.cssSelector("input[placeholder ='Address']"),contact.getAddress());
        type(By.cssSelector("input[placeholder ='description']"),contact.getDescription());
    }

    public void clickSave() {
        click(By.xpath("//*[text()='Save']"));
    }

    public boolean contactAdded() {
        List<WebElement> list = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        return list.size()>0;
    }
}
