import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPoUp {
    private WebDriver driver;

    public AuthPoUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "j_username")
    private WebElement nameTextInput;
    @FindBy(name = "j_password")
    private WebElement passwordTextInput;
    @FindBy(css = "button[form=\"login-email-form\"]")
    private WebElement loginButton;

    public AuthPoUp setName(String name) {
        nameTextInput.sendKeys(name);
        return this;
    }

    public AuthPoUp setPassword(String password) {
        passwordTextInput.sendKeys(password);
        return this;
    }

    public AuthPoUp clickLogin() {
        loginButton.click();
        return this;
    }
}
