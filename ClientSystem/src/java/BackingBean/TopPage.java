package BackingBean;

import Controller.DBController;
import DBModel.CourseTB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named
public class TopPage implements Serializable {
    private String message = "";
    
    @EJB
    private DBController dbc;
    
    public TopPage() {}
    
    public String add() {
        createCourse();
        return null;
    }
    
    private void createCourse() {
        try {
            List<CourseTB> courseList = dbc.getCourseList();
            if(courseList.size() != 0) {
                message = "Course table is already added";
            } else {
                String[] arr = {"BASIC", "Bussiness", "TOEIC"};
                for(String name: arr) {
                    dbc.add(new CourseTB(name));
                }
                message = "Add course table";
            }
        } catch(EJBException e) {
            e.printStackTrace();
            message = "EJBException while adding course table";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
