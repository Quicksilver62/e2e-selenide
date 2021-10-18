package e2e.selenide;

import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.enums.Clients;
import e2e.selenide.enums.Users;
import e2e.selenide.pageObject.Common;
import e2e.selenide.properties.PropertyHandler;
import e2e.selenide.services.Login;
import e2e.selenide.services.ShortApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@ExtendWith({Settings.class})
@Slf4j
public class ShortAppTest {

    @BeforeEach
    void setup() throws IOException {
        open(PropertyHandler.devBaseUrl());
        //FIXME
        sleep(1000);
        if (WebDriverRunner.getWebDriver().getCurrentUrl().contains(PropertyHandler.devAuthUrl())) {
            Login.login(Users.CM_USER2);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"П_00143560"})
    void fillExistShortApp(final String appNumber) {
        Common.openApp(appNumber);
        ShortApp.fillShortApp();
        sleep(5000);
    }

    @ParameterizedTest
    @EnumSource(value = Clients.class, names = {"KHAMATSHIN"})
    void createAndFillShortApp(final Clients client) throws IOException {
        Common.createShortApp(client);
        ShortApp.fillShortApp();
        sleep(1000);
    }

    @ParameterizedTest
    @EnumSource(value = Clients.class, names = {"BELYAEV"})
    void createAndToFullApp(final Clients client) throws IOException {
        Common.createShortApp(client);
        ShortApp.shortAppToFull();
        sleep(1000);
    }

}
