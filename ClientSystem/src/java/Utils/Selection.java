package PageUtils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Selection {
    private ArrayList<SelectItem> genders;
    private ArrayList<SelectItem> courses;
    
    public Selection() {
        createGenders();
        createCourses();
    }
    
    private void createGenders() {
        genders = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        arr.add("Man");
        arr.add("Woman");
        for(String str: arr) {
            final SelectItem item = new SelectItem();
            item.setLabel(str);
            item.setValue(str);
            genders.add(item);
        }
    }
    
    private void createCourses() {
        courses = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        arr.add("Basic Course");
        arr.add("Bussiness Course");
        arr.add("TOEIC Course");
        for(String str: arr) {
            final SelectItem item = new SelectItem();
            item.setLabel(str);
            item.setValue(str);
            courses.add(item);
        }
    }

    public ArrayList<SelectItem> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<SelectItem> genders) {
        this.genders = genders;
    }

    public ArrayList<SelectItem> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<SelectItem> courses) {
        this.courses = courses;
    }
}
