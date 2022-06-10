package Tests;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Zadaci extends BaseClass {


    @BeforeMethod
    public void setUp (){

        initializeDrivers();
    }
    @Test
    public void Zadatak1(){

        driver.get(prop.getProperty("urlZadatak1"));
        WebElement AddButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        AddButton.click();
        AddButton.click();
        AddButton.click();

        //better aproach
        //List<WebElement> DeleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));

        WebElement DeleteButton1 = driver.findElement(By.xpath("//button[@class='added-manually'][1]"));
        DeleteButton1.isDisplayed();

        WebElement DeleteButton2 = driver.findElement(By.xpath("//button[@class='added-manually'][2]"));
        DeleteButton2.isDisplayed();

        WebElement DeleteButton3 = driver.findElement(By.xpath("//button[@class='added-manually'][3]"));
        DeleteButton2.isDisplayed();

        DeleteButton2.click();

        WebElement DeleteButton1After = driver.findElement(By.xpath("//button[@class='added-manually'][1]"));
        WebElement DeleteButton2After = driver.findElement(By.xpath("//button[@class='added-manually'][2]"));

        DeleteButton1After.isDisplayed();
        DeleteButton2After.isDisplayed();
    }
    @Test
    public void Zadatak2(){

        driver.get(prop.getProperty("urlZadatak2"));
        WebElement galleryButton = driver.findElement(By.xpath("//a[@href='/gallery/']"));

        for (int i = 0; i < 10; i++){
            driver.navigate().refresh();

                if(galleryButton !=null){
                    System.out.println("Gallery button present!");
                    assert galleryButton.isDisplayed();
                }
            else {
                System.out.println("Gallery button is missing!");
            }
            //ne znam zasto ne radi?!
        }
    }
    @Test
    public void Zadatak3(){

        driver.get(prop.getProperty("urlZadatak3"));
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();

        String messageAfterEnabledClickXpath = "//p[@id='message']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(messageAfterEnabledClickXpath)));

        String getText = driver.findElement(By.xpath("//p[@id='message']")).getText();

        assert getText.equals(getText) : "It's enabled!";

        WebElement disableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        disableButton.click();

        //not working


    }
    @Test
    public void Zadatak4(){

        driver.get(prop.getProperty("urlZadatak4"));
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);

        WebElement inputField = driver.findElement(By.xpath("//body[@id='tinymce']"));
        inputField.clear();
        inputField.sendKeys("selenium.dev/documentation/webdriver/browser/frames/");
    }
    @Test
    public void Zadatak5(){

        driver.get(prop.getProperty("urlZadatak5"));
        String dataValue = driver.findElement(By.xpath("//td[contains(text(),'40.10')]")).getText();
        assert dataValue.equals(dataValue) : "40.10";

    }
    @AfterMethod
    public void quit(){

        driver.quit();
    }
}
