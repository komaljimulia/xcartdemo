package shopping;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingTest extends BaseTest {
    @Before
    public void openUrl(){
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }
    @Test
    public void  verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));//mouse hover on hot deals
        ////*[@id="header-area"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));//click on sales
        String expectedSaleMsg="Sale";//sale assert
        String realSaleMsg= getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not on sale page",expectedSaleMsg,realSaleMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); // mouse hover to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a")); //click 'A to Z'
        Thread.sleep(3000);
        clickOnElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));//click on avengers fabrikations
        clickOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div[3]/ul/li[2]/label/div/input[2]")); //check box of product
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/form[2]/div[2]/div[1]/div[3]/button[1]"));
        Thread.sleep(3000);
        String expectedAddedMsg="Product has been added to your cart";//assert for added cart
        String realAddedMsg=getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Veryfy that product should added",expectedAddedMsg,realAddedMsg);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign(in green bar)
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on your cart
        clickOnElement(By.xpath("//a[@class='regular-button cart']")); //click on view cart
        String expectedProductAddedMsg="Your shopping cart - 1 item";//product added assert
        String realProductAddedMsg=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Show the message if product is not added",expectedProductAddedMsg,realProductAddedMsg);
        driver.findElement(By.id("amount16")).clear();//first remove 1 quantity
        Thread.sleep(2000);
        driver.findElement(By.id("amount16")).click(); //click on quantity
        driver.findElement(By.id("amount16")).sendKeys("2");//add 2
        String added2ProductMsg = "Your shopping cart - 2 items";    //assert for 2 quantity added
        String real2ProductMsg = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Cart Does nOt Have 2 Items",added2ProductMsg, real2ProductMsg);
        String subTotal = "Subtotal: $59.98";  //assert for newly added product
        String realSubTotal = getTextFromElement(By.xpath("//span[@class='cart-subtotal']/parent::li/ancestor::ul"));
        Assert.assertEquals("SubTotal Is Wrong", subTotal, realSubTotal);
        String totalAmount = "$66.53";                     //verify Total
        String realTotalAmount = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Is Incorrect", totalAmount, realTotalAmount);
        clickOnElement(By.xpath("//span[text()='Go to checkout']"));//check out click
        String expectedLogInMsg = "Log in to your account";                   //login veryfy assert
        String realLogInMsg = getTextFromElement(By.xpath("//h3[text()='Log in to your account']"));
        Assert.assertEquals("User Is Not On Login your Account Page", expectedLogInMsg, realLogInMsg);
        sendTextToElement(By.id("email"),"cattyh@gmail.com");//change everytime
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));  //click on continue
        String expectedSecureText = "Secure Checkout";                            //asert for secure checkout
        String realSecureText = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("User Is Not On secureCheckout page", expectedSecureText, realSecureText);
        sendTextToElement(By.id("shippingaddress-firstname"),"Dipti");//firstname
        sendTextToElement(By.id("shippingaddress-lastname"), "Thakkar");  //lastname
        sendTextToElement(By.id("shippingaddress-street"), "6,Anthony court"); //address
        sendTextToElement(By.id("shippingaddress-custom-state"), "Harrow"); //state
        driver.findElement(By.id("shippingaddress-zipcode")).clear();
        sendTextToElement(By.id("shippingaddress-zipcode"), "HA1 2FW");
        Thread.sleep(3000);
        clickOnElement(By.id("create_profile"));  //click on check box “Create an account for later use”
        sendTextToElement(By.id("password"), "catty123"); //password
        Thread.sleep(2000);
        mouseHoverToElement(By.id("method128"));
        clickOnElement(By.id("method128"));   //click on local shipping method
        Thread.sleep(1000);
        clickOnElement(By.id("pmethod6"));//cod click
        String expectedTotal = "$66.53";                  //assert for total
        String realTotal = getTextFromElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("Total Is Wrong", expectedTotal, realTotal);
        mouseHoverToElement(By.xpath("//span[text()='Place order: $67.59']/parent::button"));
        clickOnElement(By.xpath("//span[text()='Place order: $67.59']/parent::button")); //click on place order button
        String expectedLastMsg = "Thank you for your order";    //verifying thank you page
        String realLastMsg = getTextFromElement(By.xpath("//h1[text()='Thank you for your order']"));
        Assert.assertEquals("Order Has Not Been Placed ", expectedLastMsg, realLastMsg);



    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click  Best seller
        String saleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[4]/a"));
        mouseHoverToElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        String expectedCartMsg = "Product has been added to your cart";   //assert for add to cart
        String actualCartMsg = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product Has Not Been Added To The Cart", expectedCartMsg, actualCartMsg);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign(in green colour)
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click your cart
        clickOnElement(By.xpath("//a[@class='regular-button cart']")); //click  view cart
        String shopCartMsg = "Your shopping cart - 1 item";
        String realCartMsg = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User's items have not been added to cart", shopCartMsg, realCartMsg);
        clickOnElement(By.xpath("//a[text()='Empty your cart']"));
        String emptyCartMsg = "Are you sure you want to clear your cart?";
        String realEmptyCartMsg = driver.switchTo().alert().getText();//to get text which we can not inspect
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartMsg, realEmptyCartMsg);
        driver.switchTo().alert().accept();//when ok is also not inspected
        String empryCartMsg = "Item(s) deleted from your cart";            //checking green bar message
        String actualEmptyCartMsgIs = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empryCartMsg, actualEmptyCartMsgIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your  empty cart message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);

    }
    @After
    public void tearDown() {
        closeBrowser();

    }

}
