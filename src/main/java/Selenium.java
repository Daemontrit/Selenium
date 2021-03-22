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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Selenium2\\src\\resources");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.avito.ru/");
        System.out.println("захожу на сайт авито ");
        driver.manage().window().maximize();
        System.out.println("Делаю окно на весь экран");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("добавляю время ожидания отклика элемента");
        Select category = new Select(driver.findElement(By.id("category")));
        category.selectByValue("99");
        System.out.println("создаю элемент списка и выбираю нужную мне категорию в списке");
        WebElement vvodPrinter =driver.findElement(By.id("search"));
        vvodPrinter.sendKeys("Принтер");
        System.out.println("ввожу в поисковую строку 'Принтер'");
        WebElement clickGorod = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        clickGorod.click();
        System.out.println("Кликаю по кнопке,для ввода нужного города");
        WebElement gorod = driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']"));
        gorod.sendKeys("Владивосток");
        System.out.println("Ввожу нужный мне город");
        WebElement ckickFirstItem = driver.findElement(By.xpath("//li[@data-marker='suggest(0)']"));
        ckickFirstItem.click();
        WebElement cliclPoisk= driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']"));
        cliclPoisk.click();
        System.out.println("Выбираю и кликаю на первый элемент из списка, и кликаю по поиску");
        WebElement checkbox = driver.findElement(By.xpath("//div[contains(@data-marker,'delivery')]//label[contains(@class,'checkbox')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Проверяю активировано ли поле чекбокса и кликаю по нему");
        WebElement clickPoisk2=driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']"));
        clickPoisk2.click();
        System.out.println("кликаю по поиску");
        Select doroje=new Select(driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']//select[@class='select-select-3CHiM']")));
        doroje.selectByValue("2");
        System.out.println("Выбираю из сортировки списка, сначала чтоб шли самые дорогие");
        List<WebElement> webElementsList=driver.findElements(By.xpath("//div[@class='items-items-38oUm']/div[@data-marker='item']"));
        {
            for (int i = 0; i < 3; i++) {
                System.out.println("Название " +webElementsList.get(i).findElement(By.xpath(".//h3[@class='title-root-395AQ iva-item-title-1Rmmj title-list-1IIB_ title-root_maxHeight-3obWc text-text-1PdBw text-size-s-1PUdo text-bold-3R9dt']")).getText()+
                        " Цена "+webElementsList.get(i).findElement(By.xpath(".//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());

            }
        }
        System.out.println("Создаю лист всех принтеров на странице , а пототм выбираю 3 самых первых элемента с выводом их цены и названия");



    }
}
