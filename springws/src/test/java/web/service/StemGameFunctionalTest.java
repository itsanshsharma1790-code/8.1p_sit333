package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StemGameFunctionalTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver setupDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/anshsharma1700/Documents/selenium/chromedriver"
        );

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private void login(WebDriver driver) {
        driver.navigate().to("http://127.0.0.1:8080/login");
        sleep(2);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("ansh");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("ansh_pass");

        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys("01/01/2004");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
    }

    @Test
    public void testLoginSuccessMovesToQ1() {
        WebDriver driver = setupDriver();

        login(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

        driver.close();
    }

    @Test
    public void testQ1CorrectAnswerMovesToQ2() {
        WebDriver driver = setupDriver();

        driver.navigate().to("http://127.0.0.1:8080/q1");
        sleep(2);

        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("result")).sendKeys("3");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));

        driver.close();
    }

    @Test
    public void testQ1WrongAnswerStaysOnQ1() {
        WebDriver driver = setupDriver();

        driver.navigate().to("http://127.0.0.1:8080/q1");
        sleep(2);

        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("result")).sendKeys("5");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

        driver.close();
    }

    @Test
    public void testQ2CorrectAnswerMovesToQ3() {
        WebDriver driver = setupDriver();

        driver.navigate().to("http://127.0.0.1:8080/q2");
        sleep(2);

        driver.findElement(By.id("number1")).sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("result")).sendKeys("3");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

        driver.close();
    }

    @Test
    public void testQ3WrongAnswerStaysOnQ3() {
        WebDriver driver = setupDriver();

        driver.navigate().to("http://127.0.0.1:8080/q3");
        sleep(2);

        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("10");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

        driver.close();
    }
}