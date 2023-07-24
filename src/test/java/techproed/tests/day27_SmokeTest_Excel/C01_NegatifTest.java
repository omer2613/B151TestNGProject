package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegatifTest {
    @Test(groups = "smoke")
    public void test01() {
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found
        //...................................................//

        //BlueRental sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //login butonuna basalim
        BlueRentalPage rentalPage=new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                                    ConfigReader.getProperty("fakePassword"),Keys.ENTER);
        //Hata mesajinin görünür oldugunu dogrula
        ReusableMethods.visibleWait(rentalPage.mesajVerify,5);
        Assert.assertTrue(rentalPage.mesajVerify.isDisplayed());

        //sayfayi kapatalim
        Driver.closeDriver();

    }
}
