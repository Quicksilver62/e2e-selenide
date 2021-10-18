package e2e.selenide.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

    private static String getProperty(String name) throws IOException {

        Properties properties = new java.util.Properties();

        FileInputStream fileInputStream = new FileInputStream("./src/main/resources/application.properties");

        properties.load(fileInputStream);

        return properties.getProperty(name);
    }

    public static String devBaseUrl() throws IOException { return getProperty("DEV_BASE_URL"); }
    public static String devBackUrl() throws IOException { return getProperty("DEV_BACK_URL"); }
    public static String testBaseUrl() throws IOException { return getProperty("TEST_BASE_URL"); }
    public static String testBackUrl() throws IOException { return getProperty("TEST_BACK_URL"); }
    public static String devAuthUrl() throws IOException { return getProperty("DEV_AUTH_URL"); }
    public static String mockUrl() throws IOException { return getProperty("MOCK_URL"); }
    public static String createAppLink() throws IOException { return getProperty("CREATE_APP_LINK"); }
    public static String filePath() throws IOException { return getProperty("FILE_PATH"); }

}
