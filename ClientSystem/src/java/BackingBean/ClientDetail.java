package BackingBean;

import DBModel.AttendDateTB;
import DBModel.ClientTB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class ClientDetail {
    private ClientTB client;
    
    public String goToDetail(ClientTB client) {
        this.client = client;
        return "client_detail.xhtml";
    }
    
    public int getClientId() {
        return client.getClientId();
    }
    
    public String getClientName() {
        return client.getClientName();
    }
    
    public String getGender() {
        return client.getGender();
    }
    
    public String getCourseName() {
        return client.getCourse().getCourseName();
    }
    
    public List<Date> getAttendDates() {
        List<AttendDateTB> attendDates = client.getAttendDate();
        ArrayList<Date> dates = new ArrayList<>();
        for(AttendDateTB adt: attendDates) {
            dates.add(adt.getAttendDate());
        }
        return dates;
    }
}
