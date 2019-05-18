import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DBController {
    @PersistenceContext
    private EntityManager em;
    
    public DBController() {}
    
    public void add(CourseTB c) {
        em.persist(c);
    }
    
    public void add(DateTB d) {
        em.persist(d);
    }
    
    public void add(UserTB u) {
        em.persist(u);
    }
    
    public List<CourseTB> getCourseList() {
        return em.createQuery("SELECT c FROM CourseTB c").getResultList();
    }
}
