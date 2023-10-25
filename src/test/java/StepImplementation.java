import com.thoughtworks.gauge.Step;
import org.example.Constants.Elements;
import org.example.driver.BaseMethods.BaseMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class StepImplementation extends BaseMethods {
    Elements el = new Elements();
    @Step({"<long> milisaniye bekle"})
    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"Elemente tıkla <by>"})
    public void elementeTikla(String by){
        clickElement(by);
    }
    @Step({"<by> Elementine <s> yaz"})
    public void elementeYaz(String by,String s){
        sendKeys(by, s);
    }
    @Step({"<by> Elementi var mi kontrol et"})
    public void elementKontrol(String by){
       isDisplayedBy(by);
    }

    @Step({"<url> adresine git"})
    public void urlGit(String url) {
        driver.get(url);
        logger.info(url + " adresine gidiliyor.");
    }

    @Step({"<int> saniye bekle"})
    public void saniyeBekle(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Sayfanin Yuklenmesi Beklendi");
    }


    @Step({"Şuanki URL <url> değerini içeriyor mu kontrol et"})
    public void urlKontrol(String expectedURL) {
        saniyeBekle(10);
        String actualURL = driver.getCurrentUrl();

        if (actualURL != null && actualURL.contains(expectedURL)) {
            logger.info("Şu anki URL " + expectedURL + " değerini içeriyor.");
        } else {
            Assertions.fail("Su anki URL Beklenen URL Degerini Icermiyor" + "  Beklenen Deger : " + expectedURL + ", Su Anki:  " + actualURL);
        }

    }

    @Step({"<by> Elementinin text değerini yazdır"})
    public void printElementText(String by) {
        String messageBox = findElement(by).getText();
        logger.info("Mesaji Icerisinde Bulunan Text : " + messageBox);
    }
    @Step("<ay> Ayinin <gun> gunu secilir")
    public void gunSec(String ay, int gun) {
        driver.findElement(By.xpath("(//div[text()='"+gun+"'])[2]"));
        logger.info(ay + " ayinib "+ gun +  " gunu secildi");

    }

    @Step("<by> Alaninda <ay> Ayi Gorunene Kadar <by2> Butonuna Tikla")
    public void sıradakiAy(String by, String ay, String by2) {

        while (true) {
            if (findElement(by).getText().contains(ay)) {
                break;
            }
            clickElement(by2);
        }
        logger.info(ay + " Tarihine Kadar DatePicker Ilerletildi");

    }
}

