package BackingBean;

import Controller.DBController;
import DBModel.StaffTB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class RegistStaff implements Serializable {
    private String name;
    private String pass;
    
    private List<StaffTB> staffList;
    
    @EJB
    private DBController dbc;
    
    public RegistStaff() {}
    
    public String delete(StaffTB staff) {
        dbc.delete(staff);
        return null;
    }
    
    public String regist() {
        dbc.add(new StaffTB(name, pass));
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<StaffTB> getStaffList() {
        staffList = dbc.getStaffList();
        return staffList;
    }

    public void setStaffList(List<StaffTB> staffList) {
        this.staffList = staffList;
    }
}
