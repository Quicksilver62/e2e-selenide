package e2e.selenide.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.enums.Clients;
import e2e.selenide.properties.PropertyHandler;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Common {

    public static SelenideElement spinner = $(byClassName("p-progress-spinner-svg"));

    public static void openApp(final String appNumber) {
        $(By.xpath("//a[contains(text(),\"" + appNumber + "\")]/ancestor::td/preceding-sibling::td[position()=1]")).click();
    }

    public static void createShortApp(final Clients client) throws IOException {
        open(PropertyHandler.devBaseUrl() + PropertyHandler.createAppLink() +
                "{\"cftClientId\":\"" + client.getCftId() + "\"}");
    }

    public static void tastkInWork() {
        if ( WebDriverRunner.getWebDriver().findElements(By.cssSelector("button[field-code=button_HIElRNSi]")).size() > 0 ) {
            $("button[field-code=button_HIElRNSi]").click();
        }
     }

}
