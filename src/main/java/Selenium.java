import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ggez\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select category = new Select(driver.findElement(By.id("category")));

// category.getOptions().forEach(option->{
// System.out.println("Value"+option.getAttribute("value ")+":Text="+option.getText());

// });
        category.selectByValue("99");
        driver.findElement(By.id("search")).sendKeys("Принтер");
        WebElement clickGorod = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        clickGorod.click();
        WebElement gorod = driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']"));
        gorod.sendKeys("Владивосток");
        WebElement ckickFirstItem = driver.findElement(By.xpath("//li[@data-marker='suggest(0)']"));
        ckickFirstItem.click();
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
//        WebElement element = driver.findElement(By.xpath("//div[contains(@data-marker,'delivery')]//label[contains(@class,'checkbox')]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        element.click();
        WebElement checkbox = driver.findElement(By.xpath("//div[contains(@data-marker,'delivery')]//label[contains(@class,'checkbox')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        Select doroje=new Select(driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']//select[@class='select-select-3CHiM']")));
        doroje.selectByValue("2");
        //div[@class='items-items-38oUm']/div[@data-marker='item']
        List<WebElement> webElementsList=driver.findElements(By.xpath("//div[@class='items-items-38oUm']/div[@data-marker='item']"));
        {
            for (int i = 0; i < 3; i++) {
                System.out.println("Название " +webElementsList.get(i).findElement(By.xpath(".//h3[@class='title-root-395AQ iva-item-title-1Rmmj title-list-1IIB_ title-root_maxHeight-3obWc text-text-1PdBw text-size-s-1PUdo text-bold-3R9dt']")).getText()+
                        " Цена "+webElementsList.get(i).findElement(By.xpath(".//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());

            }
        }



    }
}
//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']
//h3[@class='title-root-395AQ iva-item-title-1Rmmj title-list-1IIB_ title-root_maxHeight-3obWc text-text-1PdBw text-size-s-1PUdo text-bold-3R9dt']/text(Полноцветный струйный принтер ComColor 3010)