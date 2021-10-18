package e2e.selenide.services;

import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.pageObject.Common;
import e2e.selenide.pageObject.ShortAppPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class ShortApp {

    private static final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 60);

    public static void fillShortApp() {

        Common.spinner.shouldNotBe(visible);
        $(byText("Создать заявку (короткая анкета)")).shouldBe(visible);
        ShortAppPage.fillAddress();
        ShortAppPage.attachFile();
        Common.spinner.shouldNotBe(visible);
        sleep(500);
        ShortAppPage.openConsentModal();
        Common.spinner.shouldNotBe(visible);
        ShortAppPage.fillConsentModal();
        switchTo().window(0);
        sleep(500);
        ShortAppPage.attachConsent();
        Common.spinner.shouldNotBe(visible);
        ShortAppPage.next();
        wait.until(invisibilityOf(Common.spinner));

    }

    public static void shortAppToFull() {
        Common.spinner.shouldNotBe(visible);
        $(byText("Создать заявку (короткая анкета)")).shouldBe(visible);
        ShortAppPage.shortAppToFull();
        wait.until(invisibilityOf(Common.spinner));
    }

}
