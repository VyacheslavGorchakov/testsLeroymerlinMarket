package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.MainPage;
import page_objects.RegisterPage;
import project_settings.TestBase;

public class RegisterTest extends TestBase {

    @Test(priority = 1)
    public void enterIncorrectName() {
        new MainPage().headerElement.openRegister();
        RegisterPage registerPage = new RegisterPage();
        registerPage.fillFields("Аве1", "ttt@mail.ru", "qwerty123", true, true);
        registerPage.getError("Cимволы А-Я, а-я, \" \", \"-\"").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Ave", "ttt@mail.ru", "qwerty123", true, true);
        registerPage.getError("Cимволы А-Я, а-я, \" \", \"-\"").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве.", "ttt@mail.ru", "qwerty123", true, true);
        registerPage.getError("Cимволы А-Я, а-я, \" \", \"-\"").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
    }

    @Test(priority = 2)
    public void enterIncorrectMail() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.fillFields("Аве", "123", "qwerty123", true, true);
        registerPage.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "@mail.ru", "qwerty123", true, true);
        registerPage.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "ttt@", "qwerty123", true, true);
        registerPage.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "tttmail.ru", "qwerty123", true, true);
        registerPage.getError("Некорректный e-mail").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
    }

    @Test(priority = 3)
    public void enterIncorrectPass() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.fillFields("Аве", "ttt@mail.ru", "123", true, true);
        registerPage.getError("Пароль недостаточно надежный. Попробуйте придумать пароль в соответствии с требованиями").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "ttt@mail.ru", "asd", true, true);
        registerPage.getError("Пароль недостаточно надежный. Попробуйте придумать пароль в соответствии с требованиями").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "ttt@mail.ru", "------------", true, true);
        registerPage.getError("Пароль недостаточно надежный. Попробуйте придумать пароль в соответствии с требованиями").should(Condition.exist);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
    }

    @Test(priority = 4)
    public void enterIncorrectPersonalData() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.fillFields("Аве", "ttt@mail.ru", "qwerty123", false, false);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "ttt@mail.ru", "qwerty123", false, true);
        Assert.assertFalse(registerPage.getButtonActivity(), "Кнопка активна");
        registerPage.fillFields("Аве", "ttt@mail.ru", "qwerty123", true, true);
        Assert.assertTrue(registerPage.getButtonActivity(), "Кнопка не активна");
    }
}
