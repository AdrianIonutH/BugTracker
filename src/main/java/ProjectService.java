import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
    public void updateProject(Project updateProject) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(updateProject);
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
    public void selectAllProject() {
        try {
            String sql = "from Project";
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Project> project = session.createQuery(sql).list();
            for (int i = 0; i<project.size(); i++){
                System.out.println("Proiect: "+project.get(i).projectId+". "+project.get(i).name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
