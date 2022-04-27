package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperRegistration extends HelperBase {

    public HelperRegistration(WebDriver wd) {
        super(wd);
    }

    public void submitRegisBtn() {
        click(By.xpath("//*[text()=' Registration']"));

    }

}
