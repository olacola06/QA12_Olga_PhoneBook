package manager;

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