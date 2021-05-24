import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Родительский класс для всех тестов
 */
public class BaseTest {
    protected WebDriver driver;//драйвер для работы с браузером и элементами сайта
    protected static final String baseUrl = "https://accstorefront.ced73xzk9p-directtra1-s1-public.model-t.cc.commerce.ondemand.com/";//url сайта

    /**
     * Метод помеченный анотацией @Before будет выполняться перед каждым тестом
     */
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();//задаем каким браузером будем пользоваться
        driver = new ChromeDriver();//инициализируем драйвер как хром драйвер
        driver.manage().window().maximize();//устанавливаем размер окна браузера
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//устанавливаем время отклика для элементов сайта 5 секунд
        driver.manage().deleteAllCookies();//чистим куки
    }

    /**
     * Метод помеченной анотацией @After будет выполняться после каждого теста, даже если тест упал или провалился т.е. в любом случае
     */
    @After
    public void shutdown() {
        driver.quit();//закрыть браузер  - чтобы бразуер не закрывался, закомментируй эту строку двойным слешом
        // не путать с driver.close(); - закрытие окна браузера
    }
}
