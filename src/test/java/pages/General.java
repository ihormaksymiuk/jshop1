package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
//обычно использую такой класс для каких-то общих элементов типа всплывающих окон и т.д.
public class General {
    // создаем переменную для логирования
    private static final Logger LOG = LoggerFactory.getLogger(General.class);
    public General(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void isErrorTextDisplayed(String errorText) {
        //здесь находим все элементы с текстом ошибки - результат такого поиска - массив. если размер массива больше нуля, значит элемент присутствует
        assertTrue(driver.findElements(By.xpath("//div[@class='text' and text()='" + errorText + "']")).size() > 0);
        //помещаем тест ошибки (который мы ожидаем увидеть) в лог с уровнем инфо. в папке resourses есть файл logback-test.xml там регулируется как будет выглядить лог
        LOG.info(errorText);
    }
}
