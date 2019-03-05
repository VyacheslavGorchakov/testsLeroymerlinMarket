package page_elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {

    private SelenideElement _entryButton = $(By.xpath("//div[@class='header-panel']//div[@class='header-panel__usr-new']/button[contains(., 'Вход')]")),
            _registerButton = $(By.xpath("//div[@class='header-panel']//div[@class='header-panel__usr-new']/a[contains(., 'Регистрация')]"));

    public HeaderElement(){
        _entryButton.shouldBe(Condition.visible);
    }

    public void openRegister() {
        _registerButton.click();
    }

    public void openLogin() {
        _entryButton.click();
    }

}