package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperLogin extends HelperBase {
    public HelperLogin(WebDriver wd) {
        super(wd);
    }

    public void submitLoginBtn() {
        click(By.xpath("//button[text()=' Login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//*[@placeholder='Email']"), email);
        type(By.xpath("//*[@placeholder='Password']"), password);
    }

    public void fillLoginFormModels(User user) {
        type(By.xpath("//*[@placeholder='Email']"), user.email());
        type(By.xpath("//*[@placeholder='Password']"), user.password());
    }
}

