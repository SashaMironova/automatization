import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[1]/div/button[2]")
    public WebElement top_btn;
    @FindBy(xpath = "//*[@id=\"feed-switcher-new\"]")
    public WebElement new_btn;
    @FindBy(xpath = "//*[@id=\"feed-switcher-followers\"]")
    public WebElement friends_btn;


    @FindBy(css = "#header > div > div > div > div.header-login > ul > li:nth-child(1) > button")
    public WebElement reg_btn;
    @FindBy(css = "#header-teaser-link")
    public WebElement externallink_btn;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/article/div[3]/div/div/div[2]/div[1]/div[2]/button")
    public WebElement like_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/article/div[3]/div/div/div[2]/div[2]/div[2]/a")
    public WebElement comment_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/article/div[5]/div/div/div[1]/div[1]/div/div/div")
    public WebElement comment_text_btn;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/header/div/div/div/div[1]")
    public WebElement menu_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div[1]/div") // text rubriki
    public WebElement rubriki_text_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div[1]/button")
    public WebElement shawall_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div[1]/h3[13]/a") // cinema
    public WebElement cinema_btn;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/h1")
    public WebElement cinema_text_btn;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]")
    public WebElement obmen_btn;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[2]/td[1]/input")
    public WebElement bank_btn;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/table/tbody/tr[2]/td[3]/span")
    public WebElement bank_res_btn;

}
