
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named
public class BeanSample implements Serializable {

    private String message = "Top Page";

    @EJB
    private DBController dbc;

    public BeanSample() {
    }

    public String next() {
        try {
            CourseTB course = dbc.getCourseList().get(0);
            DateTB date = new DateTB(Date.valueOf("2019-5-18"));
            UserTB user = new UserTB(date, course);
            dbc.add(user);
            message = "DB Registration";
        } catch(Exception e) {
            message = "Can't Regist";
            e.printStackTrace();
        }
        return null;
    }

    public String add() {
        createCourse();
        return null;
    }

    private void createCourse() {
        try {
            List<CourseTB> courseList = dbc.getCourseList();
            if (courseList.size() != 0) {
                message = "Course Table is already added";
            } else {
                CourseTB c1 = new CourseTB("A");
                CourseTB c2 = new CourseTB("B");
                CourseTB c3 = new CourseTB("C");
                dbc.add(c1);
                dbc.add(c2);
                dbc.add(c3);
                message = "Add Course Table";
            }
        } catch (EJBException e) {
            e.printStackTrace();
            message = "EJB Exception While Adding Course Table";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
