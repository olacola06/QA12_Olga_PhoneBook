package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperRegistration extends HelperBase {

    public HelperRegistration(WebDriver wd) {
        super(wd);
    }

    public void submitRegisBtn() {
        click(By.xpath("//*[text()=' Registration']"));

    }

    public void fillRegisForm(String email, String password) {
        type(By.xpath("//*[@placeholder='Email']"), email);
        type(By.xpath("//*[@placeholder='Password']"), password);
    }

    public void fillRegisFormModels(User user) {
        type(By.xpath("//*[@placeholder='Email']"), user.email());
        type(By.xpath("//*[@placeholder='Password']"), user.password());
    }

}
