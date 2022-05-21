package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    //static protected ApplicationManager app = new ApplicationManager();
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("start test:  " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of Test:  "+m.getName());
    }

    @BeforeSuite
    public void init(){
        app.setUp();
    }

//    @AfterSuite
//    public void tearDown(){
//        app.stop();
//    }
}
