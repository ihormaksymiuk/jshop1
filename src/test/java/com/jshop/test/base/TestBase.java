package com.jshop.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Authorization;
import pages.General;

import java.util.concurrent.TimeUnit;
//этот класс сделан для того, чтобы сделать базовые настройки типа конфигурации вебдрайвера, что делать перед тестом и после теста.
public class TestBase {
    // cоздаём новую переменную driver типа ChromDriver, эту переменную выносим вверх, чтобы она была видна в обоих методах start и finish
    public ChromeDriver driver;
    // cоздаём переменную loginPage типа Authorization для pageObject модели
    public Authorization loginPage;
    // cоздаём переменную generalPage типа General для pageObject модели
    public General generalPage;
    String SITE_URL = "https://app.jowi.online/auth/sign-up";

    //в этом методе мы прописываем всё, что будет делаться до начала теста
    public void start(){
        //здесь мы задаём тип драйвера и происходит скачивание нужного драйвера в зависимости от типа системы
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //дальше задаём настройки ожиданий элементов, загрузки страницы и загрузки выполнения скрипта на странице
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //переходим на страницу сайта
        driver.get(SITE_URL);
        //cледующие две строки это pageFactory - позволяет сделать зависимость между переменными из строк 15 и 17 и pageObject моделью
        //если не сделать такую запись, то на странице теста нужно будет писать не loginpage.метод,а new Authorization(driver).метод
        loginPage = PageFactory.initElements(driver, Authorization.class);
        generalPage = PageFactory.initElements(driver, General.class);
    }

    //описываем что делаем после теста
    public void finish(){
        driver.quit();
    }
}
