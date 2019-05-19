package Utils;

import Controller.DBController;
import DBModel.CourseTB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;

@SessionScoped
@Named
public class Selection implements Serializable {
    private ArrayList<SelectItem> genderItems;
    private ArrayList<SelectItem> courseItems;
    
    @EJB
    private DBController dbc;
    
    public Selection() {}
    
    private void createGenders() {
        genderItems = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        arr.add("Man");
        arr.add("Woman");
        for(String str: arr) {
            final SelectItem item = new SelectItem();
            item.setLabel(str);
            item.setValue(str);
            genderItems.add(item);
        }
    }
    
    private void createCourses() {
        courseItems = new ArrayList<>();
        for(CourseTB model: dbc.getCourseList()) {
            final SelectItem item = new SelectItem();
            item.setLabel(model.getCourseName());
            item.setValue(model.getCourseName());
            courseItems.add(item);
        }
    }

    public ArrayList<SelectItem> getGenderItems() {
        createGenders();
        return genderItems;
    }

    public void setGenderItems(ArrayList<SelectItem> genderItems) {
        this.genderItems = genderItems;
    }

    public ArrayList<SelectItem> getCourseItems() {
        createCourses();
        return courseItems;
    }

    public void setCourseItems(ArrayList<SelectItem> courseItems) {
        this.courseItems = courseItems;
    }
}
