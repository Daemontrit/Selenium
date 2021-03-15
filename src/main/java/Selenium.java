import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\ggez\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get(" https://www.avito.ru/");
//Thread.sleep(10000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Select category = new Select(driver.findElement(By.id("category")));

// category.getOptions().forEach(option->{
// System.out.println("Value"+option.getAttribute("value ")+":Text="+option.getText());

// });
        category.selectByValue("99");
        driver.findElement(By.id("search")).sendKeys("Принтер");
        WebElement clickGorod= driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        clickGorod.click();
        WebElement gorod=driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']"));
        gorod.sendKeys("Владивосток");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Select vladivostok=new Select(driver.findElement(By.xpath("//li[@class='suggest-suggest-1wwEm suggest-suggest_active-2UNeu text-text-1PdBw text-size-m-4mxHN']")));
        //vladivostok.getFirstSelectedOption();
        WebElement ckickFirstItem=driver.findElement(By.xpath("//li[@class='suggest-suggest-1wwEm suggest-suggest_active-2UNeu text-text-1PdBw text-size-m-4mxHN']"));
        ckickFirstItem.click();



    }
}