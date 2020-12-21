import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    public static WebDriver webDriver = new ChromeDriver();
    public static MainPage mainPage;

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sasha\\IdeaProjects\\automatization");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://mirtesen.ru/main");
        mainPage = new MainPage(webDriver);
    }

    @AfterAll
    public static void ending(){
        webDriver.quit();
    }

    @Test
    public void types_test() {
        mainPage.top_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String q1 = webDriver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div/div[2]/div[1]/article/div[2]/div[1]/h3")).getText();
        mainPage.new_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String q2 = webDriver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div/div[2]/div[1]/article/div[2]/div[1]/h3")).getText();
        //the same full xpath /html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/article/div[2]/div[1]/h3
        assertNotEquals(q1, q2, "Mistake in newsline changing!");
    }

    @Test
    public void friend_type_test(){
        mainPage.friends_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Вход",webDriver.findElement(By.className("auth-form__form__title")).getText(), "Не открылось окно входа" );
        //if doesnt work /html/body/div[3]/div/div[1]/div/div/div[2]/div/div
        webDriver.findElement(By.cssSelector(".close")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void external_link_test(){
        mainPage.externallink_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        assertNotEquals("https://mirtesen.ru/main", webDriver.getCurrentUrl(), "Still are here!");
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(0));
        assertTrue((mainPage.top_btn).isDisplayed());
    }

    @Test
    public void reg_test(){
        mainPage.reg_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//*[@id=\"authFormRegPhone\"]")).sendKeys("81234567890");
        try {

            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(webDriver.findElement(By.xpath("//*[@id=\"authFormRegPhone\"]")).getText());
    }

    @Test
    public void service_btns_test(){
        mainPage.like_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Вход", webDriver.findElement(By.className("auth-form__form__title")).getText());
        webDriver.findElement(By.cssSelector(".close")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.comment_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.comment_text_btn.sendKeys("Привет!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Привет!", webDriver.findElement((By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/article/div[5]/div/div/div/div/div[1]/div"))).getText());
    }

    @Test
    public void menu_btn_test(){
        Dimension d = new Dimension(800,600);
        webDriver.manage().window().setSize(d);
        mainPage.menu_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue((mainPage.rubriki_text_btn).isDisplayed());
    }

    @Test
    public void menu_full_btn_test(){
        Dimension d = new Dimension(800,600);
        webDriver.manage().window().setSize(d);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.menu_btn.click();
        mainPage.shawall_btn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(mainPage.cinema_btn.isDisplayed());
        mainPage.cinema_btn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(mainPage.cinema_text_btn.isDisplayed());
        assertNotEquals("https://mirtesen.ru/main", webDriver.getCurrentUrl(), "Not there!");
    }

    @Test
    public void bank_btn_test(){
        mainPage.obmen_btn.click();
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div/div/div[2]/span[3]")).getText().equals("по самому выгодному курсу"), "Not there!");

        mainPage.bank_btn.clear();
        mainPage.bank_btn.sendKeys("123456");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(Integer.parseInt(mainPage.bank_res_btn.getText()) < 1700);
        webDriver.close();
    }


}