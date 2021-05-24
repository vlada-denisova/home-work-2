import org.junit.Before;
import org.junit.Test;

public class AuthWithPageObject extends BaseTest{
    private MainPage mainPage;

    @Before
    public void initPages() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void auth() {
        mainPage.open();
        mainPage.clickLoginButton();
    }
}
