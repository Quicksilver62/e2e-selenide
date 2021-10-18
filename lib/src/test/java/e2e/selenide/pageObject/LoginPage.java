package e2e.selenide.pageObject;

import e2e.selenide.enums.Users;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static void login(Users user) {

        $(By.id("username")).setValue(user.getUsername());
        $(By.id("password")).setValue(user.getPassword());
        $(By.id("kc-login")).click();

    }
}
