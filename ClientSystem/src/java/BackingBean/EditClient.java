package BackingBean;

import Controller.DBController;
import DBModel.AttendDateTB;
import DBModel.ClientTB;
import DBModel.CourseTB;
import Utils.Utils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.validator.constraints.NotBlank;

@SessionScoped
@Named
public class EditClient implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String gender;
    @NotBlank
    private String address;
    @NotBlank
    private String course;
    @NotBlank
    private String date;
    
    private ClientTB client;
    
    @EJB
    private DBController dbc;
    
    public EditClient() {}
    
    public String toEdit(ClientTB client) {
        this.name = client.getClientName();
        this.gender = client.getGender();
        this.address = client.getAddress();
        this.course = client.getCourse().getName();
        Date d = client.getAttendDate().get(0).getAttendDate();
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(d);
        return "edit_client.xhtml";
    }
    
    public String edit() throws ParseException {
        Date attendDate = Utils.convertDate(date);
        ClientTB clientTB = new ClientTB(name, gender, address);
        CourseTB courseTB = dbc.getCourse(course);
        AttendDateTB attendDateTB = new AttendDateTB(attendDate);
        clientTB.setCourse(courseTB);
        clientTB.setAttendDate(attendDateTB);
        dbc.add(clientTB);
        return "client_list.xhtml";
    }
    
    public String toConfirm() {
        return "edit_confirm.xhtml";
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

    public ClientTB getClient() {
        return client;
    }

    public void setClient(ClientTB client) {
        this.client = client;
    }
}
