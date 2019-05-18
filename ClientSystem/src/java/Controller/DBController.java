package Controller;

import DBModel.ClientTB;
import DBModel.CourseTB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DBController {
    @PersistenceContext
    private EntityManager em;
    
    public DBController() {}
    
    public void add(ClientTB client) {
        em.persist(client);
    }
    
    public void add(CourseTB course) {
        em.persist(course);
    }
    
    public List<ClientTB> getClients() {
        return em.createQuery("SELECT c FROM ClientTB c").getResultList();
    }
    
    public List<CourseTB> getCourseList() {
        return em.createQuery("SELECT c FROM CourseTB c").getResultList();
    }
    
}
