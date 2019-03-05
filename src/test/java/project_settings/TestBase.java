package project_settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeClass
    public void testBefore() {
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browserSize = "1800x1000";
        open("https://market.leroymerlin.ru");
    }

    @AfterClass
    public void testAfter() {
        close();
    }
}
