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
import org.junit.jupiter.params.provider.*;

import java.io.IOException;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.of;

@ExtendWith({Settings.class})
@Slf4j
class BaseTest {

    @BeforeEach
    void setup() throws IOException {
        open(PropertyHandler.devBaseUrl());
        //FIXME
        sleep(1000);
        if (WebDriverRunner.getWebDriver().getCurrentUrl().contains(PropertyHandler.devAuthUrl())) {
            Login.login(Users.CM_USER11);
        }
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void fillExistShortApp(final Clients client, final String appNumber, final String creditAmount, final String creditTerm) {
        Common.openApp(appNumber);
        ShortApp.fillShortApp();
        sleep(1000);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void createAndFillShortApp(final Clients client, final String appNumber, final String creditAmount, final String creditTerm)
            throws IOException {
        Common.createShortApp(client);
        ShortApp.fillShortApp();
        sleep(1000);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                of(Clients.MIKVABIYA, "П_00143440", "110000", "60"),
                of(Clients.BELYAEV, "П_00143470", "110000", "60")
        );
    }

}
