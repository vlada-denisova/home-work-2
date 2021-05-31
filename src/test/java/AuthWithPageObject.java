import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthWithPageObject extends BaseTest {
    private MainPage mainPage;
    private AuthPoUp authPoUp;

    @Before
    public void initPages() {
        mainPage = new MainPage(driver);
        authPoUp = new AuthPoUp(driver);
    }

    @Test
    public void auth() {
        mainPage.open();
        mainPage.clickLoginButton();
        authPoUp
                .setName("test@test2.com")
                .setPassword("Qwerty1234")
                .clickLogin();
        mainPage.clickLogo();
        mainPage.scrollDown();
        mainPage.moveToElement();
    }
}
