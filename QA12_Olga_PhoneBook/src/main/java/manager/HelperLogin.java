package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperLogin extends HelperBase {
    public HelperLogin(WebDriver wd) {
        super(wd);
    }

    public void submitLoginBtn() {
        click(By.xpath("//button[text()=' Login']"));
    }
}

