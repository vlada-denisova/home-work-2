import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    protected  String baseUrl = "https://accstorefront.ced73xzk9p-directtra1-d1-public.model-t.cc.commerce.ondemand.com/";//url сайта

    @FindBy(css = ".user-menu__account")
    private WebElement loginButton;
    @FindBy(className = "loader")
    private WebElement loader;
    @FindBy(css = ".site-logo__img")
    private WebElement logo;
    @FindBy(css = ".user-menu__account--logged-in .user-menu__item-body")
    private WebElement userIcon;

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

    public void clickLogo() {
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.invisibilityOf(loader));
        logo.click();
    }

    public void scrollDown() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
//        javascriptExecutor.executeScript("window.scroll(0,1000)");
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void moveToElement() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(userIcon).build().perform();
        userIcon.click();
    }

}
