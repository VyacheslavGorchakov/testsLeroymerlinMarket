package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page_elements.HeaderElement;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    public page_elements.HeaderElement headerElement = new HeaderElement();
    private SelenideElement _title = $(By.xpath("//h1[contains(.,'Регистрация на маркет')]")),
            _nameInput = $(By.xpath("//div[@class='order-auth-form__email-reg']/div[label[contains(.,'Имя')]]/input")),
            _nameText = $(By.xpath("//div[@class='order-auth-form__email-reg']//label[contains(.,'Имя')]")),
            _emailInput = $(By.xpath("//div[@class='order-auth-form__email-reg']/div[label[contains(.,'E-mail')]]/input")),
            _emailText = $(By.xpath("//div[@class='order-auth-form__email-reg']//label[contains(.,'E-mail')]")),
            _passInput = $(By.xpath("//div[@class='order-auth-form__email-reg']/div[label[contains(.,'Пароль')]]//input")),
            _passText = $(By.xpath("//div[@class='order-auth-form__email-reg']//label[contains(.,'Пароль')]")),
            _informationCheckBox = $(By.xpath("//div[@class='order-auth-form__agreement']//label[contains(.,'Я согласен на обработку персональных данных и ознакомился с правилами.')]")),
            _leroyNewsCheckBox = $(By.xpath("//div[@class='order-auth-form__agreement']//label[contains(.,'Я согласен получать новости Leroy Merlin.')]")),
            _registerButton = $(By.xpath("//div[@class='order-auth-form__email-reg']//button[contains(.,'Зарегистрироваться')]"));

    public RegisterPage() {
        _title.shouldBe(Condition.visible);
    }

    public void fillFields(String name, String email, String pass, boolean personalInformation, boolean leroyNews) {
        _setValue(_nameInput,name);
        _setValue(_emailInput,email);
        _setValue(_passInput,pass);
        _setValue(_informationCheckBox, personalInformation);
        _setValue(_leroyNewsCheckBox, leroyNews);
    }

    public SelenideElement getError(String textError) {
        _title.scrollIntoView("{block: \"start\"}");
        _nameText.click();
        _emailText.click();
        _passText.click();
        return $(By.xpath("//p[contains(.,'" + textError + "')]"));
    }

    public void register() {
        _registerButton.click();
    }

    public boolean getButtonActivity() {
        return _registerButton.getAttribute("disabled") == null;
    }

    private void _setValue(SelenideElement checkBox, boolean value) {
        boolean valueCheckBox = Arrays.asList(checkBox.getAttribute("class").split(" ")).contains("is-active");
        if (valueCheckBox != value) {
            checkBox.scrollIntoView("{block: \"start\"}");
            checkBox.click(5, 5);
        }
    }

    private void _setValue(SelenideElement input, String value) {
        _title.scrollIntoView("{block: \"start\"}");
        if (value != null) {
            input.setValue(value);
        }
    }
}