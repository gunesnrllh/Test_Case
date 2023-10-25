package org.example.Constants;

import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Elements {
    private Map<String, By> elementMap = new HashMap<>();

    public Elements() {
        Field[] fields = this.getClass().getDeclaredFields(); // Elements sınıfındaki tüm alanları al

        for (Field field : fields) {
            if (field.getType() == By.class) {
                try {
                    elementMap.put(field.getName(), (By) field.get(this)); // By nesnesini HashMap'e ekle
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    By kalkisHavaLimani= By.id("OriginInput");
    By kalkisHavaLimaniSecim= By.id("react-autowhatever-OriginInput-section-0-item-0");
    By varisHavaLimani= By.id("DestinationInput");
    By varisHavaLimaniSecim= By.id("react-autowhatever-DestinationInput-section-0-item-0");
    By kalkisTarihiInpu= By.id("DepartureDate");
    By donusTarihiInput= By.id("ReturnDate");
    By ayBaslik= By.xpath("(//div[contains(@class,'CalendarMonth')]/strong)[2]");
    By ayAtla= By.cssSelector("div[aria-label*='next month']");
    By aktarmasizCheckBox= By.id("transitFilter");
    By yolcuSayisiSecim= By.cssSelector("[data-testid='passengerSelectButtonMulti']");
    By yetiskinArttirBtn= By.cssSelector("[data-testid='passengerCountIncrease-0']");
    By businessClassBtn= By.cssSelector("[data-testid='cabinClassButton-1']");
    By biletTuruTamamBtn= By.cssSelector("[data-testid='okButtonMulti']");
    By ucuzBiletBulBtn= By.cssSelector("[data-testid='formSubmitButton']");
    By ucusSonuc= By.id("SearchRoot");
    By ucusSayısı= By.cssSelector("[class='header-summary']");



    public By getBy(String by) {
        return elementMap.get(by);
    }

}
