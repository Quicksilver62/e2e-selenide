package e2e.selenide.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.properties.PropertyHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ShortAppPage {

    private static final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 30);
    private static final JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();

    private static File file;

    static {
        try {
            file = new File(PropertyHandler.filePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillAddress() {
        $("input[field-code=address_search]").shouldBe(visible).sendKeys(Keys.END, Keys.BACK_SPACE, "1");
        $(byXpath("//li[contains(@class, 'p-autocomplete-list-item')]")).shouldBe(visible).click();
    }

    public static void attachFile() {
        for (SelenideElement selenideElement : $$("input[field-code=attach]")) {
            selenideElement.uploadFile(file);
        }
    }

    public static void openConsentModal() {
        SelenideElement modalBtn = $("button[field-code=generate_btn]");
        modalBtn.scrollTo();
        wait.until(elementToBeClickable(modalBtn));
        jse.executeScript("arguments[0].click();", modalBtn);
    }

    public static void fillConsentModal() {
        $("button[field-code=button_kPO5utQE_copy]").shouldBe(visible).click();
        $("button[field-code=button_y2rMCaP9_copy]").shouldBe(visible).click();
    }

    public static void attachConsent() {
        $(byText("Согласия клиента")).shouldBe(visible);
        $(byXpath("(//input[contains(@field-code, 'attach')])[last()]")).scrollTo().uploadFile(file);
    }

    public static void next() {
        $("button[field-code=SHORT_APP_NEXT_BTN]").shouldBe(enabled).click();
    }

    public static void shortAppToFull() {
        $("button[field-code=SHORT_APP_TO_FULL_MODAL_BTN]").shouldBe(enabled).click();
        $("button[field-code=SHORT_APP_TO_FULL_BTN]").shouldBe(enabled).click();
    }
}
