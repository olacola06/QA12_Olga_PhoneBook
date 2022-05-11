package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickAlert() {
        Alert alert = new WebDriverWait(wd, 5000).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        alert.accept();
    }

    public void clickAlertObject() {
        Alert alert = new WebDriverWait(wd, 5000).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();

    }

    public void failCode() {
        WebElement el = wd.findElement(By.cssSelector("div.login_login__3EHKB :first-child"));
        String message = el.getText();
        System.out.println("Code of failure: - "+message);
    }

}
