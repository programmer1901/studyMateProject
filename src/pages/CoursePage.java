package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;

public class CoursePage {

    public CoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div/nav/a)[2]")
    public WebElement coursesTab;

    @FindBy(xpath = "(//button)[1]")
    public WebElement createCourseBtn;

    @FindBy(id = "modal")
    public WebElement createCourseForm;

    @FindBy(xpath = "//div[@id='modal']/p")
    public WebElement createCourseFormHeader;

    @FindBy(name = "courseName")
    public WebElement courseNameInputBox;

    @FindBy(xpath = "//form[@id='courseForm']/div[2]//label[1]")
    public WebElement courseNameInputBoxPlaceholder;

    @FindBy(name = "dateOfFinish")
    public WebElement dateOfFinishBox;

    @FindBy(xpath = "(//form[@id='courseForm']/div[2]//label)[2]")
    public WebElement dateOfFinishBoxPlaceholder;

    @FindBy(xpath = "//div/textarea")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "(//form[@id='courseForm']/div[2]//label)[3]")
    public WebElement descriptionInputBoxPlaceholder;

    @FindBy(xpath = "//form[@id='courseForm']/div[1]/p")
    public WebElement uploadPhotoIconText;

    @FindBy(xpath = "//form[@id='courseForm']/div[1]//input")
    public WebElement uploadPhotoIcon;

    @FindBy(xpath = "//form[@id='courseForm']//button[1]")
    public WebElement calendarBtn;

    @FindBy(xpath = "(//form[@id='courseForm']//button)[3]")
    public WebElement createBtn;

    @FindBy(xpath = "//form/div[3]/button[1]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//form/div[3]/button[2]")
    public WebElement saveBtn;

    @FindBy(xpath = "//p[.='pagination.show']/../p[2]")
    public WebElement totalResult;

    @FindBy(xpath = "(//header)[2]/../div/div[1]//button[1]")
    public List<WebElement> threeDotsBtn;

    @FindBy(xpath = "(//header)[2]/../div/div[1]//button[1]/../../..")
    public  List<WebElement> listOfCourses;

    @FindBy(xpath = "(//ul)[2]/li")
    public List<WebElement> threeDotBtnOptions;

    @FindBy(name = "courseName")
    public WebElement formCourseName;

    @FindBy(xpath = "((//div/header)[2]/..//div/span/../div)[1]")
    public WebElement courseNameOnMainPage;

    public int getTotalCourses() {
        String totalResultStr = totalResult.getText();
        String totalNumberStr = totalResultStr.substring(totalResultStr.indexOf(" ") + 1);
        int totalNumberInt = Integer.parseInt(totalNumberStr.trim());
        return totalNumberInt;
    }


    // Ilgiz's locators for the second sprint 2nd spring:
    @FindBy(xpath = "//form/../div/button[2]")
    public WebElement saveBtnAssignTeacher;

    @FindBy(xpath = "//*[@role='listbox']/li")
    public List<WebElement> listOfTeachers;

    @FindBy (xpath = "//*[@role='button']")
    public  WebElement assignTeacherBtn;

    @FindBy (xpath = "(//input)[2]")
    public WebElement paginationInput;

    // temporary locator for a specific teacher related to the task
    @FindBy (xpath = "(//table/tbody/tr//td[.='Ilgiz Babanov']/../td)[6]/*")
    public WebElement deleteTeacherFromCourse;

    @FindBy (xpath = "//div[@role='presentation']/div/ul/li[1]")
    public List<WebElement> assignTeacherOption;

    @FindBy (xpath = "//div[@role='alert']/../../div/div/div/p")
    public  WebElement assignTeacherConfirmationMessage;

    public void clearWebField(WebElement element) {
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.ESCAPE);
        }
    }
}