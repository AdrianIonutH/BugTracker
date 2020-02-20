import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService {
    private static ProjectService instance;
    private ProjectService(){

    }
    public static ProjectService getInstance(){
        if (instance == null){
            instance = new ProjectService();
        }
        return instance;
    }
    public Project getProject(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Project projectById = session.find(Project.class, id);
            System.out.println(projectById);
            return projectById;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void createProject(int itemId, Comment createComment){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(createComment);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void updateProject(int id, String updateProject) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Project projectById = getProject(id);
            projectById.name = updateProject;
            session.update(projectById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deleteProject(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Project projectById = getProject(id);
            session.delete(projectById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
