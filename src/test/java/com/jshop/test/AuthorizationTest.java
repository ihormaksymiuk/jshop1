package com.jshop.test;

import com.jshop.test.base.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//этот класс для тестов мы его наследует от класса TestBase, в котором были сделаны настройки драйвера, что будет перед тестом и после
public class AuthorizationTest extends TestBase {
    //эта анатация junit5 даёт понять, что метод, следующий за ней будет выполняться перед каждым тестовым методом в этом классе. метод start подтягивается
    //из класса TestBase
    @BeforeEach
    public void startTest(){
        start();
    }
    //тоже самое только после каждого тестового метода
    @AfterEach
    public void endTest(){
        finish();
    }
    //анатация тест junit5 даёт понять, что следующий за ней метод - тестовый
    @Test
    public void authorizationWithWrongData(){
        //loginPage - та самая связь pageFactory из класса TestBase
        //если убрать из TestBase всё, что касается loginPage, то запись будет выглядеть примерно так
        // new Authorization(driver).enterInShopButtonClick();
        //
        loginPage.enterInShopButtonClick()
                .loginFieldFillIn("12345678901")
                // вот это позволяет сделать return this в методе
                //иначе пришлось бы писать каждый раз loginPage.метод
                .passwordFieldFillIn("123456abcd")
                .loginButtonClick();
        generalPage.isErrorTextDisplayed("[20] Неправильный Login или пароль.. ");
    }
}
