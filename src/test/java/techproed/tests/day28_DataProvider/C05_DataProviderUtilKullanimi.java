package techproed.tests.day28_DataProvider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtil;

public class C05_DataProviderUtilKullanimi {
    @Test(dataProvider = "sehirVerileri",dataProviderClass = DataProviderUtil.class)//-->util e attik
    public void test01(String sehir,String bolge,String plaka) {
        System.out.println(sehir+" | "+bolge+" | "+plaka);
    }
}
