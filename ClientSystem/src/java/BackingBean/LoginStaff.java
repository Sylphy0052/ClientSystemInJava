package BackingBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

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
    
}
