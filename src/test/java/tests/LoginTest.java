package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_elements.LoginElement;
import page_objects.MainPage;
import project_settings.TestBase;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void enterIncorrectLogin() {
        new MainPage().headerElement.openLogin();
        LoginElement loginElement = new LoginElement();
        loginElement.fillFields("123", "qwerty123");
        loginElement.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(loginElement.getButtonActivity(), "Кнопка активна");
        loginElement.fillFields("@mail.ru", "qwerty123");
        loginElement.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(loginElement.getButtonActivity(), "Кнопка активна");
        loginElement.fillFields("ttt@", "qwerty123");
        loginElement.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(loginElement.getButtonActivity(), "Кнопка активна");
        loginElement.fillFields("tttmail.ru", "qwerty123");
        loginElement.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(loginElement.getButtonActivity(), "Кнопка активна");
    }

    @Test(priority = 2)
    public void enterCorrectData() {
        LoginElement loginElement = new LoginElement();
        loginElement.fillFields("ttt@mail.ru", "qwerty123");
        loginElement.getError("");
        Assert.assertTrue(loginElement.getButtonActivity(), "Кнопка не активна");
    }
}
