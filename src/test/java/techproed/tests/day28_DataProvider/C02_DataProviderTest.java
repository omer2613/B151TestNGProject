package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"toyota"},
                {"volvo"},
                {"bugatti"},
                {"ford"}};
    }

    /*
        Google sayfasina gidip
        Dataprovider kullanrak belirtilen arac isimlerini aratalim
         */
    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasina gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        //DataProvider daki verilerle arama yapalim
        GooglePage googlePage=new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar);//-->sendKeys de yapabiliriz
        googlePage.aramaKutusu.submit();
        ReusableMethods.bekle(2);
        //Her sayfa icin sayfa resmi alalim
       // ReusableMethods.tumSayfaResmi(test01(arabalar()).getName());

        //sayfayi kapatalim
        Driver.closeDriver();


    }
}
