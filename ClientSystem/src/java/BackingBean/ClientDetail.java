package BackingBean;

import Controller.DBController;
import DBModel.AttendDateTB;
import DBModel.ClientTB;
import Utils.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class ClientDetail implements Serializable {
    private ClientTB client;
    
    @EJB
    private DBController dbc;
    
    public ClientDetail() {}
    
    public String goToDetail(ClientTB client) {
        this.client = client;
        return "client_detail.xhtml";
    }
    
    public String delete() {
        dbc.delete(client);
        return "client_list.xhtml";
    }
    
    public ClientTB getClient() {
        return client;
    }
    
    public void setClient(ClientTB client) {
        this.client = client;
    }
    
    public int getClientId() {
        return client.getClientId();
    }
    
    public void setClientId(int clientId) {
        this.client.setClientId(clientId);
    }
    
    public String getName() {
        return client.getClientName();
    }
    
    public void setName(String clientName) {
        this.client.setClientName(clientName);
    }
    
    public String getGender() {
        return client.getGender();
    }
    
    public void setGender(String gender) {
        this.client.setGender(gender);
    }
    
    public String getAddress() {
        return client.getAddress();
    }
    
    public void setAddress(String address) {
        this.client.setAddress(address);
    }
    
    public String getCourse() {
        return client.getCourse().getName();
    }
    
    public void setCourse(String course) {
        this.client.setCourse(dbc.getCourse(course));
    }
    
    public Date getDate() {
        return client.getAttendDate().get(0).getAttendDate();
    }
    
    public void setDate(String date) {
        Date d = Utils.convertDate(date);
        AttendDateTB adt = new AttendDateTB(d);
        client.setAttendDate(adt);
    }
    
    public List<Date> getAttendDates() {
        List<AttendDateTB> attendDates = client.getAttendDate();
        ArrayList<Date> dates = new ArrayList<>();
        attendDates.forEach((adt) -> {
            dates.add(adt.getAttendDate());
        });
        return dates;
    }
}
