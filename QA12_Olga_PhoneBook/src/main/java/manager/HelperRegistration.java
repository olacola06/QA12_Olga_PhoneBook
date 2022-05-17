package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());

          if(alert==null){
            return false;
        } else{
            wd.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public String alertMessageExistUser() {
        Alert alert = new WebDriverWait(wd,5000).until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            System.out.println("Alert s not present");
        }else{
            wd.switchTo().alert();
        }
        String message = alert.getText();
        alert.accept();
        return message;

    }
}
