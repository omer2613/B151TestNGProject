package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalExcelTest {
    @Test
    public void test01() {
        //Dosyayolu ve sayfa ismini ile objemizi olusturalim

        String dosyaYolu = ConfigReader.getProperty("dosyaYolu");
        String sayfaIsmi = ConfigReader.getProperty("sayfaIsmi");
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);


        /*
        mysmoketestdata excel dosyasındaki tüm email ve passwordler ile
Bluerentalcar sitesinde login olalım ve her kullanıcı için login olduğunu doğrulayalım
         */

        //Bluerentalcar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage=new BlueRentalPage();//-->locate lere ulsabilmek icin page obje olusturduk


        //Bir loop kullanip excel dosyasindaki tum veriler ile login olalim
        for (int i = 1; i <=reader.rowCount(); i++) {//-->i'yi (1.)birden baslattik cunku (0.)sifirinci indexte basliklar var
            String email = reader.getcellData(i, 0);
            String password = reader.getcellData(i, 1);
            System.out.println(email + " || " + password);
            rentalPage.login.click();
            ReusableMethods.bekle(2);
            rentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
            ReusableMethods.bekle(2);
            rentalPage.loginVerify.click();
            ReusableMethods.bekle(1);
            Assert.assertTrue(rentalPage.logOut.isDisplayed());
            rentalPage.logOut.click();
            ReusableMethods.bekle(1);
            rentalPage.ok.click();


        }
            //sayfayi kapatiniz
        Driver.closeDriver();
        }

    }

