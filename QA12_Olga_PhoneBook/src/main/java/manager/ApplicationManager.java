package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperRegistration regist;
    HelperLogin login;
    HelperAddContact contact;
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        regist = new HelperRegistration(wd);
        login = new HelperLogin(wd);
        contact = new HelperAddContact(wd);

    }

    public void stop(){
        wd.quit();
    }

    public HelperRegistration regist() {
        return regist;
    }
    public HelperLogin login(){
        return login;
    }
    public HelperAddContact contact(){
        return contact;
    }

}
