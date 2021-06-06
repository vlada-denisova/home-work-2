import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CartTest  extends BaseTest{

    @Test
    public void cart(){
        driver.get(baseUrl);//переход на url сайта из родительского класса
        driver.findElement(By.xpath("//a[@title=\"Одежда\"]")).click();//переход в категорию "Одежка"

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scroll(0,1000)");//скрол страницы при ленивой загрузке
        driver.findElement(By.xpath("//a[contains(@class, \"product-card__btn-link\")]")).click();//переход в первую карточку товара
        String price = driver.findElement(By.cssSelector(".price-panel__current-value")).getText();//сохранение цены из карточки товара
        driver.findElement(By.xpath("//div[@class=\"confirm-message__button-close\"]")).click();//закрыть всплывающее окно 1
        driver.findElement(By.xpath("//div[@class=\"confirm-message__button-block\"]")).click();//закрыть всплывающее окно 2
        driver.findElement(By.xpath("//button[@data-js=\"button-add-to-cart\"]")).click();//добавление товара в корзину
        driver.findElement(By.xpath("//span[@class=\"text-info-for-link\"]")).click();//переход в корзину
//        String cartPrice = driver.findElement(By.xpath("//p[@class=\"price-panel__current-value\"]")).getText();//почему-то цена из этого элемента возвращается пустой строкой
        String cartPrice = driver.findElement(By.xpath("//div[@class=\"cart-info__line\"]//p[2]")).getText();//сохранение цены из корзины
        Assert.assertEquals(price,cartPrice);//сравнение цены из корзины и карточки товара
    }
}
