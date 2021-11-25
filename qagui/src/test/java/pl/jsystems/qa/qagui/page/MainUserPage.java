package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainUserPage extends BasePage {

    public MainUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String AVATAR = "\".masterbar__item.masterbar__item-me\"";
    @FindBy(css = AVATAR)
    public WebElement avatar;
    //public WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

    public void clickAvatar() {
        click(this.avatar, 5);
    }

}