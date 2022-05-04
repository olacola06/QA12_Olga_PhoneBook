package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillRegisLoginForm(String email, String password) {
        type(By.xpath("//*[@placeholder='Email']"), email);
        type(By.xpath("//*[@placeholder='Password']"), password);
    }

    public void fillRegisLoginFormFS(User user){
        type(By.cssSelector("input[placeholder='Email']"),user.email());
        type(By.cssSelector("input[placeholder='Password']"),user.password());

    }
    public boolean elementExist(){
        return wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0;

    }

    public void clickLoginBtn(){
        click(By.xpath("//a[@href='/login']"));
    }

    public void logout(){
        click(By.xpath("//button[text()='Sign Out']"));
    }

}
