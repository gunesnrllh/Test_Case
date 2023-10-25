package org.example.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    protected static WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    ChromeOptions chromeOptions;

    @BeforeScenario
    public void setUpDriver() {
     logger.info("BeforeScenario calisti");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--kiosk");
        try {
         driver = new ChromeDriver(chromeOptions);

     }
    catch (Exception e)
    {
        logger.error("Driver ayaga kaldirilirken hata olustu");
    }
    }
    @AfterScenario
    public void tearDown() {
       if (driver!=null){
           driver.quit();
           logger.info("Driver kapatildi");
       }
    }


}
