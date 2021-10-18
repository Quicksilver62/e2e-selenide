package e2e.selenide;

import com.codeborne.selenide.WebDriverRunner;
import e2e.selenide.enums.Users;
import e2e.selenide.pageObject.Common;
import e2e.selenide.properties.PropertyHandler;
import e2e.selenide.services.FullApp;
import e2e.selenide.services.Login;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.params.provider.Arguments.of;

@ExtendWith({Settings.class})
@Slf4j
public class FullAppTest {

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
    void fillExistFullApp(final String appNumber, final String creditAmount, final String creditTerm) {
        Common.openApp(appNumber);
        FullApp.fillFullApp(creditAmount, creditTerm);
        sleep(5000);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                of("П_00143560", "110000", "60")
        );
    }

}
