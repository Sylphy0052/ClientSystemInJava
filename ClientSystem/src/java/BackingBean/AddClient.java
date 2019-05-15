package BackingBean;

import Controller.DBController;
import DBModel.AttendDateTB;
import DBModel.ClientTB;
import DBModel.CourseTB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class AddClient {
    private String name;
    private String gender;
    private String address;
    private String course;
    private String date;
    
    @EJB
    private DBController dbc;
    
    public AddClient() {}
    
    public String addClient() throws ParseException {
        Date attendDate = convertDate(date);
        ClientTB clientTB = new ClientTB(name, gender, address);
        CourseTB courseTB = new CourseTB(course);
        AttendDateTB attendDateTB = new AttendDateTB(attendDate);
        clientTB.setCourse(courseTB);
        clientTB.setAttendDate(attendDateTB);
        dbc.add(clientTB);
        return "client_list.xhtml";
    }
    
    private Date convertDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DBController getDbc() {
        return dbc;
    }

    public void setDbc(DBController dbc) {
        this.dbc = dbc;
    }
    
    
    
}
