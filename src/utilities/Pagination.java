package utilities;

import org.openqa.selenium.By;

public class Pagination {

    public static int getNumberOfItems(){
        String resultStr = Driver.getDriver().findElement(By.xpath("//p[2]")).getText();
        int result = Integer.parseInt(resultStr.substring(16));
        return result;
    }
}
