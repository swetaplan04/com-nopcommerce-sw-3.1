package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBalticOrder(){
        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropDown(By.name("products-orderby"),"Name: Z to A");
        verifyElements("error","Name: Z to A",By.xpath("//option[contains(text(),'Name: Z to A')]"));
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropDown(By.name("products-orderby"),"Name: A to Z");
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        verifyElements("error","Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"),"8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(1000);
        // clickOnElement(By.name("product_attribute_5"));
        clickOnElement(By.id("product_attribute_5_12"));
        verifyElements("error","$1,470.00",By.id("price-value-1"));
        clickOnElement(By.id("add-to-cart-button-1"));
        verifyElements("error","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(1000);
        verifyElements("error","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));

        Thread.sleep(2000);
        WebElement Quality= driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
        Quality.clear();
        Quality.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.id("updatecart"));
        Thread.sleep(1000);
        verifyElements("error","$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyElements("error","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        sendKeyToElement(By.id("BillingNewAddress_FirstName"),"Michael");
        sendKeyToElement(By.id("BillingNewAddress_LastName"),"Peter");
        sendKeyToElement(By.id("BillingNewAddress_Email"),"MichaelPeter100@gmail.com");
        sendKeyToElement(By.id("BillingNewAddress_Company"),"ABC Limited");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendKeyToElement(By.id("BillingNewAddress_City"),"London");
        sendKeyToElement(By.id("BillingNewAddress_Address1"),"123 High Street");
        sendKeyToElement(By.id("BillingNewAddress_ZipPostalCode"),"EC157YN");
        sendKeyToElement(By.id("BillingNewAddress_PhoneNumber"),"1234567");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");
        sendTextToElement(By.id("CardholderName"),"Mr Michael Peter");
        sendTextToElement(By.id("CardNumber"),"5356 6548 1418 5420");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"12");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2025");
        sendTextToElement(By.id("CardCode"),"123");
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        verifyElements("error","Payment Method:",By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyElements("error","Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error","Shipping Method:",By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error","Next Day Air",By.xpath("//span[contains(text(),'Next Day Air')]"));
        verifyElements("error","$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyElements("error","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]\n"));

    }
    @After
    public void tearDown() {
        //  closeBrowser();
    }
}

