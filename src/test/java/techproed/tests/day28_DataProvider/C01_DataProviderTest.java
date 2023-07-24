package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {
    /*
        DataProvider bircok veriyi test caselere loop kullanmadan aktarmak icin kullanilir.
     TestNg den dgelen bir ozelliktir iki boyutlu Array (multidimensionel array)   return eder.
     Kullanimi icin @test notasyonundan sonra parametre olarak (dataprovider"method ismi yazilir").
     Kac tane veri ile calisilacaksa test methoduna oka dar parametre eklenir.
     Data driven testing(ddt) de dataalrimiz 3 farkli sekilde kullanabiliriz
        1-.properties dosyasindan datalari alabiliriz--> configreader.getproperty() ile
        2-Excel dosyasindan datalari alabiliriz-->ExcelReader class i ile -->veri cok ise daha iyi
        3-Dataprovider kullanarak datalari alabiliriz-->dataprovider methodu ile
     */
    @DataProvider(name = "test02")//-->Bu dataprovider i test02 icin kullan anlamina gelir,tets01 icin iptal olur
    public static Object[][]isimler(){
        return new Object[][]{
                {"esen"},
                {"mehmet"},
                {"esma"},
                {"omer"},
                {"mert"},
                {"burcu"},
                {"selim"}};
    }
    /*
        DataProvider'i database veya excel gibi dusunebiliriz.
       Istersek 10 tane test methodu olusturup burdan istedigimiz veriyi cekip kullanabiliriz
        */
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"ford"},
                {"toyota"},
                {"volvo"},
                {"audi"}};
    }

    /*
        Olusturdugumuz dataProvider methodunu baska bir test metodunda da kullanabiliriz.
    Bunun icin @dataprovider notasyonundan sonra olusturdugumuz methodun ismini(name="test02") olarak belirtmemiz gerekir
     */
    @Test(dataProvider = "isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isim) {
        System.out.println(isim);

    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {

    }
}
