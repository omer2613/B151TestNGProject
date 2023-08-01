package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {

    /*
    Olusturdugumuz test class'inda listeners yapisini kullanabilmek icin class'dan once @Listeners notasyonu
    olustururuz. Ve bu notasyona parametre olarak olusturmus oldugumuz listeners class'inin yolunu belirtiriz
     */

    @Test(invocationCount = 10,successPercentage = 90)
    /*
    @Test notasyonundan sonra parametre olarak invocationCount = 10 eklersek belirttiğimiz sayı kadar
    testlerimizi çalıştırır. successPercentage = 90 bu parametre ise yüzdelik belirtir yani ikisi bir arada
    kullanılırsa 10 testten 1 tanesi çalışmaz ise sorun olmaz ama 2 tanesi çalışmaz ise onTestFailedButWithinSuccessPercentage()
    methodu devreye girer.
    */
    public void test01() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }

    @Test
    public void test02() {
        System.out.println("FAİLED");
        Assert.assertTrue(false);//Ekran resmi almak icin browser'i acti
    }

    @Test
    public void test03() {
        System.out.println("SKİP");
        throw new SkipException("Bu method atlandı");

    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("ldskdsk")).click();
    }
}
