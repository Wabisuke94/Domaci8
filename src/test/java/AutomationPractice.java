import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;
public class AutomationPractice {

    WebDriver driver;
    String URL = "http://automationpractice.com/index.php";

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(URL);
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void register(){
        //Click on Sign in button
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        //Enter email
        driver.findElement(By.cssSelector("#email_create")).sendKeys(emailRandom());
        //Click create account
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        //Click on Mr.
        driver.findElement(By.cssSelector("#id_gender1")).click();
        //driver.findElement(By.xpath("//label[text()[contains(.,'Mr.')]]"));
        //driver.findElement(By.xpath("//div/label[text()='Title'/../div[1]//input");
        //driver.findElement(By.cssSelector(".clearfix > div:nth-child(3) > input");
        //Input first name
        driver.findElement(By.xpath("//input[@name=\"customer_firstname\"]")).sendKeys("Uros");
        //Input last name
        driver.findElement(By.xpath("//input[@name=\"customer_lastname\"]")).sendKeys("Spasic");
        //Input password
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("123456p");
        //Select day
        Select dan = new Select(driver.findElement(By.cssSelector("select[id='days']")));
        dan.selectByValue("11");
        //Select month
        Select mesec = new Select(driver.findElement(By.cssSelector("select[id='months']")));
        mesec.selectByValue("6");
        //Select year
        Select godina = new Select(driver.findElement(By.cssSelector("select[id='years']")));
        godina.selectByValue("1994");
        //Input first name2
        driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Uros");
        //Input last name2
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Spasic");
        //Input Address
        driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("Luja Adamica 19");
        //Input City
        driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Beograd");
        //Select state
        Select drzava = new Select(driver.findElement(By.cssSelector("select[id='id_state']")));
        drzava.selectByVisibleText("Alabama");
        //Input Zip code
        driver.findElement(By.xpath("//input[@id=\"postcode\"]")).sendKeys("11070");
        //Input Mobile number
        driver.findElement(By.xpath("//input[@id=\"phone_mobile\"]")).sendKeys("0606110694");
        //Input address alias
        driver.findElement(By.xpath("//input[@id=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"alias\"]")).sendKeys("1234");
        //Register click
        driver.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class=\"info-account\"]")).getText(),
                "Welcome to your account. Here you can manage all of your personal information and orders."
        );
    }
   // @Test
   // public void contactUs() {
   //     //Click on Contact Us button
   //     driver.findElement(By.xpath("//a[text()='Contact us']")).click();
   //     WebElement subjectHeadingElement = driver.findElement(By.cssSelector("#id_contact"));
   //     //Select "Customer service"
   //     Select subjectHeadingSelect = new Select(subjectHeadingElement);
   //     subjectHeadingSelect.selectByVisibleText("Customer service");
//
   //     //Enter email address
   //     driver.findElement(By.cssSelector("input[name='from']")).sendKeys("nekimail@gmail.com");
//
   //     //Enter order id
   //     driver.findElement(By.cssSelector("input[name='id_order']")).sendKeys("123");
//
   //     //Enter message
   //     driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Poruka");
//
   //     //Click se3nd button
   //     driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
//
   //     Assert.assertEquals(
   //             driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]")).getText(),
   //             "Your message has been successfully sent to our team."
   //     );
//
   //     Assert.assertEquals(
   //             driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]")).getCssValue("background-color"),
   //             "rgba(85, 198, 94, 1)"
   //     );
//
   //     Assert.assertEquals(driver.getTitle(),"Contact us - My Store");
//
   // }
//
   // @Test
   // public void contactUsNoEmail(){
   //     //Click on Contact Us button
   //     driver.findElement(By.xpath("//a[text()='Contact us']")).click();
   //     WebElement subjectHeadingElement = driver.findElement(By.cssSelector("#id_contact"));
   //     //Select "Customer service"
   //     Select subjectHeadingSelect = new Select(subjectHeadingElement);
   //     subjectHeadingSelect.selectByVisibleText("Customer service");
//
   //     //Enter order id
   //     driver.findElement(By.cssSelector("input[name='id_order']")).sendKeys("123");
//
   //     //Enter message
   //     driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Poruka");
//
   //     //Click se3nd button
   //     driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
//
   //     Assert.assertEquals(
   //             driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]//li")).getText(),
   //             "Invalid email address."
   //     );
//
   //     Assert.assertEquals(
   //             driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getCssValue("background-color"),
   //             "rgba(243, 81, 92, 1)"
   //     );
//
   //     Assert.assertEquals(driver.getTitle(),"Contact us - My Store");
   // }
//
   // @Test
   // public void contactUsSubjectHeadingText(){
   //     //Click on Contact Us button
   //     driver.findElement(By.xpath("//a[text()='Contact us']")).click();
   //     WebElement subjectHeadingElement = driver.findElement(By.cssSelector("#id_contact"));
   //     //Select "Customer service"
   //     Select subjectHeadingSelect = new Select(subjectHeadingElement);
   //     subjectHeadingSelect.selectByVisibleText("Customer service");
//
   //     Assert.assertEquals(
   //            driver.findElement(By.cssSelector("#desc_contact2")).getText(),
   //             "For any question about a product, an order"
   //     );
//
   //    Assert.assertEquals(
   //            driver.getTitle(),
   //            "Contact us - My Store"
   //    );


    public String emailRandom(){
        Random random = new Random();
        int x = random.nextInt(1000);
        System.out.println("test" + x + "@gmail.com");
        return "test" + x + "@gmail.com";

    }
}
