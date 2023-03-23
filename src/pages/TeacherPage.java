package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Flow;

import java.util.List;

public class TeacherPage {

    public TeacherPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // Ilgiz's locators for course page
    @FindBy(xpath = "(//h2)[2]/../div/button[2]")
    public WebElement logoutConfirmationPopup;

    @FindBy (xpath = "//p[.='Teacher']")
    public WebElement teacherUser;
    public void teacherLogout(){
        teacherUser.click();
        Flow.wait(500);
        logoutBtn().click();
        Flow.wait(500);
        logoutConfirmationPopup.click();
    }
    public WebElement logoutBtn(){
        List<WebElement> ulOptions = Driver.getDriver().findElements(By.tagName("ul"));
        int logoutOption = ulOptions.size();
        String xpath = "(//ul)[" + logoutOption + "]/li";
        WebElement logoutButton = Driver.getDriver().findElement(By.xpath(xpath));
        return logoutButton;
    }
}

