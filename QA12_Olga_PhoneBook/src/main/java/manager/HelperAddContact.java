package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
