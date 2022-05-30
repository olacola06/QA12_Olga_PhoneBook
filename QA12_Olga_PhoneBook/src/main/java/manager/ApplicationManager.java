package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    EventFiringWebDriver wd;
    String browser;
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    HelperRegistration regist;
    HelperLogin login;
    HelperAddContact contact;
    public void setUp(){
        //wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd =  new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests starts in 'Chrome' browser");
        } else  if(browser.equals(BrowserType.EDGE)){
            wd =  new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'Edge' browser");
        }else  if (browser.equals(BrowserType.FIREFOX)){
            wd =  new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'Firefox' browser");
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        wd.register(new MyListener());

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
