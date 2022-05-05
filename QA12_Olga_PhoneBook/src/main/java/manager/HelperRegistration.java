package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public void clickOkWhenFail(){
        WebElement el = wd.findElement(By.cssSelector("div.login_login__3EHKB"));
        int x = el.getRect().getWidth()/8*3;
        int y = el.getRect().getHeight()/2;

        Actions action = new Actions(wd);
        action.moveToElement(el).moveByOffset(x,y).click().release().perform();

    }

}
