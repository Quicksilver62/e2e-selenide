package e2e.selenide.services;

import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.pageObject.Common;
import e2e.selenide.pageObject.FullAppPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class FullApp {

    private static final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 60);

    public static void fillFullApp(final String creditAmount, final String creditTerm) {

        Common.spinner.shouldNotBe(visible);
        $(byText("Заполнить полную анкету по заявке")).shouldBe(visible);
        Common.tastkInWork();
        Common.spinner.shouldNotBe(visible);
        FullAppPage.creditInfo(creditAmount, creditTerm);
        FullAppPage.clientInfo();
        FullAppPage.spouse();
        FullAppPage.contactPhones();
        FullAppPage.addressMatches();
        FullAppPage.address();
        for (int i = 0; i < 1; i++) {
            FullAppPage.addIncomes();
            Common.spinner.shouldNotBe(visible);
        }
        FullAppPage.incomes(false);
        FullAppPage.next();
        wait.until(invisibilityOf(Common.spinner));
    }

}
