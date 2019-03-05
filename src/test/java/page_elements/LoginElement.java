package page_elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginElement {
    private SelenideElement _title = $(By.xpath("//div[@class='fancybox-skin']//p[contains(.,'Войти в личный кабинет на Маркет')]")),
            _loginInput = $(By.xpath("//div[@class='fancybox-skin']//div[label[contains(.,'Логин')]]/input")),
            _loginText = $(By.xpath("//div[@class='fancybox-skin']//label[contains(., 'Логин')]")),
            _passInput = $(By.xpath("//div[@class='fancybox-skin']//div[label[contains(.,'Пароль')]]//input")),
            _passText = $(By.xpath("//div[@class='fancybox-skin']//label[contains(.,'Пароль')]")),
            _enterButton = $(By.xpath("//div[@class='fancybox-skin']//button[contains(., 'Войти')]")),
            _registerButton = $(By.xpath("//div[@class='fancybox-skin']//a[contains(., 'Регистрация')]")),
            _closeButton = $(By.xpath("//div[@class='fancybox-skin']//a[@title='Закрыть']"));

    public LoginElement() {
        _title.shouldBe(Condition.visible);
    }

    public SelenideElement getError(String textError) {
        _loginText.click();
        _passText.click();
        return $(By.xpath("//p[@class='error-form' and contains(.,'" + textError + "')]"));
    }

    public void fillFields(String login, String pass) {
        _setValue(_loginInput, login);
        _setValue(_passInput, pass);
    }

    public void register() {
        _registerButton.click();
    }

    public void enter() {
        _enterButton.click();
    }

    public void close() {
        _closeButton.click();
    }

    public boolean getButtonActivity() {
        return _enterButton.getAttribute("disabled") == null;
    }

    private void _setValue(SelenideElement input, String value) {
        if (value != null) {
            input.setValue(value);
        }
    }
}
