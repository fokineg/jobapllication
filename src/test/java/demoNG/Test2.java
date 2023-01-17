package demoNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Egor
 */
public class Test2 {
    
    public Test2() {
    }

    @Test
    public void equalTest() {
        Test1.driver.get("https://ya.ru");
        Assert.assertEquals( Test1.driver.getTitle(),"Яндекс"
                ,"Some Message");
    }

}
