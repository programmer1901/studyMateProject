package studyMateProject.pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentPage {

    public StudentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
