package e2e.selenide.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class FullAppPage {

    private static final JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();

    private static final SelenideElement creditInfoContainer = $(byXpath("(//span[contains(text(), 'Запрашиваемые условия')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement clientInfoContainer = $(byXpath("(//span[contains(text(), 'Информация по клиенту')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement spouseContainer = $(byXpath("(//span[contains(text(),'Супруг(а)')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement contactPhonesContainer = $(byXpath("(//span[contains(text(), 'Телефон контактного лица')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement addressFactContainer = $(byXpath("(//span[contains(text(), 'Адрес проживания')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement addressContainer = $(byXpath("(//span[contains(text(), 'Адреса')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement incomesContainer = $(byXpath("(//span[contains(text(), 'Доходы')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement employerContainer = $(byXpath("(//span[contains(text(), 'Работодатель')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement employerAddressContainer = $(byXpath("(//span[contains(text(), 'Фактический адрес работодателя')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement employerPhonesContainer = $(byXpath("(//span[contains(text(), 'Телефоны работодателя')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement expensesContainer = $(byXpath("(//span[contains(text(), 'Ежемесячные расходы')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement estateContainer = $(byXpath("(//span[contains(text(), 'Недвижимость')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));
    private static final SelenideElement vehiclesContainer = $(byXpath("(//span[contains(text(), 'Транспортные средства')]/ancestor::div[contains(@class, 'p-accordion-tab')])[last()]"));

    public static void creditInfo(String creditAmount, String creditTerm) {
        creditInfoContainer.shouldBe(visible);
        creditInfoContainer.scrollTo();
        creditInfoContainer.$("input[field-code=SUM_CONTROL").setValue(creditAmount);
        creditInfoContainer.$("input[field-code=term]").setValue(creditTerm);
        creditInfoContainer.$("div[field-code=purpose]").click();
        $(byXpath("//li[contains(text(), 'Покупка автомобиля')]")).shouldBe(visible).click();
    }

    public static void clientInfo() {
        clientInfoContainer.scrollTo();
        clientInfoContainer.$("div[field-code=education]").click();
        clientInfoContainer.$(byText("Высшее")).shouldBe(visible).click();
        clientInfoContainer.$("div[field-code=marriageStatus]").click();
        clientInfoContainer.$(byText("В браке")).shouldBe(visible).click();
        clientInfoContainer.$("input[field-code=childrenCount]").setValue("2");
        clientInfoContainer.$("input[field-code=dependsCount]").setValue("0");
        clientInfoContainer.$("input[field-code=fullSeniorityYears]").setValue("10");
        clientInfoContainer.$("input[field-code=fullSeniorityMonths]").setValue("6");
    }

    public static void spouse() {
        spouseContainer.scrollTo();
        spouseContainer.$("input[field-code=lastName]").setValue("Тест");
        spouseContainer.$("input[field-code=firstName]").setValue("Тест");
        spouseContainer.$("input[field-code=middleName]").setValue("Тест");
        spouseContainer.$("input[field-code=DATE_CONTROL]").setValue("11.03.1990");
        spouseContainer.$("div[field-code=employmentType]").click();
        spouseContainer.$(byText("Работает")).shouldBe(visible).click();
        spouseContainer.$("input[field-code=SUM_CONTROL]").setValue("100000");
    }

    public static void contactPhones() {
        contactPhonesContainer.scrollTo();
        contactPhonesContainer.$("div[field-code=contactType]").click();
        contactPhonesContainer.$(byText("Ближайший родственник")).shouldBe(visible).click();
        contactPhonesContainer.$("input[field-code=PHONE_CONTROL]").setValue("9252345432");
        contactPhonesContainer.$("input[field-code=contactFIO]").setValue("Тест");
    }

    public static void addressMatches() {
        addressContainer.scrollTo();
        addressFactContainer.$("div[role=checkbox]").click();
    }

    public static void addressNotMatches() {
        SelenideElement addressInput = addressContainer.$("input[field-code=address_search]");

        addressContainer.scrollTo();
        addressInput.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        addressInput.setValue("РОССИЯ,354395,край Краснодарский,г Сочи,с Орел-Изумруд,ул Хирота,дом 40");
        $(byXpath("//li[contains(@class, 'p-autocomplete-list-item')]")).shouldBe(visible).click();
    }

    public static void address() {
        addressFactContainer.scrollTo();
        addressFactContainer.$("div[field-code=residenceReason]").click();
        addressFactContainer.$(byText("Социальный найм")).shouldBe(visible).click();
        addressFactContainer.scrollTo();
        addressContainer.$("div[field-code=correspondence]").click();
        addressContainer.$("li[aria-label=\"Адрес регистрации\"]").shouldBe(visible).click();
    }

    public static void addIncomes() {
        incomesContainer.scrollTo();
        incomesContainer.$("button[field-code=button_eHeQa1YU]").click();
    }

    public static void incomes(boolean special) {
        List<SelenideElement> incomes = incomesContainer.$$(byClassName("group-border"));
        for (SelenideElement income: incomes) {
            income.scrollTo();
            if (special) {
                income.$("div[field-code=activityDoc]").click();
                income.$(byText("Профессиональный оценщик")).click();
            }
            employment(income);
            income.$("button[field-code=button_9DmaYVcJ]").click();
            income.$("div[field-code=phoneType]").click();
            income.$(byText("Руководитель")).shouldBe(visible).click();
            income.$("input[field-code=PHONE_CONTROL]").setValue("9112344545");
            income.$("input[field-code=contactFIO]").setValue("Тест");
        }

    }

    public static void incomeDocs() {

    }

    public static void expenses() {

    }

    public static void estate() {

    }

    public static void vehicles() {

    }

    public static void documents() {

    }

    public static void addCoBorrower() {

    }

    public static void next() {
        $("button[field-code=FULL_APP_NEXT_BTN]").click();
    }

    private static void employment(SelenideElement income) {
        income.$("div[field-code=incomeSource]").click();
        income.$(byText("Работа по найму")).click();
        fillEmpoymentData(income);
    }

    private static void ownBusiness(SelenideElement income) {
        income.$("div[field-code=incomeSource]").click();
        income.$(byText("Собственный бизнес")).click();
        fillEmpoymentData(income);
        income.$("input[field-code=shareOwnBusiness]").setValue("100");
    }

    private static void otherIncome(SelenideElement income) {
        income.$("div[field-code=incomeSource]").click();
        income.$(byText("Прочий доход")).click();
        income.$("div[field-code=incomeType]").click();
        income.$(byText("Пенсия"));
        income.$("input[field-code=SUM_CONTROL]").setValue("1000000");
    }

    private static void fillEmpoymentData(SelenideElement income) {
        income.$("input[field-code=SUM_CONTROL]").setValue("1000000");
        income.$("input[field-code=empl_search]").setValue("7729405872");
        $(byXpath("//li[contains(@class, 'p-autocomplete-list-item')]")).shouldBe(visible).click();
        income.$("div[field-code=businessType]").click();
        income.$(byText("Банковская сфера, страхование")).shouldBe(visible).click();
        income.$("input[field-code=seniorityYear]").setValue("10");
        income.$("input[field-code=seniorityMonth]").setValue("6");
        income.$("input[field-code=position]").setValue("Тест");
        income.$("div[field-code=positionType]").click();
        income.$(byText("Топ-менеджер")).shouldBe(visible).click();
    }

}
