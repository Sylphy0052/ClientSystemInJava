package BackingBean;

import Controller.DBController;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class LoginStaff {
    private String name;
    private String pass;
    
    private String message = "";
    
    @EJB
    DBController dbc;
    
    public LoginStaff(){}
    
    public String login() {
        if(checkLogin()) {
            return "main.xhtml";
        } else {
            message = "Invalid name or password";
            return null;
        }
    }
    
    private boolean checkLogin() {
        return dbc.getStaff(name, pass) != null;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
