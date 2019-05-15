package BackingBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class LoginStaff {
    private String staff_id;
    private String pass;
    
    public LoginStaff(){}
    
    public String login() {
        if(staff_id.equals("111") && pass.equals("admin")) {
            return "main.xhtml";
        } else {
            return null;
        }
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
