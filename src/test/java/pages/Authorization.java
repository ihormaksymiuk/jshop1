package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//в этом классе описываем все элементы и всю логику со страницы авторизации
public class Authorization {
    //инициализируюем(обьявляем) переменную driver
    WebDriver driver;
    //это конструктор с параметром. этот конструктор даёт понять, что в данном классе используется драйвер, который приходит из класса TestBase
    public Authorization(WebDriver driver) {
        this.driver = driver;
    }
//дальше идёт инициализация всех элементов, которые мы будем использовать в логике методов, такая запись позволит потом легче их редактировать
    //поскольку редактировать элемент нужно в одном месте
    @FindBy(xpath = "//a[.=' Вход в JShop ']")
    private WebElement enterInShopButton;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    //здесь запись типа public Authorization вместо public void даёт возможность в тестах писать все методы через точку в столбик с новой строки
    //для этого в 33 строке эта надпись return this
    public Authorization enterInShopButtonClick(){
        enterInShopButton.click();
        return this;
    }
    public Authorization loginFieldFillIn(String login){
        loginField.clear();
        loginField.sendKeys(login);
        return this;
    }
    public Authorization passwordFieldFillIn(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public void loginButtonClick(){
        loginButton.click();
    }

}
