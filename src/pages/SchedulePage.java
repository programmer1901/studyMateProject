package studyMateProject.pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SchedulePage {

    public SchedulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
