package test.tests;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.CoursePage;
import pages.LoginPage;
import pages.TeacherPage;
import utilities.*;

import java.util.ArrayList;
import java.util.Random;

import static utilities.Driver.driver;

public class CoursePageTest {
    CoursePage coursePage = new CoursePage();
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    TeacherPage teacherPage = new TeacherPage();
    Faker faker = new Faker();
    @Test
    public void assigningTeacherToCourseVerification() {

        Driver.getDriver().get(Config.getValue("studyMateUrl"));
        // I have to log in with existing teachers credentials
        loginPage.login(Config.getValue("studyMateTeacherLoginEmail"),Config.getValue("studyMateTeacherLoginPassword"));
        Flow.wait(1000);
        int NumberOfCourseBeforeAssigningCourse = Pagination.getNumberOfItems();
        teacherPage.teacherLogout();

        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        coursePage.coursesTab.click();
        coursePage.createCourseBtn.click();
        coursePage.courseNameInputBox.sendKeys(faker.educator().course());
        coursePage.dateOfFinishBox.sendKeys("01.01.2023");
        coursePage.descriptionInputBox.sendKeys("Description");
        coursePage.saveBtn.click();
        Flow.wait(1000);
        Flow.scrollDown(200);
        Flow.wait(1000);
        Pagination.getNumberOfItems();
        String totalNumberOfCourses = Integer.toString(Pagination.getNumberOfItems());
        coursePage.paginationInput.sendKeys(Keys.BACK_SPACE);
        coursePage.paginationInput.sendKeys(totalNumberOfCourses+Keys.ENTER);
        //coursePage.paginationInput.sendKeys(Keys.ENTER);
        Flow.scrollDown(1000);
        Flow.wait(500);
        Driver.getDriver().manage().window().fullscreen();
        coursePage.threeDotsBtn.get(coursePage.listOfCourses.size() - 1).click();
        Flow.wait(1000);
        coursePage.assignTeacherOption.get(coursePage.listOfCourses.size() - 1).click();
        coursePage.assignTeacherBtn.click();
        Flow.wait(1000);

        Random random = new Random();
        String teacherName = "Ilgiz Babanov";
        for (WebElement teacher : coursePage.listOfTeachers){
            if(teacher.getText().equals(teacherName)){
                System.out.println(teacher.getText());
                teacher.click();
            }
        }
        coursePage.listOfTeachers.get(random.nextInt(coursePage.listOfTeachers.size())).click();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
        Flow.wait(1000);
        coursePage.saveBtnAssignTeacher.click();

        String expectedMessage = "Instructors successfully added to the course";
        String actualMessage = coursePage.assignTeacherConfirmationMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
        Flow.wait(5000);
        adminPage.adminLogout();
        loginPage.login(Config.getValue("studyMateTeacherLoginEmail"),Config.getValue("studyMateTeacherLoginPassword"));
        Flow.wait(2000);
        int NumberOfCourseAfterAssigningCourse = Pagination.getNumberOfItems();
        Assert.assertTrue("Assign teacher verification failed",NumberOfCourseAfterAssigningCourse>NumberOfCourseBeforeAssigningCourse);
        Driver.quitBrowser();
    }

    @Test
    public void removeTeacherFromCourseVerification(){
        Driver.getDriver().get(Config.getValue("studyMateUrl"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        coursePage.coursesTab.click();
        Pagination.getNumberOfItems();
        String totalNumberOfCourses = Integer.toString(Pagination.getNumberOfItems());
        coursePage.paginationInput.sendKeys(Keys.BACK_SPACE);
        coursePage.paginationInput.sendKeys(totalNumberOfCourses);
        coursePage.paginationInput.sendKeys(Keys.ENTER);
        Flow.scrollDown(1000);
        Flow.wait(500);

        coursePage.listOfCourses.get(coursePage.listOfCourses.size()-1).click();
        coursePage.deleteTeacherFromCourse.click();



    }

}


