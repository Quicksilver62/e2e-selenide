package e2e.selenide.services;

import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.enums.Users;
import e2e.selenide.pageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Login {

    public static void login(Users user) {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 10);

//        wait.until(ExpectedConditions.urlContains("https://keycloak-kube.dev.zenit.ru/"));
        LoginPage.login(user);
        wait.until(ExpectedConditions.urlContains("appFormTasksMyForm"));
        $(By.className("name")).shouldBe(visible).shouldHave(text(user.getDescription()));
    }
}
