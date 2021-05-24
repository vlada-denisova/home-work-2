import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    protected  String baseUrl = "https://accstorefront.ced73xzk9p-directtra1-s1-public.model-t.cc.commerce.ondemand.com/";//url сайта

    @FindBy(css = ".user-menu__account")
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open() {
        driver.get(baseUrl);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
