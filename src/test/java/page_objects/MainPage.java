package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page_elements.HeaderElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public page_elements.HeaderElement headerElement = new HeaderElement();
    private SelenideElement _banner = $(By.xpath("//div[@class='index-page__new-main-section']"));

    public MainPage() {
        _banner.shouldBe(Condition.visible);
    }
}
