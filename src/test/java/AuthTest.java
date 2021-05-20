import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Тест должен содержать 'Test' в своем имени иначе maven в связке с junit не увидит ваш тест при запуске через maven
public class AuthTest extends BaseTest {//наследуем тест от родительского класса

    /**
     * Тестовый метод (сам тест)
     * с комментариями
     */
    @Test
    public void auth() {
        driver.get(baseUrl);//переходим на url = baseUrl
        driver.findElement(By.cssSelector(".user-menu__account")).click();//находим кнопку ВОЙТИ по css селектору и затем кликаем на неё
        driver.findElement(By.name("j_username")).sendKeys("test");/*находим текстовое поле ПОЧТА
        по атрибуту name в разметке и вводим текст test*/
        driver.findElement(By.xpath("(//input[@data-js=\"password\"])[2]")).sendKeys("password");
        //находим текстовое поле ПАРОЛЬ и вводим туда текст password
        //todo Домашнее задание 1: изменить локатор для поля ПАРОЛЬ с xpath на css-локатор или name-локатор (примеры выше)
        driver.findElement(By.cssSelector("button[form=\"login-email-form\"]")).click();//находим кнопку войти и кликаем её
        //todo Домашнее задание 2: изменить cssSelector на xpath для кнопки ВОЙТИ

        //объявим локатор и вебэлемент в котором выводится сообщение о некорректном вводе почты в отдельных шагах
        String locatorString = "//div[@class=\"authentication active\"]//*[@data-js=\"email\"]//p";//локатор в виде строки текста
        By locator = By.xpath(locatorString);//локатор инициализированный с помощью строки выше
        WebElement validateMessageTextView = driver.findElement(locator);//инициализировали вебэлемент с помощью локатора полученного выше
        String expectedMessage = "ашибка";//ожидаемое сообщение
        String actualMessage = validateMessageTextView.getText();//получение текста из вебэлемента
        Assert.assertEquals("Текст ошибки некорректный", expectedMessage, actualMessage);//сравнение ожидаемого текста с реальным
        //todo Домашнее задание 3: запустить тест, посмотреть лог и затем исправить текст expectedMessage, чтобы тест прошел успешно
    }
}
