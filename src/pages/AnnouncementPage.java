package studyMateProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class AnnouncementPage {

    public AnnouncementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Random random = new Random();

    @FindBy(xpath = "//li[.='Announcements']")
    public WebElement announcementTab;

    @FindBy(xpath = "//header/button")
    public WebElement addAnnouncementBtn;

    @FindBy(tagName = "textarea")
    public WebElement announcementText;

    @FindBy(id = "mui-component-select-groups")
    public WebElement groupDropdown;

    @FindBy(xpath = "(//ul)[6]/li")
    public List<WebElement> groupDropdownOptions;

    @FindBy(xpath = "//form//button[1]")
    public WebElement announcementFormCancelBtn;

    @FindBy(xpath = "//form//button[2]")
    public WebElement announcementFormAddBtn;

    @FindBy(xpath = "//p[.='pagination.show']/../p[2]")
    public WebElement totalResult;

    @FindBy(xpath = "((//div/header)[2]/..//div/span)[1]")
    public WebElement firstAnnouncementStatus;

    @FindBy(xpath = "((//header)[2]/../div[2]//button)[1]")
    public WebElement threeDotsBtn;

    @FindBy(xpath = "(//ul)[2]/li")
    public List<WebElement> threeDotsOptions;

    public void addAnnouncement(String text){
        addAnnouncementBtn.click();
        announcementText.sendKeys(text);
        groupDropdown.click();
        int randomGroup = random.nextInt(groupDropdownOptions.size());
        groupDropdownOptions.get(randomGroup).click();
        announcementFormAddBtn.click();
    }

    public int getTotalAnnouncements(){
        String totalResultStr = totalResult.getText();
        String totalNum = totalResultStr.substring(totalResultStr.indexOf(" ") + 1);
        int totalNumInt = Integer.parseInt(totalNum.trim());
        return totalNumInt;
    }
}
