package e2e.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Settings implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.startMaximized = true;
        Configuration.timeout = 30000;
    }
}
