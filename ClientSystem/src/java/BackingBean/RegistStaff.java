package BackingBean;

import Controller.DBController;
import DBModel.StaffTB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class RegistStaff implements Serializable {
    private String name;
    private String pass;
    
    private List<StaffTB> staffList;
    
    private String message = "";
    
    @EJB
    private DBController dbc;
    
    public RegistStaff() {}
    
    public String delete(StaffTB staff) {
        dbc.delete(staff);
        return null;
    }
    
    public String regist() {
        try {
            if(dbc.getStaff(name) != null) {
                message = "Staff Name is duplication";
            }
        }catch(EJBException e) {
            dbc.add(new StaffTB(name, pass));
            clear();
            message = "Staff Registration is Success";
        }
        return null;
    }
    
    public void clear() {
        name = "";
        pass = "";
        message = "";
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
