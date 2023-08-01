package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ListenersTest2 {
    @Test

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
