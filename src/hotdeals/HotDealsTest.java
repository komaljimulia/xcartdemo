package hotdeals;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends BaseTest {
    @Before
    public void openUrl(){
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically(){
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String saleMsg = "Sale";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); // mouse hover to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a")); //click on 'A to Z'
        String expectedFirstDisplayMsg = "Name A - Z";
        String actualFirstDisplayMsg = getTextFromElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("products are  In Alphabetical Order",expectedFirstDisplayMsg,actualFirstDisplayMsg);

    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh(){
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span")); //click on sale
        String saleMsg = "Sale";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move hover to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[3]/a"));  //click on price'low to high'
        String expectedSortByMsg = "Price Low - High";
        String actualSortByMsg = getTextFromElement(By.xpath("//span[text()='Price Low - High']"));
        Assert.assertEquals("Products Are Not Sorted In price Low to High",expectedSortByMsg,actualSortByMsg);
    }
    @Test
    public void verifySaleProductsArrangeByRates(){
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span")); //click on sale
        String saleMsg = "Sale";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[7]/a"));  //click on Rates
        String expectedSortByMsg = "Rates";
        String actualSortByMsg = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);
    }
    @Test
    public void  verifyBestSellersProductsArrangeByZToA() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleMsg = "Bestsellers";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[5]/a")); //click on'Z To A'
        String expectedSortByMsg = "Name Z - A";
        String actualSortByMsg = getTextFromElement(By.xpath("//span[text()='Name Z - A']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortByMsg, actualSortByMsg);
    }
    @Test
    public  void   verifyBestSellersProductsPriceArrangeHighToLow(){
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleMsg = "Bestsellers";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[3]/a")); //click on'Price High-Low''
        String expectedSortByMsg = "Price High - Low";
        String actualSortByMsg = getTextFromElement(By.xpath("//span[text()='Price High - Low']"));
        Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);
    }
    @Test
    public  void verifyBestSellersProductsArrangeByRates(){
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleMsg = "Bestsellers";
        String actualSalesMsg = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); // mouse hover to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[6]/a")); //click on'Rates'
        String expectedSortByMsg = "Rates";
        String actualSortByMsg = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }








}
