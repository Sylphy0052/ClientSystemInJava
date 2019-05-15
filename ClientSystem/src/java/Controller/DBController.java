package Controller;

import DBModel.ClientTB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DBController {
    @PersistenceContext
    private EntityManager em;
    
    public DBController() {}
    
    public List<ClientTB> getClients() {
        return em.createQuery("SELECT c FROM ClientTB c").getResultList();
    }
    
}
