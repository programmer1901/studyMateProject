package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Flow;

import java.util.List;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[.='Administrator']")
    public WebElement administratorUser;

    @FindBy(xpath = "//nav/a")
    public List<WebElement> sidebarOptions;

    @FindBy(xpath = "(//h2)[2]/../div/button[2]")
    public WebElement logoutConfirmationPopup;

    @FindBy(xpath = "((//div/header)[2]/..//div/button)[1]")
    public WebElement threeDotsButton;

    @FindBy(xpath = "(//ul)[2]/li")
    public List<WebElement> threeDotsOptions;

    @FindBy(id = "modal")
    public WebElement editGroupForm;

    @FindBy(xpath = "//div[@id='modal']/p")
    public WebElement formHeaderText;

    @FindBy(xpath = "//form[@id='group-form']/div[1]//input")
    public WebElement image;

    @FindBy(xpath = "//form//p")
    public WebElement underImageText;

    @FindBy(xpath = "(//form[@id='group-form'])/div[3]/button[1]")
    public WebElement formCancelBtn;

    @FindBy(xpath = "(//form[@id='group-form'])/div[3]/button[2]")
    public WebElement formSaveBtn;

    @FindBy(xpath = "//div[@id='root']/div[2]//p")
    public WebElement successfulGroupUpdateMessage;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement groupNameInputBox;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement groupDescriptionField;

    @FindBy(xpath = "((//div/header)[2]/..//div/span/../div)[1]")
    public WebElement groupNameOnMainPageCard;

    @FindBy(xpath = "((//div/header)[2]/..//div/p)[1]")
    public WebElement groupDescriptionOnMainPage;

    public WebElement logoutBtn(){
        List<WebElement> ulOptions = Driver.getDriver().findElements(By.tagName("ul"));
        int logoutOption = ulOptions.size();
        String xpath = "(//ul)[" + logoutOption + "]/li";
        WebElement logoutButton = Driver.getDriver().findElement(By.xpath(xpath));
        return logoutButton;
    }

    public void adminLogout(){
        administratorUser.click();
        Flow.wait(500);
        logoutBtn().click();
        Flow.wait(500);
        logoutConfirmationPopup.click();
    }

    public void clearWebField(WebElement element){
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void editGroupBtnClick(){
        Flow.wait(1000);
        threeDotsButton.click();
        Flow.wait(300);
        threeDotsOptions.get(0).click();
        Flow.wait(500);
    }
}


