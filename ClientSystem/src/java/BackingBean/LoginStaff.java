package BackingBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class LoginStaff {
    private String staffId;
    private String pass;
    
    public LoginStaff(){}
    
    public String login() {
        if(staffId.equals("111") && pass.equals("admin")) {
            return "main.xhtml";
        } else {
            return null;
        }
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staff_id) {
        this.staffId = staff_id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
